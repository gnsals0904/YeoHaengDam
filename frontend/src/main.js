import './assets/main.css';
import './assets/fonts.css'; // 폰트 파일
import './assets/global.css'; // 전역 스타일

import { createApp } from 'vue';
import { createPinia } from 'pinia';

import App from './App.vue';
import router from './router';
import { useKakao } from 'vue3-kakao-maps/@utils';

const app = createApp(App);

const kakaoApiKey = import.meta.env.VITE_VUE_APP_KAKAO_API_KEY;
console.log(kakaoApiKey);
useKakao(kakaoApiKey); // API 키를 useKakao 함수에 전달
app.use(createPinia());
app.use(router);

app.mount('#app');
