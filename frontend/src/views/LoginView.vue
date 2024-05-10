<script setup>
import { ref, onMounted } from "vue";
import router from "@/router";
import client from "@/api/client";

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
    console.log("로그인 성공!"); // 성공 메시지 로그

    alert("로그인 성공!"); // 또는 이렇게 알림 창을 띄울 수 있습니다.
    router.go(0); // 현재 페이지를 새로 고침합니다.
  } catch (error) {
    console.error("로그인 실패:", error);
    alert("로그인 실패: " + error.message); // 에러 메시지를 alert로 보여줍니다.
  }
};
/*
// 세션에서 로그인 정보 가져오기
const loadingState = ref({ isLoading: true });

onMounted(async () => {
  if (sessionStorage.getItem("memberDto") !== null) {
    if (!sessionStorage.getItem("refreshed")) {
      sessionStorage.setItem("refreshed", "true");
      await router.go(0);
    } else {
      sessionStorage.removeItem("refreshed");
    }
  }

  try {
    const res = await client.get("/members/ping");
    if (res.status === 200) {
      if (res.data !== "") {
        sessionStorage.setItem("memberDto", JSON.stringify(res.data));
      }
    } else {
      await router.go(0);
    }
  } catch (error) {
    console.error(error);
  }

  loadingState.value.isLoading = false; // 로딩이 완료되었음을 표시
});
*/
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
