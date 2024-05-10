<script setup>
import { RouterView } from "vue-router";
import TopNav from "./components/TopNav.vue";
import client from "./api/client";
import axios from "axios";
axios
  .get("http://localhost:80/api/member/ping", {
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
