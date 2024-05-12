<script setup>
import { RouterView } from "vue-router";
import TopNav from "./components/TopNav.vue";
</script>

<template>
  <div>
    <TopNav></TopNav>
    <router-view></router-view>
  </div>
</template>

<style scoped></style>
