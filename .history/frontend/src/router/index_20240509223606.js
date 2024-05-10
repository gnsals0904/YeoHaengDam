import { createRouter, createWebHistory } from 'vue-router';

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes =[
    {
      path: '/board',
      name: 'BoardView',
      component: BoardView,
      children: [
        {
          path: '/list',
          name: 'list',
          component: () => import("../components/board/BoardList")
        }
      ]
    }
  ];
});

export default router;
