import { createRouter, createWebHistory } from "vue-router";
import LandingPage from "@/components/LandingPage.vue";
import MainPage from "@/components/MainPage.vue";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    { path: "/", name: "Landing", component: LandingPage },
    { path: "/main", name: "Main", component: MainPage },
  ],
});

export default router;
