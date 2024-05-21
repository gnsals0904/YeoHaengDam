<script setup>
import MyPageSide from '@/components/common/MyPageSide.vue';
</script>

<template>
  <div class="grid min-h-screen w-full overflow-hidden lg:grid-cols-[280px_1fr]">
    <MyPageSide />

    <div class="bg-white rounded-lg p-6 shadow-lg">
      <h2 class="text-2xl font-bold mb-4">내 글 목록</h2>

      <!-- 카드로 빼면 될듯 -->
      <div class="grid grid-cols-1 gap-6">
        <div class="bg-[#F0F8FF] rounded-lg p-4 shadow-lg flex justify-between items-center">
          <div>
            <h3 class="text-lg font-bold mb-2">자세히보기 누르면 게시판 내 글로 이동</h3>
            <p class="text-gray-500 mb-4">작성일</p>
            <div class="text-gray-500 mb-4">
              <p>게시글 내용 들어가야하는부분</p>
            </div>
            <a
              class="bg-[#00B8D4] hover:bg-[#0097A7] text-white font-bold py-2 px-4 rounded-lg transition-colors"
            >
              자세히 보기
            </a>
          </div>
          <div class="text-right">
            <p class="text-gray-500">조회수: 123</p>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped>
/* Add specific styles if needed */
</style>
