// board.js
import { ref } from 'vue';
import { defineStore } from 'pinia';
import axios from 'axios';

export const useBoardStore = defineStore('board', () => {
    const boardList = ref([])
  
    const getList = () => {
      axios.get("http://localhost:80/api/board/list")
        .then((response) => {
          boardList.value = response.data;
        })
        .catch((error) => {
          console.error(error)
        })
    }
  
  
  
    return {
      boardList,
      getList,
    }
  });
