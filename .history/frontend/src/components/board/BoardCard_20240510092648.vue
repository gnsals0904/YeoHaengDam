<template>
  <div @click="$emit('click', board.articleNo)">
    <a
      class="group relative overflow-hidden rounded-lg shadow-lg hover:shadow-xl transition-transform duration-300 ease-in-out hover:-translate-y-2"
      href="#"
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
    </a>
  </div>
</template>

<script setup>
// BoardCard 컴포넌트가 받을 props를 정의합니다.
const props = defineProps({
  board: {
    type: Object,
    required: true,
  },
});
</script>

<style scoped>
/* 카드 스타일 지정 */
.board-card {
  border: 1px solid #ccc;
  padding: 20px;
  margin-bottom: 10px;
  border-radius: 5px;
}
</style>
