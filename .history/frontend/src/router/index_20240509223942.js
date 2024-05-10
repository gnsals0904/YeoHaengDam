import { createRouter, createWebHistory } from 'vue-router';

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes =[
    {
      path: '/board',
      name: 'BoardView',
      component: () => import("../views/BoardView.vue"),
      children: [
        {
          path: '/list',
          name: 'list',
          component: () => import("../components/board/BoardList.vue")
        }
      ]
    }
  ]
});

export default router;
