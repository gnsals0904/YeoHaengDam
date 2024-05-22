<script setup>
import { defineProps, onMounted, ref } from "vue";
import OpenAI from "openai";
/** 모달 창 관련 */
const props = defineProps({
  visible: {
    type: Boolean,
    required: true,
  },
  planData: {
    type: Object,
    required: true,
  },
  routeData: {
    type: Object,
  },
});
console.log("ai modal :", props.planData);
console.log("ai modal :", props.routeData);
const emit = defineEmits(["close"]);
const closeModal = () => {
  emit("close");
};

const guides = ref(null);
const prompt = ref(null);
// 경로 데이터를 파싱하여 guides 배열에 이름과 guidance를 함께 저장하는 함수
const findRoadInfo = () => {
  // props.routeData에서 guides 배열 추출
  const guidesData = props.routeData.guides;

  // guides 배열에 이름과 guidance를 함께 저장
  guides.value = guidesData.map((guide) => ({
    name: guide.name,
    guidance: guide.guidance,
  }));
};

// chatGPT description
const ApiKey = import.meta.env.VITE_VUE_APP_OPEN_API_KEY;
const getGPTResponse = async () => {
  try {
    const openai = new OpenAI({
      apiKey: ApiKey,
      dangerouslyAllowBrowser: true,
    });

    const prompt = "안녕? 미국의 수도가 어딘지 알고있니?";
    findRoadInfo();
    // guides 배열을 돌면서 문자열을 만든다.
    const response = await openai.chat.completions.create({
      messages: [
        {
          role: "user",
          content: prompt,
        },
      ],
      model: "gpt-4-turbo",
    });
    console.log("chatGPT 전체 응답", response);
    console.log("chatGPT 결과: ", response.choices[0].message.content);
  } catch (error) {
    console.log("chatGPT: 🚨 에러가 발생했습니다.");
  }
};
</script>

<template>
  <div
    v-if="visible"
    class="fixed z-50 left-0 top-0 flex h-full w-full items-center justify-center bg-black bg-opacity-50 py-10"
    @click="closeModal"
  >
    <div
      class="max-h-full w-full max-w-xl overflow-y-auto sm:rounded-2xl bg-white"
    >
      <div class="w-full">
        <div class="m-8 my-20 max-w-[400px] mx-auto">
          <div class="mb-8">
            <h1 class="mb-4 text-3xl font-extrabold">Turn on notifications</h1>
            <p class="text-gray-600">
              Get the most out of Twitter by staying up to date with what's
              happening.
            </p>
          </div>
          <div class="space-y-4">
            <button
              class="p-3 bg-black rounded-full text-white w-full font-semibold"
              @click="getGPTResponse"
            >
              GPT 테스트
            </button>
            <button
              class="p-3 bg-white border rounded-full w-full font-semibold"
            >
              Skip for now
            </button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped></style>
