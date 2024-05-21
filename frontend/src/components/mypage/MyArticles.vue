<script setup>
import { ref, onMounted } from 'vue';
import axios from 'axios';
import MyPageSide from '@/components/common/MyPageSide.vue';
import BoardDetail from "@/components/board/BoardDetail.vue"; // 모달 컴포넌트 가져오기

// 데이터 변수 설정
const articles = ref([]);
const selectedItem = ref(null);
const token = sessionStorage.getItem('accessToken'); // 토큰을 세션 스토리지에서 가져옵니다.
const comments = ref([]);
const isModalVisible = ref(false);

// 데이터 가져오기 함수
const fetchArticles = async () => {
  try {
    const response = await axios.get('http://localhost:8080/api/articles', {
      headers: {
        'Authorization': `Bearer ${token}` // Authorization 헤더에 토큰을 추가합니다.
      }
    });
    articles.value = response.data;
  } catch (error) {
    console.error('Error fetching articles:', error);
  }
};

// 컴포넌트가 마운트될 때 데이터 가져오기
onMounted(() => {
  fetchArticles();
});


async function showModal(board) {
  try {
    // 상세 보기
    const articleResponse = await axios.get(
      `http://localhost:8080/api/articles/${board.articleId}`
    );
    // 댓글 가져오기
    const commentsResponse = await axios.get(
      `http://localhost:8080/api/comment/${board.articleId}`
    );
    selectedItem.value = articleResponse.data;
    comments.value = commentsResponse.data;
    console.log("게시글 상세 받은데이터 : ", articleResponse.data);
    console.log("게시글 상세 : ", selectedItem.value);
    console.log("댓글 : ", comments.value);
    isModalVisible.value = true;
  } catch (error) {
    console.error("Failed to fetch article details or comments:", error);
  }
}

function closeModal() {
  isModalVisible.value = false;
}
</script>

<template>
  <div class="grid min-h-screen w-full overflow-hidden lg:grid-cols-[280px_1fr]">
    <MyPageSide />

    <div class="bg-white rounded-lg p-6 shadow-lg">
      <h2 class="text-2xl font-bold mb-4">내 글 목록</h2>

      <!-- 데이터 렌더링 -->
      <div class="grid grid-cols-1 gap-6">
        <div
          v-for="article in articles"
          :key="article.articleId"
          @click="showModal(article)"
          class="bg-[#F0F8FF] rounded-lg p-4 shadow-lg flex justify-between items-center"
        >
          <div>
            <h3 class="text-lg font-bold mb-2">{{ article.title }}</h3>
            <p class="text-gray-500 mb-4">{{ article.createdAt }}</p>
            <div class="text-gray-500 mb-4">
              <p>{{ article.content }}</p>
            </div>
            <a
              class="bg-[#00B8D4] hover:bg-[#0097A7] text-white font-bold py-2 px-4 rounded-lg transition-colors"
              @click="() => router.push(`/articles/${article.articleId}`)"
            >
              자세히 보기
            </a>
          </div>
          <div class="text-right">
            <p class="text-gray-500">조회수: {{ article.hit }}</p>
          </div>
        </div>
      </div>
    </div>
  </div>
  <BoardDetail
      :item="selectedItem"
      :comments="comments"
      :visible="isModalVisible"
      @close="closeModal"
    />
</template>

<style scoped>
/* Add specific styles if needed */
</style>
