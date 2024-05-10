<template>
  <div class="space-y-4">
        <div class="flex items-center justify-between">
          <h2 class="text-2xl font-bold">{{ board.subject }}</h2>
          <div class="flex items-center space-x-4 text-sm text-gray-500 dark:text-gray-400">
            <div>
              <svg
                xmlns="http://www.w3.org/2000/svg"
                width="24"
                height="24"
                viewBox="0 0 24 24"
                fill="none"
                stroke="currentColor"
                stroke-width="2"
                stroke-linecap="round"
                stroke-linejoin="round"
                class="mr-1 inline-block h-4 w-4 fill-primary"
              >
                <path
                  d="M19 14c1.49-1.46 3-3.21 3-5.5A5.5 5.5 0 0 0 16.5 3c-1.76 0-3 .5-4.5 2-1.5-1.5-2.74-2-4.5-2A5.5 5.5 0 0 0 2 8.5c0 2.3 1.5 4.05 3 5.5l7 7Z"
                ></path>
              </svg>
              1.2K
            </div>
            <div>
              <svg
                xmlns="http://www.w3.org/2000/svg"
                width="24"
                height="24"
                viewBox="0 0 24 24"
                fill="none"
                stroke="currentColor"
                stroke-width="2"
                stroke-linecap="round"
                stroke-linejoin="round"
                class="mr-1 inline-block h-4 w-4 fill-primary"
              >
                <path d="M2 12s3-7 10-7 10 7 10 7-3 7-10 7-10-7-10-7Z"></path>
                <circle cx="12" cy="12" r="3"></circle>
              </svg>
              {{ board.hit }}
            </div>
          </div>
        </div>
        <div class="flex items-center space-x-4 text-sm text-gray-500 dark:text-gray-400">
          <div>{{ board.userId }}</div>
          <div>•</div>
          <div>{{ board.registerTime }}</div>
        </div>
        <div class="prose prose-sm dark:prose-invert">
          <p v-if="board">
            {{ board.content }}
          </p>
        </div>
      </div>
      <div class="mt-6 border-t pt-6 dark:border-gray-800">
        <h3 class="text-lg font-bold">Comments</h3>
        <div class="space-y-6">
          <div class="flex items-start space-x-4">
            <span class="relative flex shrink-0 overflow-hidden rounded-full w-10 h-10 border">
              <span class="flex h-full w-full items-center justify-center rounded-full bg-muted"
                >AC</span
              >
            </span>
            <div class="flex-1">
              <div class="flex items-center justify-between">
                <div>
                  <div class="font-medium">John Doe</div>
                  <div class="text-sm text-gray-500 dark:text-gray-400">2 days ago</div>
                </div>
                <div class="flex items-center space-x-2">
                  <button
                    class="inline-flex items-center justify-center whitespace-nowrap rounded-md text-sm font-medium ring-offset-background transition-colors focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-ring focus-visible:ring-offset-2 disabled:pointer-events-none disabled:opacity-50 hover:bg-accent hover:text-accent-foreground h-10 w-10"
                  >
                    <svg
                      xmlns="http://www.w3.org/2000/svg"
                      width="24"
                      height="24"
                      viewBox="0 0 24 24"
                      fill="none"
                      stroke="currentColor"
                      stroke-width="2"
                      stroke-linecap="round"
                      stroke-linejoin="round"
                      class="w-4 h-4 fill-primary"
                    >
                      <path
                        d="M19 14c1.49-1.46 3-3.21 3-5.5A5.5 5.5 0 0 0 16.5 3c-1.76 0-3 .5-4.5 2-1.5-1.5-2.74-2-4.5-2A5.5 5.5 0 0 0 2 8.5c0 2.3 1.5 4.05 3 5.5l7 7Z"
                      ></path>
                    </svg>
                    <span class="sr-only">Like</span>
                  </button>
                  <button
                    class="inline-flex items-center justify-center whitespace-nowrap rounded-md text-sm font-medium ring-offset-background transition-colors focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-ring focus-visible:ring-offset-2 disabled:pointer-events-none disabled:opacity-50 hover:bg-accent hover:text-accent-foreground h-10 w-10"
                  >
                    <svg
                      xmlns="http://www.w3.org/2000/svg"
                      width="24"
                      height="24"
                      viewBox="0 0 24 24"
                      fill="none"
                      stroke="currentColor"
                      stroke-width="2"
                      stroke-linecap="round"
                      stroke-linejoin="round"
                      class="w-4 h-4 fill-primary"
                    >
                      <polyline points="9 17 4 12 9 7"></polyline>
                      <path d="M20 18v-2a4 4 0 0 0-4-4H4"></path>
                    </svg>
                    <span class="sr-only">Reply</span>
                  </button>
                </div>
              </div>
              <div class="mt-2 text-sm">
                This t-shirt looks amazing! I love the unique prism design.
              </div>
            </div>
          </div>
          <div class="flex items-start space-x-4">
            <span class="relative flex shrink-0 overflow-hidden rounded-full w-10 h-10 border">
              <span class="flex h-full w-full items-center justify-center rounded-full bg-muted"
                >AC</span
              >
            </span>
            <div class="flex-1">
              <div class="flex items-center justify-between">
                <div>
                  <div class="font-medium">Jane Smith</div>
                  <div class="text-sm text-gray-500 dark:text-gray-400">1 week ago</div>
                </div>
                <div class="flex items-center space-x-2">
                  <button
                    class="inline-flex items-center justify-center whitespace-nowrap rounded-md text-sm font-medium ring-offset-background transition-colors focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-ring focus-visible:ring-offset-2 disabled:pointer-events-none disabled:opacity-50 hover:bg-accent hover:text-accent-foreground h-10 w-10"
                  >
                    <svg
                      xmlns="http://www.w3.org/2000/svg"
                      width="24"
                      height="24"
                      viewBox="0 0 24 24"
                      fill="none"
                      stroke="currentColor"
                      stroke-width="2"
                      stroke-linecap="round"
                      stroke-linejoin="round"
                      class="w-4 h-4 fill-primary"
                    >
                      <path
                        d="M19 14c1.49-1.46 3-3.21 3-5.5A5.5 5.5 0 0 0 16.5 3c-1.76 0-3 .5-4.5 2-1.5-1.5-2.74-2-4.5-2A5.5 5.5 0 0 0 2 8.5c0 2.3 1.5 4.05 3 5.5l7 7Z"
                      ></path>
                    </svg>
                    <span class="sr-only">Like</span>
                  </button>
                  <button
                    class="inline-flex items-center justify-center whitespace-nowrap rounded-md text-sm font-medium ring-offset-background transition-colors focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-ring focus-visible:ring-offset-2 disabled:pointer-events-none disabled:opacity-50 hover:bg-accent hover:text-accent-foreground h-10 w-10"
                  >
                    <svg
                      xmlns="http://www.w3.org/2000/svg"
                      width="24"
                      height="24"
                      viewBox="0 0 24 24"
                      fill="none"
                      stroke="currentColor"
                      stroke-width="2"
                      stroke-linecap="round"
                      stroke-linejoin="round"
                      class="w-4 h-4 fill-primary"
                    >
                      <polyline points="9 17 4 12 9 7"></polyline>
                      <path d="M20 18v-2a4 4 0 0 0-4-4H4"></path>
                    </svg>
                    <span class="sr-only">Reply</span>
                  </button>
                </div>
              </div>
              <div class="mt-2 text-sm">
                I can't wait to get my hands on this t-shirt! The quality and design look top-notch.
              </div>
            </div>
          </div>
          <div class="flex items-start space-x-4">
            <span class="relative flex shrink-0 overflow-hidden rounded-full w-10 h-10 border">
              <span class="flex h-full w-full items-center justify-center rounded-full bg-muted"
                >AC</span
              >
            </span>
            <div class="flex-1">
              <div class="flex items-center justify-between">
                <div>
                  <div class="font-medium">Michael Johnson</div>
                  <div class="text-sm text-gray-500 dark:text-gray-400">3 days ago</div>
                </div>
                <div class="flex items-center space-x-2">
                  <button
                    class="inline-flex items-center justify-center whitespace-nowrap rounded-md text-sm font-medium ring-offset-background transition-colors focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-ring focus-visible:ring-offset-2 disabled:pointer-events-none disabled:opacity-50 hover:bg-accent hover:text-accent-foreground h-10 w-10"
                  >
                    <svg
                      xmlns="http://www.w3.org/2000/svg"
                      width="24"
                      height="24"
                      viewBox="0 0 24 24"
                      fill="none"
                      stroke="currentColor"
                      stroke-width="2"
                      stroke-linecap="round"
                      stroke-linejoin="round"
                      class="w-4 h-4 fill-primary"
                    >
                      <path
                        d="M19 14c1.49-1.46 3-3.21 3-5.5A5.5 5.5 0 0 0 16.5 3c-1.76 0-3 .5-4.5 2-1.5-1.5-2.74-2-4.5-2A5.5 5.5 0 0 0 2 8.5c0 2.3 1.5 4.05 3 5.5l7 7Z"
                      ></path>
                    </svg>
                    <span class="sr-only">Like</span>
                  </button>
                  <button
                    class="inline-flex items-center justify-center whitespace-nowrap rounded-md text-sm font-medium ring-offset-background transition-colors focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-ring focus-visible:ring-offset-2 disabled:pointer-events-none disabled:opacity-50 hover:bg-accent hover:text-accent-foreground h-10 w-10"
                  >
                    <svg
                      xmlns="http://www.w3.org/2000/svg"
                      width="24"
                      height="24"
                      viewBox="0 0 24 24"
                      fill="none"
                      stroke="currentColor"
                      stroke-width="2"
                      stroke-linecap="round"
                      stroke-linejoin="round"
                      class="w-4 h-4 fill-primary"
                    >
                      <polyline points="9 17 4 12 9 7"></polyline>
                      <path d="M20 18v-2a4 4 0 0 0-4-4H4"></path>
                    </svg>
                    <span class="sr-only">Reply</span>
                  </button>
                </div>
              </div>
              <div class="mt-2 text-sm">
                The prism design is so unique and eye-catching. I can't wait to see this in person.
              </div>
  </div>
</template>
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
