<script setup>
import TripCard from "./TripCard.vue";
import { useDestinationStore } from "@/stores/store.js"; // 경로는 실제 환경에 맞게 조정하세요.

const { destinations } = useDestinationStore();
</script>

<template>
  <div id="section-wrap">
    <section class="my-12">
      <h2 class="text-5xl font-bold text-center mb-6">
        어디로 여행을 떠나시나요?
      </h2>
      <p class="text-center text-lg mb-4">
        국가이름이나 도시명으로 검색해보세요.
      </p>
      <div class="flex justify-center items-center space-x-2 mb-12">
        <button
          class="inline-flex items-center justify-center whitespace-nowrap rounded-md text-sm font-medium ring-offset-background transition-colors focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-ring focus-visible:ring-offset-2 disabled:pointer-events-none disabled:opacity-50 border border-input bg-background hover:bg-accent hover:text-accent-foreground h-10 px-4 py-2"
        >
          전체
        </button>
        <button
          class="inline-flex items-center justify-center whitespace-nowrap rounded-md text-sm font-medium ring-offset-background transition-colors focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-ring focus-visible:ring-offset-2 disabled:pointer-events-none disabled:opacity-50 border border-input bg-background hover:bg-accent hover:text-accent-foreground h-10 px-4 py-2"
        >
          국내
        </button>
        <button
          class="inline-flex items-center justify-center whitespace-nowrap rounded-md text-sm font-medium ring-offset-background transition-colors focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-ring focus-visible:ring-offset-2 disabled:pointer-events-none disabled:opacity-50 border border-input bg-background hover:bg-accent hover:text-accent-foreground h-10 px-4 py-2"
        >
          해외
        </button>
        <div class="relative">
          <input
            class="flex h-10 w-full rounded-md border border-input bg-background px-3 py-2 text-sm ring-offset-background file:border-0 file:bg-transparent file:text-sm file:font-medium placeholder:text-muted-foreground focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-ring focus-visible:ring-offset-2 disabled:cursor-not-allowed disabled:opacity-50 pl-10"
            placeholder="Search"
          />
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
            class="absolute left-2 top-1/2 transform -translate-y-1/2 h-5 w-5 text-muted-foreground"
          >
            <path d="M6 18h8"></path>
            <path d="M3 22h18"></path>
            <path d="M14 22a7 7 0 1 0 0-14h-1"></path>
            <path d="M9 14h2"></path>
            <path d="M9 12a2 2 0 0 1-2-2V6h6v4a2 2 0 0 1-2 2Z"></path>
            <path d="M12 6V3a1 1 0 0 0-1-1H9a1 1 0 0 0-1 1v3"></path>
          </svg>
        </div>
      </div>
      <div class="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-4 gap-4">
        <TripCard
          v-for="destination in destinations"
          :key="destination.id"
          :name="destination.name"
          :image="destination.image"
        />
      </div>
    </section>
  </div>
</template>

<style scoped>
#section-wrap {
  margin-left: 5vw;
  margin-right: 5vw;
}
</style>
