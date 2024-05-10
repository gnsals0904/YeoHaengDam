<template>
  <section>
    <div class="container">
      <div class="board-list">
        <!-- BoardCard 컴포넌트를 사용하여 게시글 데이터를 표시합니다. -->
        <BoardCard v-for="board in boardStore.boards" :key="board.id" :board="board" />
      </div>
    </div>
  </section>
  <RouterView />
</template>

<script setup>
import { RouterView } from "vue-router";
import BoardCard from "@/components/board/BoardCard.vue";

import { useBoardStore } from "@/stores/board";

const boardStore = useBoardStore();

boardStore.getList();
</script>

<style scoped>
/* 스타일 지정 */
</style>
