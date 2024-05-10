// board.js
import { ref } from 'vue';
import { defineStore } from 'pinia';
import axios from 'axios';

export const useBoardStore = defineStore('board', {
  state: () => ({
    boards: ref([])  // 게시글 데이터를 저장할 배열
  }),
    actions: {
      
        axios.get("localhost:80/api/board/list")
            .then(response){
            
        }
    }
  }
});
