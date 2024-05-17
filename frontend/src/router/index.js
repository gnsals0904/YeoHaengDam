import { createRouter, createWebHistory } from 'vue-router';
import LandingPage from '@/components/LandingPage.vue';
import MainPage from '@/components/MainPage.vue';
import MapView from '@/views/MapView.vue';
import LoginView from '@/views/LoginView.vue';
import MyPageView from '@/views/MyPageView.vue';
import SignupView from '@/views/SignupView.vue';
import FindPwdView from '@/views/FindPwdView.vue';
import LandingPage2 from '@/components/LandingPage2.vue';
import EditPwdView from '@/views/EditPwdView.vue';

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),

  routes: [
    { path: '/', name: 'Landing', component: LandingPage },
    { path: '/main', name: 'Main', component: MainPage },
    { path: '/map', name: 'Map', component: MapView },
    { path: '/login', name: 'Login', component: LoginView },
    { path: '/mypage', name: 'MyPage', component: MyPageView },
    { path: '/signup', name: 'Signup', component: SignupView },
    { path: '/findPwd', name: 'FindPwd', component: FindPwdView },
    { path: '/landing2', name: 'Landing2', component: LandingPage2 },
    { path: '/editPwd', name: 'EditPwd', component: EditPwdView },
    {
      path: '/board',
      name: 'board',
      component: () => import('../views/BoardView.vue'),
      children: [
        {
          path: '/list',
          name: 'list',
          component: () => import('../components/board/BoardList.vue'),
        },

        {
          path: '/article/:articleNo',
          name: 'detail',
          component: () => import('../components/board/BoardDetail.vue'),
        },
        {
          path: '/article/:articleNo',
          name: 'detail',
          component: () => import('../components/board/BoardDetail.vue'),
        },

        {
          path: '/article/:articleNo',
          name: 'update',
          component: () => import('../components/board/BoardDetail.vue'),
        },
      ],
    },
  ],
});

export default router;
