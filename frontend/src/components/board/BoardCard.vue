<script setup>
import { useRouter } from 'vue-router';
import { useBoardStore } from '@/stores/board';

const router = useRouter();
const boardStore = useBoardStore();

async function loadAndNavigate(articleNo) {
  await boardStore.getArticle(articleNo); // 데이터 로드를 기다림
  router.push({ name: 'detail', params: { articleNo } }); // 데이터 로드 후 페이지 이동
}

const props = defineProps({
  board: {
    type: Object,
    required: true,
  },
});
</script>

<template>
  <div
    class="group relative overflow-hidden rounded-lg shadow-lg hover:shadow-xl transition-transform duration-300 ease-in-out hover:-translate-y-2"
    @click="loadAndNavigate(board.articleNo)"
  >
    <img
      :src="board.imageUrl"
      :alt="board.title"
      width="360"
      height="240"
      class="object-cover w-full aspect-[3/2] group-hover:opacity-50 transition-opacity"
    />
    <div
      class="absolute inset-0 z-10 flex flex-col justify-end p-4 bg-gradient-to-t from-gray-900/80 to-transparent"
    >
      <div class="text-white text-lg font-semibold group-hover:underline">
        {{ board.subject }}
      </div>
      <div class="text-gray-300 text-sm">
        <span class="font-medium">{{ board.userId }}</span> • {{ board.date }}
      </div>
      <div class="text-gray-300 text-sm mt-2">
        <svg-icon icon="heart" class="w-4 h-4 mr-1 inline" />
        {{ board.likes }} likes
        <span class="mx-2">•</span>
        <svg-icon icon="eye" class="w-4 h-4 mr-1 inline" />
        {{ board.hit }} views
      </div>
    </div>
  </div>
</template>

<style scoped>
/* Card style */
.board-card {
  border: 1px solid #ccc;
  padding: 20px;
  margin-bottom: 10px;
  border-radius: 5px;
}
</style>
