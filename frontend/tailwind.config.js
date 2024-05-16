/** @type {import('tailwindcss').Config} */
export default {
  content: ["src/**/*.vue", "index.html"],
  theme: {
    extend: {
      // fontFamily: {
      //   pretendard: ['Pretendard', 'sans-serif'],
      // },
      flexGrow: {
        1: 1,
        4: 4,
        6: 6,
      },
    },
  },
  plugins: [],
};
