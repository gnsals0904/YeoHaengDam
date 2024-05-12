<script setup>
import { ref } from "vue";
import router from "@/router";
import client from "@/api/client";
import { useAuthStore } from "@/stores/auth";

const authStore = useAuthStore();
const username = ref("");
const password = ref("");

const handleLogin = async () => {
  console.log("Logging in with:", username.value, password.value);
  try {
    const response = await client.post("/member/login", {
      userId: username.value,
      userPassword: password.value,
    });

    if (response.status !== 200) {
      throw new Error("로그인 실패");
    }

    sessionStorage.setItem("memberDto", JSON.stringify(response.data));
    console.log(response.data);
    authStore.login(response.data);
    alert("로그인 성공!");
    router.push({ name: "Landing" });
  } catch (error) {
    console.error("로그인 실패:", error);
    alert("로그인 실패: " + error.message);
  }
};
</script>

<template>
  <div
    class="min-h-screen flex flex-col items-center justify-center bg-gray-100"
  >
    <h1 class="text-xl font-bold mb-8">LoginView</h1>
    <form class="w-full max-w-xs" @submit.prevent="handleLogin">
      <div class="mb-4">
        <label
          class="block text-gray-700 text-sm font-bold mb-2"
          for="username"
        >
          Username
        </label>
        <input
          v-model="username"
          id="username"
          type="text"
          placeholder="Username"
          class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
          required
        />
      </div>
      <div class="mb-6">
        <label
          class="block text-gray-700 text-sm font-bold mb-2"
          for="password"
        >
          Password
        </label>
        <input
          v-model="password"
          id="password"
          type="password"
          placeholder="******************"
          class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 mb-3 leading-tight focus:outline-none focus:shadow-outline"
          required
        />
      </div>
      <div class="flex items-center justify-between">
        <button
          class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline"
          type="submit"
        >
          Sign In
        </button>
      </div>
    </form>
  </div>
</template>

<style scoped></style>
