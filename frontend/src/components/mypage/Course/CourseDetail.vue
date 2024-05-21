<script setup>
import { KakaoMap, KakaoMapMarker } from "vue3-kakao-maps";
import { onMounted, ref, computed } from "vue";
import LocationBox from "@/components/map/LocationBox.vue";
import draggable from "vuedraggable";

const planData = ref([]);

// 기본 좌표를 서울 시청으로 설정하되, planData에 값이 있으면 첫 번째 데이터의 좌표를 사용
const defaultCoordinate = computed(() => {
  if (planData.value.length > 0) {
    return {
      lat: planData.value[0].latitude,
      lng: planData.value[0].longitude,
    };
  }
  return {
    lat: 37.566826,
    lng: 126.9786567,
  };
});

onMounted(async () => {});
</script>

<template>
  <div :class="['map-container']">
    <KakaoMap
      :lat="defaultCoordinate.lat"
      :lng="defaultCoordinate.lng"
      :draggable="true"
      class="flex-4 h-screen"
      style="width: 100%; height: 100%"
    >
      <KakaoMapMarker
        v-for="(item, index) in planData"
        :key="index"
        :lat="item.latitude"
        :lng="item.longitude"
        :clickable="true"
        @onClickKakaoMapMarker="toggleInfoWindow(item)"
        :infoWindow="{
          content: `<div style='width: 200px;'><h4>${
            item.title
          }</h4><img src='${item.img1}' alt='${
            item.title
          }' style='width: 100%;'><button onClickKakaoMapMarker='toggleInfoWindow(${JSON.stringify(
            item
          )})'>Close</button></div>`,
          visible: item.infoVisible,
        }"
      />
    </KakaoMap>
    <div class="locations-list flex-1 h-screen overflow-auto min-w-[500px]">
      <draggable v-model="planData" group="locations" item-key="contentId">
        <template #item="{ element, index }">
          <LocationBox
            :item="element"
            :loading="loading"
            @click="showModal(element)"
          />
        </template>
      </draggable>
    </div>
  </div>
</template>

<style scoped>
.map-container {
  display: flex;
  height: 100vh;
}
.locations-list {
  padding: 10px;
  border-left: 2px solid #ccc;
}
</style>
