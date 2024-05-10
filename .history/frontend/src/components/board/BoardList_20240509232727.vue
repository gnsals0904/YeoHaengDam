<template>
  <section class="bg-gray-100 dark:bg-gray-950 py-12 md:py-16 lg:py-20">
    <div class="container px-4 md:px-6">
      <div class="flex items-center justify-between mb-8 gap-4">
        <search-bar />
      </div>
      <div class="grid gap-8 md:grid-cols-2 lg:grid-cols-3">
        <BoardCard v-for="board in boardStore.boardList" :key="board.id" :board="board" />
      </div>
      <pagination :current-page="currentPage" :total-pages="totalPages" @update:page="updatePage" />
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
