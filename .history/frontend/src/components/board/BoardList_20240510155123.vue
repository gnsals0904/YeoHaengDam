<template>
  <section class="bg-gray-100 dark:bg-gray-950 py-12 md:py-16 lg:py-20">
    <div class="container px-4 md:px-6">
      <div class="grid gap-8 md:grid-cols-2 lg:grid-cols-3">
        <BoardCard v-for="board in boardStore.boardList" :key="board.articleNo" :board="board" />
      </div>
      <Pagination :current-page="currentPage" :total-pages="totalPages" @update:page="updatePage" />
    </div>
  </section>
  <RouterView />
</template>

<script setup>
import { ref } from "vue";
import { RouterView } from "vue-router";
import { useBoardStore } from "@/stores/board";
import BoardCard from "@/components/board/BoardCard.vue";
import Pagination from "./Pagination.vue";

const boardStore = useBoardStore();
boardStore.getList();

const currentPage = ref(1);
const totalPages = ref(5);

function updatePage(newPage) {
  currentPage.value = newPage;
}
</script>
