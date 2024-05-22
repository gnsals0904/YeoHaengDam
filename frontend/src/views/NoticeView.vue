<script setup>
import { ref, onMounted, computed } from "vue";
import axios from "axios";
import TableRow from "@/components/notice/TableRow.vue";
import NoticeDetail from "@/components/notice/NoticeDetail.vue";
import { useMemberStore } from "@/stores/member";
import Pagination from "@/components/common/Pagination.vue";

const memberStore = useMemberStore();
const rows = ref([]);
const selectedItem = ref(null);
const isModalVisible = ref(false);
const currentPage = ref(1);
const totalElements = ref(0);
const pageSize = ref(10);
const totalPages = computed(() => Math.ceil(totalElements.value / pageSize.value));

const handleRowClick = (item) => {
  selectedItem.value = item;
  isModalVisible.value = true;
};

const closeModal = () => {
  isModalVisible.value = false;
};

async function fetchNotices(page) {
  try {
    const response = await axios.get("http://localhost:8080/api/notice/list", {
      params: {
        page,
        size: 10, // 페이지당 10개의 콘텐츠를 가져옴
      },
    });
    rows.value = response.data;
    console.log(response);

    totalElements.value = response.data[0].totalCount;

    console.log(totalElements.value);
    console.log("isAdmin:", memberStore.isAdmin);
  } catch (error) {
    console.error("Failed to fetch notices:", error);
  }
}

function updatePage(newPage) {
  currentPage.value = newPage;
  fetchNotices(newPage); // 페이지 변경 시 데이터 다시 로드
}

onMounted(() => {
  fetchNotices();
});
</script>

<template>
  <div class="bg-white pb-4 px-4 rounded-md w-full">
    <div class="flex justify-between w-full pt-6">
      <p class="ml-3 text-2xl">공지 사항</p>
      <svg width="14" height="4" viewBox="0 0 14 4" fill="none" xmlns="http://www.w3.org/2000/svg">
        <g opacity="0.4">
          <circle cx="2.19796" cy="1.80139" r="1.38611" fill="#222222" />
          <circle cx="11.9013" cy="1.80115" r="1.38611" fill="#222222" />
          <circle cx="7.04991" cy="1.80115" r="1.38611" fill="#222222" />
        </g>
      </svg>
    </div>
    <div class="w-full flex justify-end px-2 mt-2 gap-x-3">
      <router-link
        :to="{ name: 'NoticeEditor' }"
        v-if="memberStore.isAdmin"
        class="flex items-center justify-center px-5 text-white rounded-lg bg-red-500 hover:bg-red-700 focus:ring-4 focus:ring-red-300 dark:focus:ring-red-900"
      >
        공지사항 작성
      </router-link>
    </div>
    <div class="overflow-x-auto mt-6">
      <table class="table-auto border-collapse w-full">
        <thead>
          <tr
            class="rounded-lg text-sm font-medium text-gray-700 text-left"
            style="font-size: 0.9674rem"
          >
            <th
              class="px-4 py-2 bg-gray-200 first:rounded-tl-lg first:rounded-bl-lg last:rounded-tr-lg last:rounded-br-lg"
            >
              제 목
            </th>
            <th class="px-4 py-2 bg-gray-200">작성자</th>
            <th class="px-4 py-2 bg-gray-200">날짜</th>
          </tr>
        </thead>
        <tbody class="text-sm font-normal text-gray-700">
          <TableRow
            v-for="(row, index) in rows"
            :key="index"
            :item="row"
            @row-click="handleRowClick"
          />
        </tbody>
      </table>
    </div>
    <Pagination
      :value="currentPage"
      :total-page-count="totalPages"
      :page-display-count="5"
      @change="updatePage"
    />
  </div>

  <NoticeDetail :item="selectedItem" :visible="isModalVisible" @close="closeModal" />
</template>

<style scoped></style>
