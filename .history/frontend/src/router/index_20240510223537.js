import { createRouter, createWebHistory } from "vue-router";
import LandingPage from "@/components/LandingPage.vue";
import MainPage from "@/components/MainPage.vue";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),

  routes: [
    { path: "/", name: "Landing", component: LandingPage },
    { path: "/main", name: "Main", component: MainPage },
    {
      path: '/board',
      name: 'board',
      component: () => import("../views/BoardView.vue"),
      children: [
        {
          path: '/list',
          name: 'list',
          component: () => import("../components/board/BoardList.vue")
        },

        {
          path: '/article/:articleNo',
          name: 'detail',
          component: () => import("../components/board/BoardDetail.vue")
        },

        {
          path: '/article/:articleNo',
          name: 'update',
          component:() => import("../components/board/BoardDetail.vue")
        }
      ]
    }
  ]
});

export default router;
