<script setup>
import { RouterView } from "vue-router";
import TopNav from "./components/TopNav.vue";
import FooterPage from "./components/FooterPage.vue";
</script>

<template>
  <div>
    <TopNav></TopNav>
    <router-view></router-view>
    <FooterPage></FooterPage>
  </div>
</template>

<style scoped></style>
