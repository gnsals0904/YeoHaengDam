<script setup>
import { ref } from "vue";
import { useRouter } from "vue-router";
import axios from "axios";
import EmailVerification from "@/components/common/EmailVerification.vue";
import CustomLoading from "@/components/common/CustomLoading.vue";

/** 회원 가입 */
const email = ref("");
const isEmailConfirmed = ref(false);
const emailVerificationVisible = ref(false);
const isLoading = ref(false);
const router = useRouter();

/** 이메일 체크 */
const emailCheck = async (emailInput) => {
  if (!email.value) {
    alert("이메일을 입력해주세요.");
    return;
  }
  isLoading.value = true;
  try {
    const response = await axios.post(`http://localhost:8080/api/auth/checkEmail`, {
      email: email.value,
      emailInput,
    });
    if (response.status === 200) {
      emailVerificationVisible.value = true;
    } else {
      alert("이메일 인증이 완료되지 않았습니다.");
    }
  } catch (error) {
    console.error("이메일 인증 오류:", error);
    alert("이메일 인증 중 오류가 발생했습니다.");
  } finally {
    isLoading.value = false; // 로딩 상태 종료
  }
};

const resetPassword = async (email) => {
  try {
    const response = await axios.post(`http://localhost:8080/api/users/reset/password`, {
      email: email.value,
    });
    if (response.status === 200) {
      const resetPassword = response.data;
      alert(`비밀번호가 성공적으로 초기화되었습니다.\n새로운 비밀번호: ${resetPassword}`);
      router.push({ name: "Login" }); // 로그인 페이지로 리디렉션
    } else {
      alert("비밀번호 초기화에 실패하였습니다.");
    }
  } catch (error) {
    console.error("비밀번호 초기화 오류:", error);
    alert("입력하신 이메일 주소로 등록된 사용자가 없습니다.\n이메일 주소를 다시 확인해주세요.");
  }
};

const verifyEmailCode = async (code) => {
  try {
    const response = await axios.post(`http://localhost:8080/api/auth/checkCode`, {
      email: email.value,
      code: code,
    });
    if (response.status === 200) {
      emailVerificationVisible.value = false;
      isEmailConfirmed.value = true;
      alert("이메일 인증이 완료되었습니다.");
      await resetPassword(email); // 비밀번호 초기화 요청 보내기
    } else {
      alert("잘못된 인증 코드입니다.");
    }
  } catch (error) {
    console.error("이메일 인증 코드 확인 오류:", error);
    alert("이메일 인증 코드 확인 중 오류가 발생했습니다.");
  }
};
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
      <form class="my-8 text-sm" @submit.prevent>
        <div>
          <div class="flex items-center mt-2">
            <input
              type="email"
              name="email"
              id="email"
              class="disabled:bg-regal-blue flex-grow p-2 border border-gray-300 focus:outline-none focus:ring-0 focus:border-gray-300 rounded text-sm text-gray-900"
              placeholder="Enter your email"
              v-model="email"
              :disabled="isEmailConfirmed"
            />
            <button
              class="ml-2 bg-blue-600 hover:bg-blue-700 rounded-lg px-4 py-2 text-gray-100 hover:shadow-xl transition duration-150 uppercase"
              @click="emailCheck"
            >
              이메일 인증
            </button>
          </div>
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
  <EmailVerification
    :visible="emailVerificationVisible"
    :email="email"
    @verified="verifyEmailCode"
    @close="emailVerificationVisible = false"
  />
  <CustomLoading v-if="isLoading" />
</template>

<style scoped></style>
