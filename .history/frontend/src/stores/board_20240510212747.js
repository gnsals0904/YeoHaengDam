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
  

  // getArticle 함수를 async 함수로 수정
  const getArticle = async (articleNo) => {
    try {
      const response = await axios.get(`http://localhost:80/api/board/view`, { params: { articleNo } });
      console.log("Fetched article:", response);
      selectedBoard.value = response.data;
      console.log('selectedBoards : ');
      console.log(selectedBoard);
      return response; // 완성된 응답 객체를 반환
    } catch (error) {
      console.error("Failed to fetch article:", error);
      throw error; // 에러를 재발생시켜 호출 측에서 처리할 수 있도록 함
    }
  };

  const deleteArticle = async (articleNo) => {
    try {
      await axios.get(`http://localhost:80/api/board/delete`, { params: { articleNo } });
      console.log("finish delete");
      return;
    } catch (error) {
      throw error;
    }
  }
    
    const modifyArticle = async (board) => {
      try {
        const updatedArticle = await axios.get(`http://localhost:80/api/board/update`, { params: { board } });
        console.log("finish update");
        return updatedArticle;
      } catch (error) {
        throw error;
      }
    };

  
  
  
    return {
      boardList,
      selectedBoard,
      getList,
      getArticle,
      deleteArticle,
      modifyArticle,
    }
  });
