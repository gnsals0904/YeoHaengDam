<script setup>
import { KakaoMap, KakaoMapMarker } from "vue3-kakao-maps";
import { onMounted, ref, computed, reactive } from "vue";
import { useRoute } from "vue-router";
import axios from "axios";

const route = useRoute();
const tripData = ref([]);

onMounted(async () => {
  const { sidoCode, gugunCode, contentCode } = route.query;

  if (sidoCode && gugunCode && contentCode) {
    try {
      const response = await axios.get(
        "http://localhost/api/trip/listTripWithOutTitle",
        {
          params: {
            sidoCode: parseInt(sidoCode),
            gugunCode: parseInt(gugunCode),
            contentCode: parseInt(contentCode),
          },
        }
      );
      tripData.value = response.data.map((item) => ({
        ...item,
        infoVisible: false,
      }));
      console.log("Trip Data:", tripData.value);
    } catch (error) {
      console.error("Error fetching trip data:", error);
      alert("여행 정보를 가져오는 데 실패했습니다.");
    }
  } else {
    alert("필요한 매개변수가 URL에 포함되지 않았습니다.");
  }
});

// 기본 좌표를 서울 시청으로 설정하되, tripData에 값이 있으면 첫 번째 데이터의 좌표를 사용
const defaultCoordinate = computed(() => {
  if (tripData.value.length > 0) {
    return {
      lat: tripData.value[0].latitude,
      lng: tripData.value[0].longitude,
    };
  }
  return {
    lat: 37.566826,
    lng: 126.9786567,
  };
});

const toggleInfoWindow = (item) => {
  item.infoVisible = !item.infoVisible;
};
</script>

<template>
  <div>
    <KakaoMap
      :lat="defaultCoordinate.lat"
      :lng="defaultCoordinate.lng"
      :draggable="true"
    >
      <KakaoMapMarker
        v-for="(item, index) in tripData"
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
  </div>
</template>
<style scoped></style>
