<template>
  <div v-if="board" class="board-detail">
    <h1>{{ board.title }}</h1>
    <p>{{ board.content }}</p>
    <!-- 기타 게시글 정보 출력 -->
  </div>
</template>

<script setup>
import { onMounted, ref } from "vue";
import { useRoute } from "vue-router";
import { useBoardStore } from "@/stores/board";

const route = useRoute();
const boardStore = useBoardStore();
const board = ref(null);

onMounted(async () => {
  const articleNo = route.params.articleNo;
  try {
    const response = await boardStore.getArticle(articleNo);
    board.value = response.data; // API 응답에서 데이터만 추출하여 저장
  } catch (error) {
    console.error("Failed to fetch article details:", error);
  }
});
</script>

<style scoped>
/* CSS 스타일 */
</style>
