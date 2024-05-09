<script setup>
import TopNav from "./components/TopNav.vue";
import MainPage from "./components/MainPage.vue";
import LandingPage from "./components/LandingPage.vue";
</script>

<template>
  <div>
    <TopNav></TopNav>
    <router-view></router-view>
  </div>
</template>

<style scoped></style>
