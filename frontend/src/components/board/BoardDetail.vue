<script setup>
import { defineProps, defineEmits } from "vue";

const props = defineProps({
  item: {
    type: Object,
    required: true,
  },
  visible: {
    type: Boolean,
    required: true,
  },
});

const emit = defineEmits(["close"]);

const closeModal = () => {
  emit("close");
};
</script>

<template>
  <div
    v-if="visible"
    class="fixed inset-0 z-[999] grid h-screen w-screen place-items-center bg-black bg-opacity-60 backdrop-blur-sm transition-opacity duration-300"
    @click="closeModal"
  >
    <div
      class="flex rounded-lg bg-white min-h-[20%] max-h-[95%] min-w-[20%] max-w-[90%]"
    >
      <div
        class="relative text-base font-light leading-relaxed text-blue-gray-500 antialiased shadow-2xl"
        role="dialog"
        @click.stop
      >
        <div
          class="flex shrink-0 items-center justify-between p-4 text-2xl font-semibold leading-snug text-blue-gray-900 antialiased"
        >
          <div class="flex items-center gap-3">
            <img
              :alt="item.title"
              :src="
                item.img2 ||
                'https://source.unsplash.com/800x450/?Beautifulgirl'
              "
              class="relative inline-block h-9 w-9 rounded-full object-cover object-center"
            />
            <div class="-mt-px flex flex-col">
              <p
                class="block text-xl font-medium leading-normal text-blue-gray-900 antialiased"
              >
                {{ item.title }}
              </p>
              <p class="block text-xs font-normal text-gray-700 antialiased">
                @{{ item.nickname }}
              </p>
            </div>
          </div>
          <div class="flex items-center gap-2">
            <button
              class="relative h-8 max-h-[32px] w-8 max-w-[32px] select-none rounded-lg text-center align-middle text-xs font-medium uppercase text-blue-gray-500 transition-all hover:bg-blue-gray-500/10 active:bg-blue-gray-500/30 disabled:pointer-events-none disabled:opacity-50 disabled:shadow-none"
              type="button"
              @click="closeModal"
            >
              <span
                class="absolute top-1/2 left-1/2 -translate-y-1/2 -translate-x-1/2 transform"
              >
                <svg
                  xmlns="http://www.w3.org/2000/svg"
                  viewBox="0 0 24 24"
                  fill="currentColor"
                  aria-hidden="true"
                  class="h-5 w-5"
                >
                  <path
                    fill-rule="evenodd"
                    d="M6.225 4.811a.75.75 0 011.06 0L12 9.525l4.715-4.714a.75.75 0 011.06 1.06L13.06 10.5l4.715 4.714a.75.75 0 01-1.06 1.06L12 11.525l-4.714 4.714a.75.75 0 01-1.06-1.06L10.94 10.5 6.225 5.775a.75.75 0 010-1.06z"
                    clip-rule="evenodd"
                  ></path>
                </svg>
              </span>
            </button>
          </div>
        </div>
        <div
          class="relative border-t border-b border-t-blue-gray-100 border-b-blue-gray-100 p-0 text-base font-light leading-relaxed text-blue-gray-500 antialiased max-h-[75vh] overflow-y-auto"
        >
          <img
            :alt="item.title"
            :src="item.img1 || 'https://source.unsplash.com/800x450/?nature'"
            class="w-full h-auto max-h-[50vh] object-cover"
          />
        </div>

        <div class="p-4 text-blue-gray-500 overflow-auto max-h-[20vh]">
          <p>{{ item.content }}</p>
        </div>
        <div
          class="flex shrink-0 flex-wrap items-center justify-between p-4 text-blue-gray-500"
        >
          <div class="flex items-center gap-16">
            <div>
              <p
                class="block text-sm font-normal leading-normal text-gray-700 antialiased"
              >
                Views
              </p>
              <p
                class="block text-base font-medium leading-relaxed text-blue-gray-900 antialiased"
              >
                {{ item.hit }}
              </p>
            </div>
            <div>
              <p
                class="block text-sm font-normal leading-normal text-gray-700 antialiased"
              >
                Downloads
              </p>
              <p
                class="block text-base font-medium leading-relaxed text-blue-gray-900 antialiased"
              >
                553,031
              </p>
            </div>
          </div>
          <button
            class="flex select-none items-center gap-3 rounded-lg border border-blue-gray-500 py-2 px-4 text-center align-middle text-xs font-bold uppercase text-blue-gray-500 transition-all hover:opacity-75 focus:ring focus:ring-blue-gray-200 active:opacity-[0.85] disabled:pointer-events-none disabled:opacity-50 disabled:shadow-none"
            type="button"
          >
            <svg
              xmlns="http://www.w3.org/2000/svg"
              viewBox="0 0 24 24"
              fill="currentColor"
              aria-hidden="true"
              class="h-4 w-4"
            >
              <path
                fill-rule="evenodd"
                d="M15.75 4.5a3 3 0 11.825 2.066l-8.421 4.679a3.002 3.002 0 010 1.51l8.421 4.679a3 3 0 11-.729 1.31l-8.421-4.678a3 3 0 110-4.132l8.421-4.679a3 3 0 01-.096-.755z"
                clip-rule="evenodd"
              ></path>
            </svg>
            Share
          </button>
        </div>
      </div>
      <!-- 댓글 부분 -->
      <div class="col-span-1 relative pl-4 bg-white w-full">
        <header class="border-b border-grey-400">
          <a
            href="#"
            class="block cursor-pointer py-4 flex items-center text-sm outline-none focus:outline-none focus:border-gray-300 transition duration-150 ease-in-out"
          >
            <img
              src="https://images.pexels.com/photos/614810/pexels-photo-614810.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260"
              class="h-9 w-9 rounded-full object-cover"
              alt="user"
            />
            <p class="block ml-2 font-bold">Paul</p>
          </a>
        </header>
        <div>
          <div class="pt-1">
            <div class="text-sm mb-2 flex flex-start items-center">
              <div>
                <a
                  href="#"
                  class="cursor-pointer flex items-center text-sm border-2 border-transparent rounded-full focus:outline-none focus:border-gray-300 transition duration-150 ease-in-out"
                >
                  <img
                    class="h-8 w-8 rounded-full object-cover"
                    src="https://images.pexels.com/photos/1450082/pexels-photo-1450082.jpeg?auto=compress&cs=tinysrgb&dpr=3&h=750&w=1260"
                    alt="user"
                  />
                </a>
              </div>
              <p class="font-bold ml-2">
                <a class="cursor-pointer">Joshua:</a>
                <span class="text-gray-700 font-medium ml-1"> Good post </span>
              </p>
            </div>
          </div>
          <div class="text-sm mb-2 flex flex-start items-center">
            <div>
              <a
                href="#"
                class="cursor-pointer flex items-center text-sm border-2 border-transparent rounded-full focus:outline-none focus:border-gray-300 transition duration-150 ease-in-out"
              >
                <img
                  class="h-8 w-8 rounded-full object-cover"
                  src="https://images.pexels.com/photos/3861456/pexels-photo-3861456.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260"
                  alt="user"
                />
              </a>
            </div>
            <p class="font-bold ml-2">
              <a class="cursor-pointer">Kesha:</a>
              <span class="text-gray-700 font-medium ml-1">
                This is amazing
              </span>
            </p>
          </div>
        </div>
        <div class="absolute bottom-0 left-0 right-0 pl-4">
          <div class="pt-4">
            <div class="mb-2">
              <div class="flex items-center">
                <span class="mr-3 inline-flex items-center cursor-pointer">
                  <svg
                    class="fill-heart text-gray-700 inline-block h-7 w-7 heart"
                    xmlns="http://www.w3.org/2000/svg"
                    fill="none"
                    viewBox="0 0 24 24"
                    stroke="currentColor"
                  >
                    <path
                      stroke-linecap="round"
                      stroke-linejoin="round"
                      stroke-width="2"
                      d="M4.318 6.318a4.5 4.5 0 000 6.364L12 20.364l7.682-7.682a4.5 4.5 0 00-6.364-6.364L12 7.636l-1.318-1.318a4.5 4.5 0 00-6.364 0z"
                    />
                  </svg>
                </span>
                <span class="mr-3 inline-flex items-center cursor-pointer">
                  <svg
                    class="text-gray-700 inline-block h-7 w-7"
                    xmlns="http://www.w3.org/2000/svg"
                    fill="none"
                    viewBox="0 0 24 24"
                    stroke="currentColor"
                  >
                    <path
                      stroke-linecap="round"
                      stroke-linejoin="round"
                      stroke-width="2"
                      d="M8 12h.01M12 12h.01M16 12h.01M21 12c0 4.418-4.03 8-9 8a9.863 9.863 0 01-4.255-.949L3 20l1.395-3.72C3.512 15.042 3 13.574 3 12c0-4.418 4.03-8 9-8s9 3.582 9 8z"
                    />
                  </svg>
                </span>
              </div>
              <span class="text-gray-600 text-sm font-bold">2344 Likes</span>
            </div>
            <span class="block ml-2 text-xs text-gray-600">5 minutes</span>
          </div>

          <div class="pt-4 pb-1 pr-3">
            <div class="flex items-start">
              <textarea
                class="w-full resize-none outline-none appearance-none"
                aria-label="Agrega un comentario..."
                placeholder="Agrega un comentario..."
                autocomplete="off"
                autocorrect="off"
                style="height: 36px"
              ></textarea>
              <button
                class="mb-2 focus:outline-none border-none bg-transparent text-blue-600"
              >
                Publicar
              </button>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped></style>
