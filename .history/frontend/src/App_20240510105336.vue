<script setup>
import { RouterLink, RouterView } from "vue-router";
import TopNav from "./components/TopNav.vue";
import MainPage from "./components/MainPage.vue";
import LandingPage from "./components/LandingPage.vue";
</script>

<template>
  <div>
    <TopNav></TopNav>
    <div class="container-fluid"><<router-link :to="{ name: 'board' }">Board</router-link></div>
    <router-view></router-view>
  </div>
</template>

<style scoped></style>
