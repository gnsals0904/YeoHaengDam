<script setup></script>

<template>
  <header class="flex justify-between items-center py-4">
    <div class="flex items-center space-x-4">
      <router-link :to="{ name: 'Landing' }" class="text-3xl font-bold"
        >YeoHaengDam</router-link
      >
    </div>
    <nav class="hidden md:flex space-x-6">
      <router-link :to="{ name: 'Main' }" class="text-lg">여행지</router-link>
      <a class="text-lg" href="/"> 고객지원 </a>
      <a class="text-lg" href="/"> 이용방법 </a>
      <router-link :to="{ name: 'Login' }" class="text-lg">
        로그인
      </router-link>
    </nav>
    <div class="flex md:hidden">
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
        class="h-6 w-6"
      >
        <line x1="4" x2="20" y1="12" y2="12"></line>
        <line x1="4" x2="20" y1="6" y2="6"></line>
        <line x1="4" x2="20" y1="18" y2="18"></line>
      </svg>
    </div>
  </header>
</template>

<style scoped>
header {
  margin-left: 2vw;
  margin-right: 2vw;
}
</style>
