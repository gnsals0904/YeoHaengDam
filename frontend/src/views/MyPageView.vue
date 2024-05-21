<script setup>
import router from '@/router';
</script>

<template>
  <div class="grid min-h-screen w-full overflow-hidden lg:grid-cols-[280px_1fr]">
    <div class="hidden border-r bg-gradient-to-b from-[#00B8D4] to-[#0097A7] lg:block">
      <div class="flex flex-col gap-2">
        <div class="flex h-[60px] items-center px-6">
          <a class="flex items-center gap-2 font-semibold text-white" href="#">
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
              class="h-6 w-6 text-white"
            >
              <path d="M19 21v-2a4 4 0 0 0-4-4H9a4 4 0 0 0-4 4v2"></path>
              <circle cx="12" cy="7" r="4"></circle>
            </svg>
            <span class="">마이페이지</span>
          </a>
        </div>
        <div class="flex-1">
          <nav class="grid items-start px-4 text-sm font-medium">
            <a
              class="flex items-center gap-3 rounded-lg px-3 py-2 text-white transition-all hover:bg-[#0097A7] dark:bg-[#0097A7] dark:text-white dark:hover:bg-[#008394]"
              href="#"
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
                class="h-4 w-4 text-white"
              >
                <path d="M19 21v-2a4 4 0 0 0-4-4H9a4 4 0 0 0-4 4v2"></path>
                <circle cx="12" cy="7" r="4"></circle>
              </svg>
              개인정보 확인/수정
            </a>
            <a
              class="flex items-center gap-3 rounded-lg px-3 py-2 text-white transition-all hover:bg-[#0097A7] dark:text-gray-400 dark:hover:text-white"
              href="#"
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
                class="h-4 w-4 text-white"
              >
                <path d="M15 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V7Z"></path>
                <path d="M14 2v4a2 2 0 0 0 2 2h4"></path>
                <path d="M10 9H8"></path>
                <path d="M16 13H8"></path>
                <path d="M16 17H8"></path>
              </svg>
              내 글 목록
            </a>
            <a
              class="flex items-center gap-3 rounded-lg px-3 py-2 text-white transition-all hover:bg-[#0097A7] dark:text-gray-400 dark:hover:text-white"
              href="#"
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
                class="h-4 w-4 text-white"
              >
                <path d="M20 10c0 6-8 12-8 12s-8-6-8-12a8 8 0 0 1 16 0Z"></path>
                <circle cx="12" cy="10" r="3"></circle>
              </svg>
              내 여행 경로
            </a>
            <a
              class="flex items-center gap-3 rounded-lg px-3 py-2 text-white transition-all hover:bg-[#0097A7] dark:text-gray-400 dark:hover:text-white"
              href="#"
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
                class="h-4 w-4 text-white"
              >
                <path d="M12.22 2h-.44a2 2 0 0 0-2 2v.18a2 2 0 0 1-1 1.73l-.43.25a2 2 0 0 1-2 0l-.15-.08a2 2 0 0 0-2.73.73l-.22.38a2 2 0 0 0 .73 2.73l.15.1a2 2 0 0 1 1 1.72v.51a2 2 0 0 1-1 1.74l-.15.09a2 2 0 0 0-.73 2.73l.22.38a2 2 0 0 0 2.73.73l.15-.08a2 2 0 0 1 2 0l.43.25a2 2 0 0 1 1 1.73V20a2 2 0 0 0 2 2h.44a2 2 0 0 0 2-2v-.18a2 2 0 0 1 1-1.73l.43-.25a2 2 0 0 1 2 0l.15.08a2 2 0 0 0 2.73-.73l.22-.39a2 2 0 0 0-.73-2.73l-.15-.08a2 2 0 0 1-1-1.74v-.5a2 2 0 0 1 1-1.74l.15-.09a2 2 0 0 0 .73-2.73l-.22-.38a2 2 0 0 0-2.73-.73l-.15.08a2 2 0 0 1-2 0l-.43-.25a2 2 0 0 1-1-1.73V4a2 2 0 0 0-2-2z"></path>
                <circle cx="12" cy="12" r="3"></circle>
              </svg>
              설정
            </a>
          </nav>
        </div>
      </div>
    </div>
    <div class="flex flex-col">
      <main class="flex flex-1 flex-col gap-4 p-4 md:gap-8 md:p-6">
        <div class="bg-gradient-to-r from-[#00B8D4] to-[#0097A7] rounded-lg p-6 shadow-lg">
          <h2 class="text-2xl font-bold text-white mb-4">마이페이지</h2>
          <div class="grid grid-cols-1 md:grid-cols-2 gap-6">
            <div class="bg-white rounded-lg p-4 shadow-lg">
              <h3 class="text-lg font-bold mb-2">개인정보 확인/수정</h3>
              <p class="text-gray-500 mb-4">자신의 개인정보를 확인하고 수정할 수 있습니다.</p>
              <button @click="router.push('/mypage/edit')"
                class="bg-[#00B8D4] hover:bg-[#0097A7] text-white font-bold py-2 px-4 rounded-lg transition-colors"
                href="#"
              >
                바로가기
              </button>
            </div>
            <div class="bg-white rounded-lg p-4 shadow-lg">
              <h3 class="text-lg font-bold mb-2">내 글 목록</h3>
              <p class="text-gray-500 mb-4">자신이 작성한 글 목록을 확인할 수 있습니다.</p>
              <a
                class="bg-[#00B8D4] hover:bg-[#0097A7] text-white font-bold py-2 px-4 rounded-lg transition-colors"
                href="#"
              >
                바로가기
              </a>
            </div>
            <div class="bg-white rounded-lg p-4 shadow-lg">
              <h3 class="text-lg font-bold mb-2">내 여행 경로</h3>
              <p class="text-gray-500 mb-4">자신의 여행 경로를 확인할 수 있습니다.</p>
              <a
                class="bg-[#00B8D4] hover:bg-[#0097A7] text-white font-bold py-2 px-4 rounded-lg transition-colors"
                href="#"
              >
                바로가기
              </a>
            </div>
            <div class="bg-white rounded-lg p-4 shadow-lg">
              <h3 class="text-lg font-bold mb-2">설정</h3>
              <p class="text-gray-500 mb-4">다양한 설정을 변경할 수 있습니다.</p>
              <a
                class="bg-[#00B8D4] hover:bg-[#0097A7] text-white font-bold py-2 px-4 rounded-lg transition-colors"
                href="#"
              >
                바로가기
              </a>
            </div>
          </div>
        </div>
        
      </main>
    </div>
  </div>
</template>

<style scoped></style>
