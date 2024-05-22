<script setup>
import { useRouter } from "vue-router";
const router = useRouter();
</script>

<template>
  <!--
  // v0 by Vercel.
  // https://v0.dev/t/YOufAQnTnbp
  -->

  <main
    class="flex min-h-screen items-center justify-center bg-gray-100 px-4 py-12 dark:bg-gray-950"
  >
    <div
      class="mx-auto w-full max-w-md space-y-4 rounded-lg bg-white p-6 shadow-lg dark:bg-gray-900"
    >
      <div class="space-y-2">
        <h1 class="text-2xl font-bold">Find your password</h1>
        <p class="text-gray-500 dark:text-gray-400">
          Enter your email address and we'll send you a link to reset your password.
        </p>
      </div>
      <form class="space-y-4">
        <div>
          <label
            class="text-sm font-medium leading-none peer-disabled:cursor-not-allowed peer-disabled:opacity-70"
            for="email"
          >
            Email
          </label>
          <input
            class="flex h-10 w-full rounded-md border border-input bg-background px-3 py-2 text-sm ring-offset-background file:border-0 file:bg-transparent file:text-sm file:font-medium placeholder:text-muted-foreground focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-ring focus-visible:ring-offset-2 disabled:cursor-not-allowed disabled:opacity-50"
            id="email"
            placeholder="Enter your email"
            required=""
            type="email"
          />
        </div>
        <button
          class="inline-flex items-center justify-center whitespace-nowrap rounded-md text-sm font-medium ring-offset-background transition-colors focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-ring focus-visible:ring-offset-2 disabled:pointer-events-none disabled:opacity-50 bg-primary text-primary-foreground hover:bg-primary/90 h-10 px-4 py-2 w-full"
          type="submit"
        >
          Send reset link
        </button>
      </form>
      <div class="text-center text-sm text-gray-500 dark:text-gray-400">
        <a
          class="font-medium underline hover:text-gray-900 dark:hover:text-gray-50"
          @click="router.push('/login')"
        >
          Back to login
        </a>
      </div>
    </div>
  </main>
</template>

<style scoped></style>