// board.js
import { ref } from 'vue';
import { defineStore } from 'pinia';
import axios from 'axios';

export const useBoardStore = defineStore('board', () => {
  const boardList = ref([])
  const selectedBoard = ref(null);
  
  const getList = () => {
    axios.get("http://localhost:80/api/board/list")
      .then((response) => {
        console.log(response);
        boardList.value = response.data;
      })
      .catch((error) => {
        console.error(error)
      })
  };

    const getArticle = (articleNo) => {
      axios.get(`http://localhost:80/api/board/view`, { params: { articleNo } })
        .then((response) => {
            selectedBoard.value = response.data;
        })
        .catch((error) => {
            console.error(error);
        });
    };
  
  
  
    return {
      boardList,
      getList,
      getArticle,
    }
  });
