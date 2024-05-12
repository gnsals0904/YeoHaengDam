<script setup>
import TripCard from "./TripCard.vue";
import { ref } from "vue";
import { useRouter } from "vue-router";
import { useDestinationStore } from "@/stores/mapstore.js";
import ListBoxCities from "./listbox/ListBoxCities.vue";
import ListBoxGuguns from "./listbox/ListBoxGuguns.vue";
import ListBoxContents from "./listbox/ListBoxContents.vue";

import axios from "axios";

const { destinations } = useDestinationStore();

const guguns = ref([]);
const router = useRouter();

const selectedSido = ref(null);
const selectedGugun = ref(null);
const selectedContent = ref(null);

const handleGugunSelected = (gugun) => {
  selectedGugun.value = gugun;
  console.log("Selected Gugun:", selectedGugun.value);
};

const handleContentSelected = (content) => {
  selectedContent.value = content;
  console.log("Selected Content:", selectedContent.value);
};

const handleSidoSelection = async (sido) => {
  const response = await axios.get(
    `http://localhost/api/trip/listgugun?sidoCode=${sido.id}&sidoName=${sido.name}`
  );
  guguns.value = response.data.map((item) => ({
    id: item.gugunCode,
    name: item.gugunName,
  }));
  console.log(guguns.value);
  selectedSido.value = sido;
  console.log("Selected Sido:", selectedSido.value);
};

const handleSearch = () => {
  console.log(
    "Sido:",
    selectedSido.value,
    "Gugun:",
    selectedGugun.value,
    "Content:",
    selectedContent.value
  );
  if (selectedSido.value && selectedGugun.value && selectedContent.value) {
    router.push({
      name: "Map",
      query: {
        sidoCode: selectedSido.value.id,
        gugunCode: selectedGugun.value.id,
        contentCode: selectedContent.value.id,
      },
    });
  } else {
    alert("모든 옵션을 선택해주세요.");
  }
};
</script>

<template>
  <div id="section-wrap">
    <section class="my-12">
      <h2 class="text-5xl font-bold text-center mb-6">
        어디로 여행을 떠나시나요?
      </h2>
      <p class="text-center text-lg mb-4">
        떠나고 싶은 곳과 어떤 여행을 떠나고 싶은지 골라주세요
      </p>
      <div class="flex justify-center items-center space-x-2 mb-12">
        <ListBoxCities @update:selected="handleSidoSelection" />
        <ListBoxGuguns
          :guguns="guguns"
          @update:selected="handleGugunSelected"
        />
        <ListBoxContents @update:selected="handleContentSelected" />
        <button
          @click="handleSearch"
          class="inline-flex items-center justify-center whitespace-nowrap rounded-md text-sm font-medium ring-offset-background focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-ring focus-visible:ring-offset-2 disabled:pointer-events-none disabled:opacity-50 border border-input bg-background hover:bg-blue-600 hover:text-white hover:border-transparent transition ease-in duration-200 h-10 px-4 py-2 pt-2"
        >
          검색
        </button>
      </div>
      <div class="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-4 gap-4">
        <TripCard
          v-for="destination in destinations"
          :key="destination.id"
          :name="destination.name"
          :image="destination.image"
        />
      </div>
    </section>
  </div>
</template>

<style scoped>
#section-wrap {
  margin-left: 5vw;
  margin-right: 5vw;
}
</style>
