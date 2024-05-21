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
      <h2 class="text-center">Email Verification</h2>
      <p class="text-center">
        We have sent a code to your email {{ obfuscatedEmail }}
      </p>
      <div class="code-inputs">
        <input v-model="code1" maxlength="1" />
        <input v-model="code2" maxlength="1" />
        <input v-model="code3" maxlength="1" />
        <input v-model="code4" maxlength="1" />
      </div>
      <button @click="verifyCode">Verify Account</button>
      <p class="text-center">
        Didn't receive code? <a @click="resendCode">Resend</a>
      </p>
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
.code-inputs input {
  width: 2rem;
  height: 2rem;
  margin: 0 0.5rem;
  text-align: center;
  font-size: 1.5rem;
}
</style>
