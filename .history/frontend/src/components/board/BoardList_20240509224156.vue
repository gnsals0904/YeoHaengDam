<template>
  <section>
    <div class="container">
      <div class="board-list">
        <!-- BoardCard 컴포넌트를 사용하여 게시글 데이터를 표시합니다. -->
        <BoardCard v-for="board in boardStore.boards" :key="board.id" :board="board" />
      </div>
    </div>
  </section>
</template>

<script setup>
import { onMounted } from "vue";
import { useBoardStore } from "@/stores/board";
import BoardCard from "../components/BoardCard.vue";

// Pinia 스토어 인스턴스를 가져옵니다.
const boardStore = useBoardStore();

// 컴포넌트가 마운트될 때 게시글 데이터를 불러옵니다.
onMounted(() => {
  boardStore.fetchBoards();
});
</script>

<style scoped>
/* 스타일 지정 */
</style>
