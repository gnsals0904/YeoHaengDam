<script setup>
import { defineEmits } from 'vue';

const emit = defineEmits(['toggle']);
</script>

<template>
  <div class="flex">
    <input
      type="checkbox"
      id="drawer-toggle"
      class="relative sr-only peer"
      @change="emit('toggle')"
    />
    <label
      for="drawer-toggle"
      class="absolute top-1/2 right-0 inline-block p-3 transition-all duration-500 bg-indigo-500 rounded-lg peer-checked:rotate-180 peer-checked:right-500px"
    >
      <div class="w-6 h-1 mb-3 -rotate-45 bg-white rounded-lg"></div>
      <div class="w-6 h-1 rotate-45 bg-white rounded-lg"></div>
    </label>
    <div
      class="fixed overflow-auto min-w-[500px] top-0 right-0 z-20 h-full transition-all duration-500 transform translate-x-full bg-white shadow-lg peer-checked:translate-x-0"
    >
      <div class="px-6 py-4">
        <h2 class="text-lg font-semibold">나만의 여행 계획 세우기</h2>
        <p class="text-gray-500">This is a drawer.</p>
      </div>
    </div>
  </div>
</template>

<style scoped></style>
