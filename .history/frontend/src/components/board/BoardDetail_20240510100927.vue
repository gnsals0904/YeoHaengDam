<template>
  <div v-if="isOpen" class="modal">
    <div class="fixed inset-0 z-50 flex items-center justify-center bg-black/50">
      <div
        class="relative mx-4 w-full max-w-2xl rounded-lg bg-white p-6 shadow-lg dark:bg-gray-900 sm:p-8"
      >
        <button
          class="absolute top-4 right-4 rounded-full p-2 text-gray-500 hover:bg-gray-100 hover:text-gray-900 focus:outline-none focus:ring-2 focus:ring-gray-950 dark:hover:bg-gray-800 dark:hover:text-gray-50 dark:focus:ring-gray-300"
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
            class="h-5 w-5"
            @click="close"
          >
            <path d="M18 6 6 18"></path>
            <path d="m6 6 12 12"></path>
          </svg>
          <span class="sr-only">Close</span>
        </button>
        <div class="space-y-4">
          <div class="flex items-center justify-between">
            <h2 class="text-2xl font-bold">Introducing the Acme Prism T-Shirt</h2>
            <div class="flex items-center space-x-4 text-sm text-gray-500 dark:text-gray-400">
              <div>
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
                  class="mr-1 inline-block h-4 w-4 fill-primary"
                >
                  <path
                    d="M19 14c1.49-1.46 3-3.21 3-5.5A5.5 5.5 0 0 0 16.5 3c-1.76 0-3 .5-4.5 2-1.5-1.5-2.74-2-4.5-2A5.5 5.5 0 0 0 2 8.5c0 2.3 1.5 4.05 3 5.5l7 7Z"
                  ></path>
                </svg>
                1.2K
              </div>
              <div>
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
                  class="mr-1 inline-block h-4 w-4 fill-primary"
                >
                  <path d="M2 12s3-7 10-7 10 7 10 7-3 7-10 7-10-7-10-7Z"></path>
                  <circle cx="12" cy="12" r="3"></circle>
                </svg>
                5.4K
              </div>
            </div>
          </div>
          <div class="flex items-center space-x-4 text-sm text-gray-500 dark:text-gray-400">
            <div>Olivia Davis</div>
            <div>•</div>
            <div>May 9, 2024</div>
          </div>
          <div class="prose prose-sm dark:prose-invert">
            <p>
              {{ data.content }}
            </p>
            <p>
              The design of the Acme Prism T-Shirt is as striking as it is comfortable. The shirt
              features a unique prism-inspired pattern that adds a modern and eye-catching touch to
              your ensemble.
            </p>
          </div>
        </div>
        <div class="mt-6 border-t pt-6 dark:border-gray-800">
          <h3 class="text-lg font-bold">Comments</h3>
          <div class="space-y-6">
            <div class="flex items-start space-x-4">
              <span class="relative flex shrink-0 overflow-hidden rounded-full w-10 h-10 border">
                <span class="flex h-full w-full items-center justify-center rounded-full bg-muted"
                  >AC</span
                >
              </span>
              <div class="flex-1">
                <div class="flex items-center justify-between">
                  <div>
                    <div class="font-medium">John Doe</div>
                    <div class="text-sm text-gray-500 dark:text-gray-400">2 days ago</div>
                  </div>
                  <div class="flex items-center space-x-2">
                    <button
                      class="inline-flex items-center justify-center whitespace-nowrap rounded-md text-sm font-medium ring-offset-background transition-colors focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-ring focus-visible:ring-offset-2 disabled:pointer-events-none disabled:opacity-50 hover:bg-accent hover:text-accent-foreground h-10 w-10"
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
                        class="w-4 h-4 fill-primary"
                      >
                        <path
                          d="M19 14c1.49-1.46 3-3.21 3-5.5A5.5 5.5 0 0 0 16.5 3c-1.76 0-3 .5-4.5 2-1.5-1.5-2.74-2-4.5-2A5.5 5.5 0 0 0 2 8.5c0 2.3 1.5 4.05 3 5.5l7 7Z"
                        ></path>
                      </svg>
                      <span class="sr-only">Like</span>
                    </button>
                    <button
                      class="inline-flex items-center justify-center whitespace-nowrap rounded-md text-sm font-medium ring-offset-background transition-colors focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-ring focus-visible:ring-offset-2 disabled:pointer-events-none disabled:opacity-50 hover:bg-accent hover:text-accent-foreground h-10 w-10"
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
                        class="w-4 h-4 fill-primary"
                      >
                        <polyline points="9 17 4 12 9 7"></polyline>
                        <path d="M20 18v-2a4 4 0 0 0-4-4H4"></path>
                      </svg>
                      <span class="sr-only">Reply</span>
                    </button>
                  </div>
                </div>
                <div class="mt-2 text-sm">
                  This t-shirt looks amazing! I love the unique prism design.
                </div>
              </div>
            </div>
            <div class="flex items-start space-x-4">
              <span class="relative flex shrink-0 overflow-hidden rounded-full w-10 h-10 border">
                <span class="flex h-full w-full items-center justify-center rounded-full bg-muted"
                  >AC</span
                >
              </span>
              <div class="flex-1">
                <div class="flex items-center justify-between">
                  <div>
                    <div class="font-medium">Jane Smith</div>
                    <div class="text-sm text-gray-500 dark:text-gray-400">1 week ago</div>
                  </div>
                  <div class="flex items-center space-x-2">
                    <button
                      class="inline-flex items-center justify-center whitespace-nowrap rounded-md text-sm font-medium ring-offset-background transition-colors focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-ring focus-visible:ring-offset-2 disabled:pointer-events-none disabled:opacity-50 hover:bg-accent hover:text-accent-foreground h-10 w-10"
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
                        class="w-4 h-4 fill-primary"
                      >
                        <path
                          d="M19 14c1.49-1.46 3-3.21 3-5.5A5.5 5.5 0 0 0 16.5 3c-1.76 0-3 .5-4.5 2-1.5-1.5-2.74-2-4.5-2A5.5 5.5 0 0 0 2 8.5c0 2.3 1.5 4.05 3 5.5l7 7Z"
                        ></path>
                      </svg>
                      <span class="sr-only">Like</span>
                    </button>
                    <button
                      class="inline-flex items-center justify-center whitespace-nowrap rounded-md text-sm font-medium ring-offset-background transition-colors focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-ring focus-visible:ring-offset-2 disabled:pointer-events-none disabled:opacity-50 hover:bg-accent hover:text-accent-foreground h-10 w-10"
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
                        class="w-4 h-4 fill-primary"
                      >
                        <polyline points="9 17 4 12 9 7"></polyline>
                        <path d="M20 18v-2a4 4 0 0 0-4-4H4"></path>
                      </svg>
                      <span class="sr-only">Reply</span>
                    </button>
                  </div>
                </div>
                <div class="mt-2 text-sm">
                  I can't wait to get my hands on this t-shirt! The quality and design look
                  top-notch.
                </div>
              </div>
            </div>
            <div class="flex items-start space-x-4">
              <span class="relative flex shrink-0 overflow-hidden rounded-full w-10 h-10 border">
                <span class="flex h-full w-full items-center justify-center rounded-full bg-muted"
                  >AC</span
                >
              </span>
              <div class="flex-1">
                <div class="flex items-center justify-between">
                  <div>
                    <div class="font-medium">Michael Johnson</div>
                    <div class="text-sm text-gray-500 dark:text-gray-400">3 days ago</div>
                  </div>
                  <div class="flex items-center space-x-2">
                    <button
                      class="inline-flex items-center justify-center whitespace-nowrap rounded-md text-sm font-medium ring-offset-background transition-colors focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-ring focus-visible:ring-offset-2 disabled:pointer-events-none disabled:opacity-50 hover:bg-accent hover:text-accent-foreground h-10 w-10"
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
                        class="w-4 h-4 fill-primary"
                      >
                        <path
                          d="M19 14c1.49-1.46 3-3.21 3-5.5A5.5 5.5 0 0 0 16.5 3c-1.76 0-3 .5-4.5 2-1.5-1.5-2.74-2-4.5-2A5.5 5.5 0 0 0 2 8.5c0 2.3 1.5 4.05 3 5.5l7 7Z"
                        ></path>
                      </svg>
                      <span class="sr-only">Like</span>
                    </button>
                    <button
                      class="inline-flex items-center justify-center whitespace-nowrap rounded-md text-sm font-medium ring-offset-background transition-colors focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-ring focus-visible:ring-offset-2 disabled:pointer-events-none disabled:opacity-50 hover:bg-accent hover:text-accent-foreground h-10 w-10"
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
                        class="w-4 h-4 fill-primary"
                      >
                        <polyline points="9 17 4 12 9 7"></polyline>
                        <path d="M20 18v-2a4 4 0 0 0-4-4H4"></path>
                      </svg>
                      <span class="sr-only">Reply</span>
                    </button>
                  </div>
                </div>
                <div class="mt-2 text-sm">
                  The prism design is so unique and eye-catching. I can't wait to see this in
                  person.
                </div>
              </div>
            </div>
          </div>
        </div>
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

.no-scroll {
  overflow: hidden; /* 스크롤 방지 */
}
</style>
