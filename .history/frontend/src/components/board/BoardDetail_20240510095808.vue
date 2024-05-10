<template>
  <div v-if="isOpen" class="modal">
    <!-- 모달 코드 생략 -->
    <h2 class="text-2xl font-bold">{{ board.title }}</h2>
    <div>
      <span>{{ board.userId }}</span> • {{ board.date }}
    </div>
    <div class="prose prose-sm dark:prose-invert">
      <p>{{ board.content }}</p>
    </div>
    <!-- 나머지 코드 생략 -->
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
  background-color: rgba(0, 0, 0, 0.6);
  display: flex;
  justify-content: center;
  align-items: center;
  z-index: 1000; /* 높은 z-index 값 설정 */
}

.no-scroll {
  overflow: hidden; /* 스크롤 방지 */
}
</style>
