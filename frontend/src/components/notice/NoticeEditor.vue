<script setup>
import { ref, onMounted } from 'vue';
import axios from 'axios';
import { useRouter, useRoute } from 'vue-router';

const router = useRouter();
const route = useRoute();
const title = ref('');
const description = ref('');
const images = ref([]);
const isEditMode = ref(false);

const props = defineProps({
  articleId: String, // 라우터에서 받은 게시글 ID
});

const removeImage = (index) => {
  images.value.splice(index, 1);
};

const postArticle = async () => {
  const token = sessionStorage.getItem('accessToken');
  if (!token) {
    alert('로그인이 필요합니다.');
    return;
  }

  const formData = new FormData();
  formData.append('title', title.value);
  formData.append('content', description.value);
  try {
    await axios.post('http://localhost:8080/api/articles', formData, {
      headers: {
        Authorization: `Bearer ${token}`,
        'Content-Type': 'multipart/form-data',
      },
    });
    alert('공지사항이 등록되었습니다.');
    router.replace({ name: 'List' }); // 게시글 등록 후 이동할 경로
  } catch (error) {
    console.error('공지사항 등록 실패:', error);
    alert('공지사항 등록에 실패했습니다. 다시 시도해주세요.');
  }
};

// 게시글을 저장하는 함수
const saveArticle = async () => {
  if (props.articleId) {
    await updateArticle();
  } else {
    await postArticle();
  }
};

// 게시글 데이터를 불러오는 함수
async function fetchArticleData() {
  try {
    const response = await axios.get(
      `http://localhost:8080/api/articles/${props.articleId}`
    );
    title.value = response.data.title;
    description.value = response.data.content;
    // 이미지 데이터 처리 방식에 따라 추가 구현 필요
  } catch (error) {
    console.error('공지사항 불러오기 실패:', error);
  }
}

// 게시글을 업데이트하는 함수
const updateArticle = async () => {
  const formData = new FormData();
  formData.append('title', title.value);
  formData.append('content', description.value);
  try {
    await axios.patch(
      `http://localhost:8080/api/articles/${props.articleId}`,
      formData,
      {
        headers: {
          'Content-Type': 'multipart/form-data',
          Authorization: `Bearer ${sessionStorage.getItem('accessToken')}`,
        },
      }
    );
    alert('공지사항이 업데이트되었습니다.');
    router.push('/'); // 업데이트 후 이동할 경로
  } catch (error) {
    console.error('공지사항 업데이트 실패:', error);
    alert('공지사항 업데이트에 실패했습니다. 다시 시도해주세요.');
  }
};
onMounted(() => {
  if (route.params.articleId) {
    isEditMode.value = true;
    fetchArticleData();
  } else {
    isEditMode.value = false;
  }
});
</script>

<template>
  <div class="bg-white shadow p-4 py-8" x-data="{ images: [] }">
    <div
      class="heading text-center font-bold text-2xl m-5 text-gray-800 bg-white"
    >
      New Post
    </div>
    <div
      class="mt-5 editor mx-auto w-10/12 flex flex-col text-gray-800 border border-gray-300 p-4 shadow-lg max-w-2xl"
    >
      <input
        v-model="title"
        class="title bg-gray-100 border border-gray-300 p-2 mb-4 outline-none"
        spellcheck="false"
        placeholder="Title"
        type="text"
      />
      <textarea
        v-model="description"
        class="description bg-gray-100 sec p-3 h-60 border border-gray-300 outline-none"
        spellcheck="false"
        placeholder="Describe everything about this post here"
      ></textarea>

      <!-- icons -->
      <div class="icons flex text-gray-500 mt-5">
        <label id="select-image">
          <svg
            class="mr-2 cursor-pointer hover:text-gray-700 border rounded-full p-1 h-7"
            xmlns="http://www.w3.org/2000/svg"
            fill="none"
            viewBox="0 0 24 24"
            stroke="currentColor"
          >
            <path
              stroke-linecap="round"
              stroke-linejoin="round"
              stroke-width="2"
              d="M15.172 7l-6.586 6.586a2 2 0 102.828 2.828l6.414-6.586a4 4 0 00-5.656-5.656l-6.415 6.585a6 6 0 108.486 8.486L20.5 13"
            />
          </svg>
          <input
            hidden
            type="file"
            multiple
            @change="handleFileChange"
            x-ref="fileInput"
          />
        </label>
        <div class="count ml-auto text-gray-400 text-xs font-semibold">
          0/300
        </div>
      </div>

      <!-- Buttons -->
      <div class="buttons flex justify-end">
        <div
          @click="saveArticle"
          class="btn border border-indigo-500 p-1 px-4 font-semibold cursor-pointer text-gray-200 ml-2 bg-indigo-500"
        >
          {{ isEditMode.valueOf ? 'Update' : 'Post' }}
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped></style>
