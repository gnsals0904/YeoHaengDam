<template>
  <div class="space-y-4">
    <div class="flex items-center justify-between">
      <h2 class="text-2xl font-bold">{{ board._rowValue.subject }}</h2>
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
    <div class="mt-6 border-t pt-6 dark:border-gray-800">
      <h3 class="text-lg font-bold">Comments</h3>
      <div class="space-y-6">
        <!-- Comments section -->
        <!-- Similar structure repeated for each comment, omitted for brevity -->
      </div>
    </div>
  </div>
</template>

<script setup>
import { useBoardStore } from "@/stores/board";

const boardStore = useBoardStore();
const board = boardStore.selectedBoard;
console.log(board);
</script>

<style scoped></style>
