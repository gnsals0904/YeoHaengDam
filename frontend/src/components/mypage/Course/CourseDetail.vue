<script setup>
import { KakaoMap, KakaoMapMarker, KakaoMapPolyline } from 'vue3-kakao-maps';
import { useRoute } from 'vue-router';
import { onMounted, ref, computed } from 'vue';
import LocationBox from '@/components/map/LocationBox.vue';
import draggable from 'vuedraggable';
import axios from 'axios';

const route = useRoute();
const planData = ref([]);
const loading = ref(true);
const routeData = ref(null); // 추가: 경로 데이터를 저장할 변수
const markerList = ref([]); // 마커 데이터를 저장할 변수
const kakaoApiKey = import.meta.env.VITE_VUE_APP_KAKAO_API_REST_KEY;

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

const fetchCourseDetails = async () => {
  const courseId = route.params.courseId;
  try {
    const response = await axios.get(
      `http://localhost:8080/api/course/${courseId}`
    );
    planData.value = response.data.schedules.map((schedule) => schedule.spot);
    console.log(planData.value);
    loading.value = false;
  } catch (error) {
    console.error('Error fetching course details:', error);
    loading.value = false;
  }
};

// Kakao Mobility API로 경로 데이터를 요청하는 함수
const fetchRoute = async () => {
  const origin = planData.value[0];
  const destination = planData.value[planData.value.length - 1];
  const waypoints = planData.value.slice(1, -1).map((spot, index) => ({
    name: `name${index}`,
    x: spot.longitude,
    y: spot.latitude,
  }));

  const requestData = {
    origin: {
      x: origin.longitude,
      y: origin.latitude,
    },
    destination: {
      x: destination.longitude,
      y: destination.latitude,
    },
    waypoints: waypoints,
    priority: 'RECOMMEND',
    car_fuel: 'GASOLINE',
    car_hipass: false,
    alternatives: false,
    road_details: false,
  };

  try {
    const response = await axios.post(
      'https://apis-navi.kakaomobility.com/v1/waypoints/directions',
      requestData,
      {
        headers: {
          Authorization: `KakaoAK ${kakaoApiKey}`,
          'Content-Type': 'application/json',
        },
      }
    );
    routeData.value = response.data;
    console.log('Route Data:', routeData.value);
    processRouteData();
  } catch (error) {
    console.error('Error fetching route data:', error);
  }
};

// 경로 데이터를 처리하여 마커 리스트를 생성하는 함수
const processRouteData = () => {
  const vertexes = routeData.value.routes[0].sections.flatMap((section) =>
    section.roads.flatMap((road) => road.vertexes)
  );
  for (let i = 0; i < vertexes.length; i += 2) {
    markerList.value.push({ lat: vertexes[i + 1], lng: vertexes[i] });
  }
  console.log(markerList.value);
};

const image = {
  imageSrc: 'https://vue3-kakao-maps.netlify.app/images/redMarker.png',
  imageWidth: 48,
  imageHeight: 48,
};

onMounted(async () => {
  await fetchCourseDetails();
  await fetchRoute();
});
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
      />
      <KakaoMapPolyline :latLngList="markerList" />
      <!-- <KakaoMapMarkerPolyline
        :markerList="markerList"
        :showMarkerOrder="false"
        strokeColor="#C74C5E"
        :strokeOpacity="1"
        strokeStyle="shortdot"
      /> -->
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
