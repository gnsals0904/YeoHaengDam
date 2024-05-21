<script setup>
import { ref, computed } from 'vue';

const props = defineProps({
  visible: Boolean,
  email: String,
});

const emit = defineEmits(['close', 'verified']);

const code1 = ref('');
const code2 = ref('');
const code3 = ref('');
const code4 = ref('');

const obfuscatedEmail = computed(() => {
  const [user, domain] = props.email.split('@');
  return `${user.slice(0, 2)}***@${domain}`;
});

const verifyCode = () => {
  const code = `${code1.value}${code2.value}${code3.value}${code4.value}`;
  emit('verified', code);
};

const resendCode = () => {
  alert('Verification code resent.');
};
</script>

<template>
  <div class="modal-overlay" v-if="visible">
    <div class="modal-container">
      <h2 class="text-center font-semibold text-3xl">Email Verification</h2>
      <p class="text-center mt-5 mb-5">
        We have sent a code to your email {{ obfuscatedEmail }}
      </p>
      <div
        class="code-inputs flex flex-row items-center justify-between mx-auto w-full max-w-xs"
      >
        <div class="w-16 h-16">
          <input
            class="w-full h-full flex flex-col items-center justify-center text-center px-5 outline-none rounded-xl border border-gray-200 text-lg bg-white focus:bg-gray-50 focus:ring-1 ring-blue-700"
            v-model="code1"
            maxlength="1"
          />
        </div>
        <div class="w-16 h-16">
          <input
            class="w-full h-full flex flex-col items-center justify-center text-center px-5 outline-none rounded-xl border border-gray-200 text-lg bg-white focus:bg-gray-50 focus:ring-1 ring-blue-700"
            v-model="code2"
            maxlength="1"
          />
        </div>
        <div class="w-16 h-16">
          <input
            class="w-full h-full flex flex-col items-center justify-center text-center px-5 outline-none rounded-xl border border-gray-200 text-lg bg-white focus:bg-gray-50 focus:ring-1 ring-blue-700"
            v-model="code3"
            maxlength="1"
          />
        </div>
        <div class="w-16 h-16">
          <input
            class="w-full h-full flex flex-col items-center justify-center text-center px-5 outline-none rounded-xl border border-gray-200 text-lg bg-white focus:bg-gray-50 focus:ring-1 ring-blue-700"
            v-model="code4"
            maxlength="1"
          />
        </div>
      </div>
      <div class="flex flex-col space-y-5 mt-5">
        <button
          class="rounded-xl outline-none py-3 bg-blue-700 border-none text-white text-sm shadow-sm"
          @click="verifyCode"
        >
          Verify Account
        </button>
        <p class="text-center flex flex-col justify-center">
          Didn't receive code?
          <a class="text-lg items-center text-blue-600" @click="resendCode"
            >Resend</a
          >
        </p>
      </div>
    </div>
  </div>
</template>

<style scoped>
.modal-overlay {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background: rgba(0, 0, 0, 0.5);
  display: flex;
  justify-content: center;
  align-items: center;
}
.modal-container {
  background: white;
  padding: 2rem;
  border-radius: 0.5rem;
  text-align: center;
}
</style>
