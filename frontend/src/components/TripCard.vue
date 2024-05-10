<!-- TripCard.vue -->
<script setup>
defineProps({
  name: String,
  image: String,
});
</script>

<template>
  <div
    class="relative rounded-lg border bg-card text-card-foreground shadow-sm overflow-hidden group"
  >
    <div
      class="inline-flex w-fit items-center whitespace-nowrap rounded-full border px-2.5 py-0.5 text-xs font-semibold transition-colors focus:outline-none focus:ring-2 focus:ring-ring focus:ring-offset-2 border-transparent bg-secondary text-secondary-foreground hover:bg-secondary/80 absolute top-2 right-2"
    >
      NEW
    </div>
    <img
      :src="`/cities/${image}`"
      :alt="name"
      class="w-full h-auto transition-transform duration-300 ease-in-out group-hover:scale-105"
      style="aspect-ratio: 300 / 240; object-fit: cover"
    />
    <div class="p-4">
      <h3 class="text-lg font-bold">{{ name }}</h3>
      <p class="text-sm">새로운 여행지</p>
    </div>
  </div>
</template>

<style scoped>
.group:hover .text-detail {
  transform: translateY(-10px) translateX(5px); /* 위치 조정 */
}
</style>
