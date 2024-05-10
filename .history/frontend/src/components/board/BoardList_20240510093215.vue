<template>
  <section class="bg-gray-100 dark:bg-gray-950 py-12 md:py-16 lg:py-20">
    <div class="container px-4 md:px-6">
      <div class="flex items-center justify-between mb-8 gap-4">
        <search-bar />
      </div>
      <div class="grid gap-8 md:grid-cols-2 lg:grid-cols-3">
        <BoardCard
          v-for="board in boardStore.boardList"
          :key="board.articleNo"
          :board="board"
          @click.native="openModal(1)"
        />
      </div>
      <pagination :current-page="currentPage" :total-pages="totalPages" @update:page="updatePage" />
    </div>
    <BoardDetail :board="selectedBoard" :isOpen="modalOpen" @close="modalOpen = false" />
  </section>
  <RouterView />
</template>

<script setup>
import { ref } from "vue";
import { RouterView } from "vue-router";
import { useBoardStore } from "@/stores/board";
import BoardDetail from "@/components/board/BoardDetail.vue";
import BoardCard from "@/components/board/BoardCard.vue";

const boardStore = useBoardStore();
const selectedBoard = ref(null);
const modalOpen = ref(false);

boardStore.getList();

const currentPage = ref(1);
const totalPages = ref(5);

function updatePage(newPage) {
  currentPage.value = newPage;
}

function openModal(articleId) {
  boardStore.getArticle(articleId); // 게시글 상세 정보 불러오기
  modalOpen.value = true;
}
</script>
