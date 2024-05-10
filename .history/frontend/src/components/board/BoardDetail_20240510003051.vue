<template>
  <div v-if="isOpen" class="modal">
    <div class="modal-content">
      <div class="fixed inset-0 bg-gray-900/50 z-50 flex items-center justify-center">
        <div class="bg-white dark:bg-gray-950 rounded-lg shadow-lg w-full max-w-4xl p-6 md:p-8">
          <div class="flex items-start justify-between mb-6">
            <div>
              <h2 class="text-2xl font-bold">Introducing the New Product Line</h2>
              <div class="text-gray-500 dark:text-gray-400 text-sm mt-1">
                <span>By John Doe</span>
                <span class="mx-2">•</span>
                <span>May 9, 2024</span>
              </div>
            </div>
            <button
              class="text-gray-500 hover:text-gray-900 dark:hover:text-gray-50 focus:outline-none"
            >
              <svg
                xmlns="http://www.w3.org/2000/svg"
                width="24"
                height="24"
                viewBox="0 0 24 24"
                fill="none"
                stroke="currentColor"
                stroke-width="2"
                stroke-linecap="round"
                stroke-linejoin="round"
                class="w-6 h-6"
                @click="close"
              >
                <path d="M18 6 6 18"></path>
                <path d="m6 6 12 12"></path>
              </svg>
              <span class="sr-only">Close</span>
            </button>
          </div>
          <div class="prose prose-lg dark:prose-invert">
            <p>
              We are thrilled to announce the launch of our brand new product line, designed to
              revolutionize the industry. Our team has been working tirelessly to create a
              collection that not only meets but exceeds your expectations.
            </p>
            <p>
              The new products feature cutting-edge technology, sleek designs, and unparalleled
              functionality. Whether you're a tech enthusiast or simply looking to upgrade your
              daily essentials, our latest offerings are sure to impress.
            </p>
            <p>
              We've put a lot of thought and care into every detail, ensuring that each product not
              only looks stunning but also delivers exceptional performance. From the carefully
              selected materials to the intuitive user experience, we've left no stone unturned.
            </p>
            <p>
              We're confident that our new product line will become an indispensable part of your
              life, and we can't wait for you to experience it firsthand. Stay tuned for more
              updates and exciting announcements in the coming weeks.
            </p>
          </div>
        </div>
        <button @click="close">Close</button>
      </div>
    </div>
  </div>
</template>

<script setup>
const props = defineProps({
  board: Object,
  isOpen: Boolean,
});

const emit = defineEmits(["close"]);

function close() {
  emit("close");
}
</script>

<style scoped>
.modal {
  position: fixed;
  left: 0;
  top: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.6);
  display: flex;
  justify-content: center;
  align-items: center;
  z-index: 1000; /* 높은 z-index 값 설정 */
}

.modal-content {
  width: 80%; /* 모달 너비를 80%로 설정 */
  min-width: 500px; /* 최소 너비를 500px로 설정 */
  max-height: 70%; /* 최대 높이 설정 */
  min-height: 500px; /* 최소 높이 설정 */
  background: white;
  padding: 40px; /* 패딩을 40px로 설정 */
  border-radius: 10px;
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1); /* 상자 그림자 추가 */
}

.no-scroll {
  overflow: hidden; /* 스크롤 방지 */
}
</style>
