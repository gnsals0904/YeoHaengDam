<script setup>
import { defineProps } from "vue";

const props = defineProps({
  item: {
    type: Object,
    required: true,
  },
});
</script>

<template>
  <div class="flex flex-col bg-blue-800 p-4 rounded-lg shadow-lg">
    <h3 class="text-2xl font-bold mb-2 text-gray-50">{{ item.title }}</h3>
    <img
      :src="item.img1"
      alt="위치 이미지"
      class="w-full h-auto mb-4 rounded-lg object-cover"
    />
    <p class="text-lg font-light text-gray-300">
      {{ item.addr1 }} {{ item.addr2 }}
    </p>
    <div class="mt-auto">
      <button
        class="mt-4 py-2 px-4 bg-gray-50 text-blue-800 font-semibold rounded-lg shadow hover:bg-gray-100"
      >
        자세히 보기
        <svg
          xmlns="http://www.w3.org/2000/svg"
          class="h-5 w-5 inline-block ml-2"
          fill="none"
          viewBox="0 0 24 24"
          stroke="currentColor"
        >
          <path
            stroke-linecap="round"
            stroke-linejoin="round"
            stroke-width="2"
            d="M9 5l7 7-7 7"
          />
        </svg>
      </button>
    </div>
  </div>
</template>

<style scoped></style>
