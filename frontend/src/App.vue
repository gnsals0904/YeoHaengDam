<script setup>
import { RouterView } from "vue-router";
import TopNav from "./components/TopNav.vue";
import client from "./api/client";
client
  .get("/member/ping", {
    withCredentials: true,
  })
  .then((response) => console.log(response));
</script>

<template>
  <div>
    <TopNav></TopNav>
    <router-view></router-view>
  </div>
</template>

<style scoped></style>
