<script setup>
import { defineProps, defineEmits } from 'vue';

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

const emit = defineEmits(['close']);

const closeModal = () => {
  emit('close');
};
</script>

<template>
  <div
    v-if="visible"
    class="fixed inset-0 z-[999] grid h-screen w-screen place-items-center bg-black bg-opacity-60 backdrop-blur-sm transition-opacity duration-300"
    @click="closeModal"
  >
    <div
      class="relative m-4 w-3/4 min-h-[20%] max-h-[95%] min-w-[20%] max-w-[50%] rounded-lg bg-white text-base font-light leading-relaxed text-blue-gray-500 antialiased shadow-2xl"
      role="dialog"
      @click.stop
    >
      <div
        class="flex shrink-0 items-center justify-between p-4 text-2xl font-semibold leading-snug text-blue-gray-900 antialiased"
      >
        <div class="flex items-center gap-3">
          <img
            :alt="item.title"
            :src="item.img2"
            class="relative inline-block h-9 w-9 rounded-full object-cover object-center"
          />
          <div class="-mt-px flex flex-col">
            <p
              class="block text-sm font-medium leading-normal text-blue-gray-900 antialiased"
            >
              {{ item.title }}
            </p>
            <p class="block text-xs font-normal text-gray-700 antialiased">
              @{{ item.addr1 }}
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
                  d="M11.645 20.91l-.007-.003-.022-.012a15.247 15.247 0 01-.383-.218 25.18 25.18 0 01-4.244-3.17C4.688 15.36 2.25 12.174 2.25 8.25 2.25 5.322 4.714 3 7.688 3A5.5 5.5 0 0112 5.052 5.5 5.5 0 0116.313 3c2.973 0 5.437 2.322 5.437 5.25 0 3.925-2.438 7.111-4.739 9.256a25.175 25.175 0 01-4.244 3.17 15.247 15.247 0 01-.383.219l-.022.012-.007.004-.003.001a.752.752 0 01-.704 0l-.003-.001z"
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
          :src="item.img1"
          class="w-full h-auto max-h-[50vh] object-cover"
        />
      </div>

      <div class="p-4 text-blue-gray-500 overflow-auto max-h-[20vh]">
        <p>{{ item.description }}</p>
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
              44,082,044
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
  </div>
</template>

<style scoped></style>
