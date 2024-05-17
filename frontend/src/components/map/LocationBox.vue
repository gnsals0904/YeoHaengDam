<script setup>
import { defineProps, defineEmits } from 'vue';

const props = defineProps({
  item: {
    type: Object,
    required: true,
  },
});

const emit = defineEmits(['click']);
</script>

<template>
  <div
    class="mb-4 relative flex flex-col md:flex-row md:space-x-5 space-y-3 md:space-y-0 rounded-xl shadow-lg p-2 max-w-xs md:max-w-3xl mx-auto border border-blue-500 before:absolute before:-bottom-2 before:-right-2 before:h-4 before:w-4 before:border-b before:border-r before:border-blue-500 before:transition-all before:duration-300 before:ease-in-out after:absolute after:-top-2 after:-left-2 after:h-4 after:w-4 after:border-t after:border-l after:border-blue-500 after:transition-all after:duration-300 after:ease-in-out hover:before:h-[calc(100%+16px)] hover:before:w-[calc(100%+16px)] hover:after:h-[calc(100%+16px)] hover:after:w-[calc(100%+16px)]"
    @click="emit('click', item)"
  >
    <div class="w-full md:w-1/3 grid place-items-center">
      <img
        :src="item.img2 || 'noimage.PNG'"
        alt="위치 이미지"
        class="rounded-xl object-cover"
      />
    </div>
    <div class="w-full md:w-2/3 flex flex-col space-y-2 p-1">
      <div class="flex justify-between item-center">
        <p class="text-gray-500 font-medium hidden md:block">
          {{ item.contentTypeId }}
        </p>
        <div class="flex items-center">
          <svg
            xmlns="http://www.w3.org/2000/svg"
            class="h-5 w-5 text-yellow-500"
            viewBox="0 0 20 20"
            fill="currentColor"
          >
            <path
              d="M9.049 2.927c.3-.921 1.603-.921 1.902 0l1.07 3.292a1 1 0 00.95.69h3.462c.969 0 1.371 1.24.588 1.81l-2.8 2.034a1 1 0 00-.364 1.118l1.07 3.292c.3.921-.755 1.688-1.54 1.118l-2.8-2.034a1 1 0 00-1.175 0l-2.8 2.034c-.784.57-1.838-.197-1.539-1.118l1.07-3.292a1 1 0 00-.364-1.118L2.98 8.72c-.783-.57-.38-1.81.588-1.81h3.461a1 1 0 00.951-.69l1.07-3.292z"
            />
          </svg>
          <p class="text-gray-600 font-bold text-sm ml-1">
            4.96
            <span class="text-gray-500 font-normal">(76 reviews)</span>
          </p>
        </div>
        <div class="">
          <svg
            xmlns="http://www.w3.org/2000/svg"
            class="h-5 w-5 text-pink-500"
            viewBox="0 0 20 20"
            fill="currentColor"
          >
            <path
              fill-rule="evenodd"
              d="M3.172 5.172a4 4 0 015.656 0L10 6.343l1.172-1.171a4 4 0 115.656 5.656L10 17.657l-6.828-6.829a4 4 0 010-5.656z"
              clip-rule="evenodd"
            />
          </svg>
        </div>
        <div
          class="bg-gray-200 px-2 py-1 rounded-full text-xs font-medium text-gray-800 hidden md:block"
        >
          상세 보기
        </div>
      </div>
      <h5 class="font-black text-gray-800 md:text-lg text-lg truncate">
        {{ item.title }}
      </h5>
      <!-- <p class="md:text-lg text-gray-500 text-base">
        The best kept secret of The Bahamas is the country’s sheer size and
        diversity. With 16 major islands, The Bahamas is an unmatched
        destination
      </p> -->
      <p class="text-sm font-black text-gray-800 truncate">
        {{ item.addr1 }}
      </p>
      <p class="font-normal text-gray-600 text-xs truncate">{{ item.addr2 }}</p>
    </div>
  </div>
</template>

<style scoped></style>
