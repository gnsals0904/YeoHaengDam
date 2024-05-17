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

<template>
  <div class="relative min-h-screen">
    <div class="bg-cover w-full flex justify-center items-center">
      <div
        class="w-full bg-white bg-opacity-40 backdrop-filter backdrop-blur-lg"
      >
        <div
          class="w-12/12 mx-auto rounded-2xl bg-white p-5 bg-opacity-40 backdrop-filter backdrop-blur-lg"
        >
          <div
            class="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-4 gap-5 text-center px-3 mx-auto"
          >
            <BoardCard
              v-for="board in boardStore.boardList"
              :key="board.articleId"
              :board="board"
            />
          </div>
          <Pagination
            :current-page="currentPage"
            :total-pages="totalPages"
            @update:page="updatePage"
          />
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped></style>
