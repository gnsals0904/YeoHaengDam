<template>
  <div v-if="isOpen" class="modal">
    <div class="modal-content">
      <h3>{{ board.subject }}</h3>
      <p>{{ board.content }}</p>
      <button @click="close">Close</button>
    </div>
  </div>
</template>

<script setup>
const props = defineProps({
  board: Object,
  isOpen: Boolean,
});

const emit = defineEmits(["close"]);

function close() {
  emit("close");
}
</script>

<style scoped>
.modal {
  position: fixed;
  left: 0;
  top: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.6); /* 배경 투명도 조정 */
  display: flex;
  justify-content: center;
  align-items: center;
}

.modal-content {
  width: 80%; /* 모달 너비를 80%로 설정 */
  min-width: 500px; /* 최소 너비를 500px로 설정 */
  background: white;
  padding: 40px; /* 패딩을 40px로 설정 */
  border-radius: 10px;
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1); /* 상자 그림자 추가 */
}
</style>
