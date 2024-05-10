<script setup>
import TopNav from "@/components/TopNav.vue";
import { RouterLink, RouterView } from "router-vue";
</script>

<template>
  <header>
    <div class="container-fluid">
      <TopNav></TopNav>
      <<router-link :to="{ name: 'board' }"></router-link>
    </div>
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
