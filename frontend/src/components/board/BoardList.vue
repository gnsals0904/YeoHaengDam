<script setup>
import { ref, computed } from "vue";
import axios from "axios";
import { RouterView } from "vue-router";
import { useBoardStore } from "@/stores/board";
import { useRouter } from "vue-router";
import { useMemberStore } from "@/stores/member";
import BoardCard from "@/components/board/BoardCard.vue";
import Pagination from "./Pagination.vue";
import BoardDetail from "@/components/board/BoardDetail.vue"; // 모달 컴포넌트 가져오기

const boardStore = useBoardStore();
boardStore.getList();

const currentPage = ref(1);
const totalPages = ref(5);

const isModalVisible = ref(false);
const selectedItem = ref(null);
const memberStore = useMemberStore();
const isLogin = computed(() => memberStore.isLogin);
function updatePage(newPage) {
  currentPage.value = newPage;
}

async function showModal(board) {
  try {
    const response = await axios.get(
      `http://localhost:8080/api/articles/${board.articleId}`
    );
    selectedItem.value = response.data;
    console.log("댓글 : ", selectedItem.value);
    isModalVisible.value = true;
  } catch (error) {
    console.error("Failed to fetch article details:", error);
  }
}

function closeModal() {
  isModalVisible.value = false;
}
</script>

<template>
  <div class="relative min-h-screen">
    <div class="bg-cover w-full flex justify-center items-center">
      <div
        class="w-full bg-white bg-opacity-40 backdrop-filter backdrop-blur-lg"
      >
        <div
          class="w-12/12 mx-auto rounded-2xl bg-white p-5 bg-opacity-40 backdrop-filter backdrop-blur-lg"
        >
          <div
            class="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-4 gap-5 text-center px-3 mx-auto"
          >
            <BoardCard
              v-for="board in boardStore.boardList"
              :key="board.articleId"
              :board="board"
              @click="showModal(board)"
            />
          </div>
          <div class="flex justify-end">
            <router-link
              v-if="isLogin"
              :to="{ name: 'BoardEditor' }"
              class="flex items-center py-3 px-5 text-base font-medium text-center text-white rounded-lg bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:ring-blue-300 dark:focus:ring-blue-900"
              >글 작성하기</router-link
            >
            <div
              v-else
              class="flex items-center py-3 px-5 text-base font-medium text-center text-gray-700 rounded-lg bg-gray-300"
            >
              글을 작성하려면 로그인 해주세요
            </div>
          </div>
          <Pagination
            :current-page="currentPage"
            :total-pages="totalPages"
            @update:page="updatePage"
          />
        </div>
      </div>
    </div>
    <BoardDetail
      :item="selectedItem"
      :visible="isModalVisible"
      @close="closeModal"
    />
  </div>
</template>

<style scoped></style>
