// board.js
import { defineStore } from 'pinia';
import axios from 'axios';

export const useBoardStore = defineStore('board', {
  state: () => ({
    boards: []  // 게시글 데이터를 저장할 배열
  }),
  actions: {
    async fetchBoards() {
      try {
        const response = await axios.get('http://localhost:8080/board/list');
        this.boards = response.data;  // 응답 데이터를 상태에 저장
      } catch (error) {
        console.error('Error fetching board data:', error);
        // 오류 처리 로직을 여기에 추가할 수 있습니다.
      }
    }
  }
});
