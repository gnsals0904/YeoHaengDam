<template>
  <div class="board-card">
    <h3>{{ board.subject }}</h3>
    <p>{{ board.content }}</p>
    <small>Posted by {{ board.userId }}</small>
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
