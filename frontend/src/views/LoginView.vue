<script setup>
import { ref } from 'vue';
import router from '@/router';
import client from '@/api/client';
import { useAuthStore } from '@/stores/auth';

const authStore = useAuthStore();
const username = ref('');
const password = ref('');

const handleLogin = async () => {
  console.log('Logging in with:', username.value, password.value);
  try {
    const response = await client.post('/member/login', {
      userId: username.value,
      userPassword: password.value,
    });

    if (response.status !== 200) {
      throw new Error('로그인 실패');
    }

    sessionStorage.setItem('memberDto', JSON.stringify(response.data));
    console.log(response.data);
    authStore.login(response.data);
    alert('로그인 성공!');
    router.push({ name: 'Landing' });
  } catch (error) {
    console.error('로그인 실패:', error);
    alert('로그인 실패: ' + error.message);
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

  <!--new form-->
  <div class="h-screen flex">
    <!-- 이미지 섹션 -->
    <div
      class="hidden lg:flex w-full lg:w-1/2 justify-around items-center bg-blue-600 p-10 space-x-5"
    >
      <div class="text-center space-y-6">
        <h1 class="text-white text-4xl font-bold">Simple App</h1>
        <p class="text-white text-lg">The simplest app to use</p>
        <button
          @click="router.push('/signup')"
          class="bg-white text-blue-600 font-bold py-2 px-4 rounded-xl transition-all duration-500 hover:bg-indigo-700 hover:text-white"
        >
          Get Started
        </button>
      </div>
    </div>
    <!-- 로그인 폼 섹션 -->
    <div class="flex w-full lg:w-1/2 justify-center items-center bg-white">
      <form
        @submit="handleLogin"
        class="bg-white rounded-lg shadow-xl p-5 w-full max-w-md"
      >
        <h1 class="text-gray-800 font-bold text-2xl mb-1">Hello Again!</h1>
        <p class="text-sm font-normal text-gray-600 mb-8">Welcome Back</p>
        <div class="flex items-center border-2 py-2 px-3 rounded-xl mb-6">
          <input
            v-model="username"
            type="text"
            name="email"
            placeholder="ID"
            class="w-full outline-none border-none pl-2"
            required
          />
        </div>
        <div class="flex items-center border-2 py-2 px-3 rounded-xl mb-8">
          <input
            v-model="password"
            type="password"
            name="password"
            placeholder="Password"
            class="w-full outline-none border-none pl-2"
            required
          />
        </div>
        <button
          type="submit"
          class="w-full bg-blue-600 py-2 rounded-xl text-white font-semibold hover:bg-blue-700"
        >
          Login
        </button>
        <div class="flex justify-between mt-4 text-sm">
          <a href="#" class="hover:text-blue-500">Forgot Password?</a>
          <a href="#" class="hover:text-blue-500">Don't have an account yet?</a>
        </div>
      </form>
    </div>
  </div>
</template>

<style>
.login_img_section {
  background: linear-gradient(rgba(2, 2, 2, 0.7), rgba(0, 0, 0, 0.7)),
    url(https://images.unsplash.com/photo-1650825556125-060e52d40bd0?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80)
      center center;
}
</style>
