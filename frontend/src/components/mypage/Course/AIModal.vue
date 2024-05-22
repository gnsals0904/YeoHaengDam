<script setup>
import { defineProps, onMounted, ref, watch } from "vue";
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

// watch를 사용하여 props.routeData가 변경될 때 findRoadInfo 호출
watch(
  () => props.routeData,
  (newVal, oldVal) => {
    if (newVal) {
      guides.value = findRoadInfo();
    }
  },
  { immediate: true }
);
const guides = ref(null);
const prompt = ref(null);
const gptResponse = ref(null); // GPT 응답 결과를 저장할 변수
const loading = ref(false); // 로딩 상태를 관리할 변수
const findRoadInfo = () => {
  if (
    !props.routeData ||
    !props.routeData.routes ||
    !props.routeData.routes[0] ||
    !props.routeData.routes[0].sections ||
    !props.routeData.routes[0].sections[0].guides
  ) {
    console.error("routeData 또는 guides가 정의되지 않았습니다.");
    loading.value = false; // 로딩 종료
    return;
  }

  // props.routeData에서 guides 배열 추출
  const guidesData = props.routeData.routes[0].sections[0].guides;

  // guides 배열에 이름과 guidance를 함께 저장하여 반환
  return guidesData.map((guide) => ({
    name: guide.name,
    guidance: guide.guidance,
  }));
};

// chatGPT description
const ApiKey = import.meta.env.VITE_VUE_APP_OPEN_API_KEY;
const getGPTResponse = async () => {
  try {
    loading.value = true;
    const openai = new OpenAI({
      apiKey: ApiKey,
      dangerouslyAllowBrowser: true,
    });
    const guidesData = findRoadInfo();
    // guidesData가 비어있는 경우 종료
    if (guidesData.length === 0) {
      console.error("guides 데이터가 비어 있습니다.");
      return;
    }
    let promptString = "";
    guidesData.forEach((guide) => {
      promptString += `${guide.name}, ${guide.guidance}; `;
    });
    // 문자열 끝에 질문 추가
    promptString += `내가 준 데이터를 기반으로
      자동차를 타고 길을 간다고 했을때
      친구에게 길을 알려주듯이 하나하나 차근차근 알려줘.
      예를 들면
      1: 어디어디에서 어디어디로 가
      2: 어디어디에서 좌회전을 해서 가
      이런식으로 단계적으로 알려줘
    `;

    // prompt 변수에 문자열 할당
    prompt.value = promptString;
    const response = await openai.chat.completions.create({
      messages: [
        {
          role: "user",
          content: prompt.value,
        },
      ],
      model: "gpt-4-turbo",
    });
    gptResponse.value = response.choices[0].message.content; // 응답 결과 저장
    console.log("chatGPT 전체 응답", response);
    console.log("chatGPT 결과: ", response.choices[0].message.content);
  } catch (error) {
    console.log("error : ", error);
    console.log("chatGPT: 🚨 에러가 발생했습니다.");
  } finally {
    loading.value = false; // 로딩 종료
  }
};
</script>

<template>
  <div
    v-if="visible"
    class="fixed z-50 left-0 top-0 flex h-full w-full items-center justify-center bg-black bg-opacity-50 py-10"
    @click.self="closeModal"
  >
    <div
      class="max-h-full w-full max-w-xl overflow-y-auto sm:rounded-2xl bg-white"
    >
      <div class="w-full">
        <div class="m-8 my-20 max-w-[400px] mx-auto">
          <div class="mb-8">
            <h1 class="mb-4 text-3xl font-extrabold">
              AI 를 활용해서 어떻게 이동하면 좋을지 확인해보세요 !
            </h1>
            <!-- 로딩 중일 때 표시할 부분 -->
            <div v-if="loading" class="bg-white">
              <div class="flex justify-center items-center">
                <img
                  class="h-16 w-16"
                  src="https://icons8.com/preloaders/preloaders/1488/Iphone-spinner-2.gif"
                  alt="로딩 중"
                />
              </div>
            </div>
            <!-- GPT 응답 결과를 출력할 부분 -->
            <div
              v-else-if="gptResponse"
              class="mt-4 p-4 bg-gray-100 rounded-lg"
            >
              <h2 class="text-xl font-bold mb-2">GPT 응답 결과</h2>
              <p class="text-gray-700 whitespace-pre-line">{{ gptResponse }}</p>
            </div>
          </div>
          <div class="space-y-4">
            <button
              class="p-3 bg-black rounded-full text-white w-full font-semibold"
              @click="getGPTResponse"
            >
              AI 를 활용한 길찾기
            </button>
            <button
              class="p-3 bg-white border rounded-full w-full font-semibold"
              @click="closeModal"
            >
              닫기
            </button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped></style>
