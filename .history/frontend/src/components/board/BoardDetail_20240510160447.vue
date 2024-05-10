<template>
  <div
    class="relative mx-4 w-full max-w-2xl rounded-lg bg-white p-6 shadow-lg dark:bg-gray-900 sm:p-8"
  >
    <!-- Close 버튼 구현 -->
    <button
      @click="close"
      class="absolute top-4 right-4 rounded-full p-2 text-gray-500 hover:bg-gray-100 hover:text-gray-900 focus:outline-none focus:ring-2 focus:ring-gray-950 dark:hover:bg-gray-800 dark:hover:text-gray-50 dark:focus:ring-gray-300"
    >
      <svg
        class="h-5 w-5"
        xmlns="http://www.w3.org/2000/svg"
        fill="none"
        viewBox="0 0 24 24"
        stroke="currentColor"
        stroke-width="2"
      >
        <path stroke-linecap="round" stroke-linejoin="round" d="M6 18L18 6M6 6l12 12" />
      </svg>
      <span class="sr-only">Close</span>
    </button>
    <!-- 게시글 상세 정보 표시 -->
    <div class="space-y-4">
      <h2 class="text-2xl font-bold">{{ board.subject }}</h2>
      <p>{{ board.content }}</p>
      <!-- 기타 정보 표시 생략 -->
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from "vue";
import { useRoute } from "vue-router";
import { useBoardStore } from "@/stores/board";

const route = useRoute();
const boardStore = useBoardStore();
const board = ref(null);

onMounted(async () => {
  try {
    const response = await boardStore.getArticle(route.params.articleNo);
    board.value = response.data; // 응답에서 데이터를 추출하여 저장
  } catch (error) {
    console.error("Error fetching board details:", error);
    // 에러 처리 로직, 예: 에러 메시지 표시
  }
});

const emit = defineEmits(["close"]);

function close() {
  emit("close");
}
</script>

<style scoped>
/* CSS 스타일 유지 */
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
