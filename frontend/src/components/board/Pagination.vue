<template>
  <nav aria-label="pagination" class="mx-auto flex w-full justify-center" role="navigation">
    <ul class="flex flex-row items-center gap-1">
      <li>
        <button
          @click="changePage(currentPage - 1)"
          :disabled="currentPage <= 1"
          class="inline-flex items-center justify-center whitespace-nowrap rounded-md text-sm font-medium ring-offset-background transition-colors focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-ring focus-visible:ring-offset-2 disabled:pointer-events-none disabled:opacity-50 hover:bg-accent hover:text-accent-foreground h-10 px-4 py-2 gap-1"
          aria-label="Go to previous page"
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
            class="h-4 w-4"
          >
            <path d="m15 18-6-6 6-6"></path>
          </svg>
          Previous
        </button>
      </li>
      <li v-for="number in totalPages" :key="number">
        <button
          @click="changePage(number)"
          :class="{ 'bg-accent text-accent-foreground': number === currentPage }"
          class="inline-flex items-center justify-center whitespace-nowrap rounded-md text-sm font-medium ring-offset-background transition-colors focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-ring focus-visible:ring-offset-2 disabled:pointer-events-none disabled:opacity-50 hover:bg-accent hover:text-accent-foreground h-10 w-10"
        >
          {{ number }}
        </button>
      </li>
      <li>
        <button
          @click="changePage(currentPage + 1)"
          :disabled="currentPage >= totalPages"
          class="inline-flex items-center justify-center whitespace-nowrap rounded-md text-sm font-medium ring-offset-background transition-colors focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-ring focus-visible:ring-offset-2 disabled:pointer-events-none disabled:opacity-50 hover:bg-accent hover:text-accent-foreground h-10 px-4 py-2 gap-1"
          aria-label="Go to next page"
        >
          Next
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
            class="h-4 w-4"
          >
            <path d="m9 18 6-6-6-6"></path>
          </svg>
        </button>
      </li>
    </ul>
  </nav>
</template>

<script setup>
defineProps({
  currentPage: Number,
  totalPages: Number,
});

const emit = defineEmits(["update:page"]);

function changePage(page) {
  if (page > 0 && page <= totalPages) {
    emit("update:page", page);
  }
}
</script>

<style scoped>
/* Add specific styles if needed */
</style>
