<script setup>

import { useRouter } from 'vue-router';
import MyPageSide from '@/components/common/MyPageSide.vue';
const router = useRouter();
</script>


<template>
    <div class="grid min-h-screen w-full overflow-hidden lg:grid-cols-[280px_1fr]">
    <MyPageSide />

    <div class="bg-white rounded-lg p-6 shadow-lg">
  <h2 class="text-2xl font-bold mb-4">내 여행 경로</h2>

  
  <!-- 카드로 빼면 될듯 -->
  <div class="grid grid-cols-1 gap-6">
    <div class="bg-[#F0F8FF] rounded-lg p-4 shadow-lg">
      <h3 class="text-lg font-bold mb-2">여행 경로 1</h3>
      <p class="text-gray-500 mb-4">2023년 5월 1일 - 5월 5일 제주도 여행</p>
      <div class="text-gray-500 mb-4">
        <p>제주도는 한국의 대표적인 관광지로, 아름다운 자연경관과 다양한 액티비티를 즐길 수 있는 곳입니다. 
          한라산을 등반하거나, 섭지코지와 성산일출봉에서 해돋이를 감상할 수 있습니다. 
          또한, 제주도는 다양한 해양 스포츠를 즐길 수 있는 장소이기도 합니다. 
          이 외에도 제주 전통 시장에서 지역 특산품을 구경하거나, 해변에서 여유로운 시간을 보낼 수 있습니다.</p>
      </div>
      <a
        class="bg-[#00B8D4] hover:bg-[#0097A7] text-white font-bold py-2 px-4 rounded-lg transition-colors"
      >
        자세히 보기
      </a>
    </div>
  </div>


</div>
    </div>
</template>

<style>
</style>