<script setup>
import TopNav from "@/components/TopNav.vue";
import { RouterLink, RouterView } from "vue-router";
</script>

<template>
  <header>
    <div class="container-fluid"><<router-link :to="{ name: 'board' }">Board</router-link></div>
    <RouterView />
  </header>
  <div></div>
</template>

<style scoped>
header {
}
main {
  /* Styles for main content area */
}
footer {
  /* Styles for footer */
}
</style>
