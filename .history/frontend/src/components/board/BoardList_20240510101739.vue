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
          @open="openModal"
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

async function openModal(articleNo) {
  console.log(articleNo);
  try {
    // API 호출 결과를 기다립니다.
    const response = await boardStore.getArticle(articleNo);
    selectedBoard.value = response; // 게시글 정보를 selectedBoard에 저장
    modalOpen.value = true; // 데이터 로드 완료 후 모달 열기
  } catch (error) {
    console.error("Failed to fetch board details:", error);
  }
}
</script>
