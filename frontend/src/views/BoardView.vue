<script setup>
import { RouterLink, RouterView } from "vue-router";
</script>

<template>
  <div>
    <router-link :to="{ name: 'list' }">글 목록 보기</router-link>
    <RouterView />
  </div>
</template>

<style scoped></style>
