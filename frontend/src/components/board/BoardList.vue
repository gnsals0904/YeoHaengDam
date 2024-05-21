<script setup>
import { ref, computed, onMounted } from "vue";
import axios from "axios";
import { useRouter } from "vue-router";
import { useBoardStore } from "@/stores/board";
import { useMemberStore } from "@/stores/member";
import BoardCard from "@/components/board/BoardCard.vue";
import Pagination from "@/components/common/Pagination.vue";
import BoardDetail from "@/components/board/BoardDetail.vue"; // 모달 컴포넌트 가져오기

const boardStore = useBoardStore();
const currentPage = ref(1);
const totalElements = ref(0); // 전체 게시글 수
const pageSize = ref(10); // 페이지당 게시글 수
const totalPages = computed(() => Math.ceil(totalElements.value / pageSize.value)); // 총 페이지 수 계산
const isModalVisible = ref(false);
const selectedItem = ref(null);
const memberStore = useMemberStore();
const isLogin = computed(() => memberStore.isLogin);
const comments = ref([]);
const boardList = ref([]);

async function fetchBoardList(page) {
  
  try {
    const response = await axios.get(`http://localhost:8080/api/articles/list`, {
      params: {
        page,
        size: 10, // 페이지당 10개의 콘텐츠를 가져옴
      },
    });
    console.log(page);
    console.log(page);
    
    
    console.log(response);
    boardList.value = response.data;
    // boardStore.getList(response.data.content);

    console.log(response.data);
    totalElements.value = response.data[0].totalCount; // 전체 게시글 수 설정
    console.log(totalElements.value);
  } catch (error) {
    console.error('Failed to fetch board list:', error);
  }
}

function updatePage(newPage) {
  currentPage.value = newPage;
  fetchBoardList(newPage); // 페이지 변경 시 데이터 다시 로드
}

async function showModal(board) {
  try {
    const articleResponse = await axios.get(`http://localhost:8080/api/articles/${board.articleId}`);
    const commentsResponse = await axios.get(`http://localhost:8080/api/comment/${board.articleId}`);
    selectedItem.value = articleResponse.data;
    comments.value = commentsResponse.data;
    isModalVisible.value = true;
  } catch (error) {
    console.error('Failed to fetch article details or comments:', error);
  }
}

function closeModal() {
  isModalVisible.value = false;
}

onMounted(() => {
  fetchBoardList(currentPage.value); // 컴포넌트 마운트 시 데이터 로드
});
</script>

<template>
  <div class="relative min-h-screen">
    <div class="bg-cover w-full flex justify-center items-center">
      <div class="w-full bg-white bg-opacity-40 backdrop-filter backdrop-blur-lg">
        <div class="w-12/12 mx-auto rounded-2xl bg-white p-5 bg-opacity-40 backdrop-filter backdrop-blur-lg">
          <div class="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-4 gap-5 text-center px-3 mx-auto">
            <BoardCard
              v-for="board in boardList"
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
            >
              글 작성하기
            </router-link>
            <div
              v-else
              class="flex items-center py-3 px-5 text-base font-medium text-center text-gray-700 rounded-lg bg-gray-300"
            >
              글을 작성하려면 로그인 해주세요
            </div>
          </div>
          <Pagination
            :value="currentPage"
            :total-page-count="totalPages"
            :page-display-count="5"
            @change="updatePage"
          />
        </div>
      </div>
    </div>
    <BoardDetail
      :item="selectedItem"
      :comments="comments"
      :visible="isModalVisible"
      @close="closeModal"
    />
  </div>
</template>

<style scoped></style>
