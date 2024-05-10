<script setup>
import TripCard from './TripCard.vue';
import { useDestinationStore } from '@/stores/store.js';
import { Menu, MenuButton, MenuItems, MenuItem } from '@headlessui/vue';
import ListBoxCities from './ListBoxCities.vue';
const { destinations } = useDestinationStore();
</script>

<template>
  <div id="section-wrap">
    <section class="my-12">
      <h2 class="text-5xl font-bold text-center mb-6">
        어디로 여행을 떠나시나요?
      </h2>
      <p class="text-center text-lg mb-4">
        떠나고 싶은 곳과 어떤 여행을 떠나고 싶은지 골라주세요
      </p>
      <div class="flex justify-center items-center space-x-2 mb-12">
        <ListBoxCities></ListBoxCities>
        <ListBoxCities></ListBoxCities>
        <ListBoxCities></ListBoxCities>
        <button
          class="inline-flex items-center justify-center whitespace-nowrap rounded-md text-sm font-medium ring-offset-background transition-colors focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-ring focus-visible:ring-offset-2 disabled:pointer-events-none disabled:opacity-50 border border-input bg-background hover:bg-accent hover:text-accent-foreground h-10 px-4 py-2"
        >
          검색
        </button>
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
