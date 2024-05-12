import { defineStore } from "pinia";

export const useAuthStore = defineStore("auth", {
  state: () => ({
    isLoggedIn: false,
    user: null,
  }),
  actions: {
    login(userData) {
      this.isLoggedIn = true;
      this.user = userData;
      sessionStorage.setItem("memberDto", JSON.stringify(userData));
    },
    logout() {
      this.isLoggedIn = false;
      this.user = null;
      sessionStorage.removeItem("memberDto");
    },
  },
});
