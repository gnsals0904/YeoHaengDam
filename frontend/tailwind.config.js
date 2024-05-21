/** @type {import('tailwindcss').Config} */
export default {
  content: ['src/**/*.vue', 'index.html'],
  theme: {
    extend: {
      flexGrow: {
        1: 1,
        4: 4,
        6: 6,
      },
      flex: {
        3: '3 3 0%',
      },
      colors: {
        'regal-blue': '#e8f0fe',
      },
      inset: {
        '500px': '500px',
      },
    },
    variants: {
      extend: {
        inset: ['peer-checked'],
      },
    },
  },
  plugins: [],
};
