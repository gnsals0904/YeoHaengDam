<script setup>
import { KakaoMap, KakaoMapMarker } from 'vue3-kakao-maps';
import { onMounted, ref, computed } from 'vue';
import { useRoute } from 'vue-router';
import LocationBox from '@/components/map/LocationBox.vue';
import LocationDetail from '@/components/map/LocationDetail.vue';
import MapNavigation from '@/components/map/MapNavigation.vue';
import axios from 'axios';
// import Draggable from 'vuedraggable';
import draggable from 'vuedraggable';

const route = useRoute();
const tripData = ref([]);
const selectedItem = ref(null);
const modalVisible = ref(false);
const loading = ref(true); // 로딩 상태 추가
const drawerOpen = ref(false);
const planData = ref([]);

onMounted(async () => {
  const { sidoCode, gugunCode, contentCode } = route.query;

  if (sidoCode && gugunCode && contentCode) {
    try {
      const response = await axios.get(
        'http://localhost:8080/api/spot/listSpot',
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
      console.log('Trip Data:', tripData.value);
    } catch (error) {
      console.error('Error fetching trip data:', error);
      alert('여행 정보를 가져오는 데 실패했습니다.');
    } finally {
      loading.value = false; // 데이터 로딩이 완료되면 로딩 상태를 false로 변경
    }
  } else {
    alert('필요한 매개변수가 URL에 포함되지 않았습니다.');
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

const showModal = (item) => {
  selectedItem.value = item;
  modalVisible.value = true;
};

const closeModal = () => {
  modalVisible.value = false;
  selectedItem.value = null;
};

const toggleDrawer = () => {
  drawerOpen.value = !drawerOpen.value;
};

const updatePlanData = (newData) => {
  planData.value = newData;
};
</script>

<template>
  <div :class="['map-container', { 'drawer-open': drawerOpen }]">
    <KakaoMap
      :lat="defaultCoordinate.lat"
      :lng="defaultCoordinate.lng"
      :draggable="true"
      class="flex-4 h-screen"
      style="width: 100%; height: 100%"
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
    <div class="locations-list flex-1 h-screen overflow-auto min-w-[500px]">
      <draggable v-model="tripData" group="locations" item-key="contentId">
        <template #item="{ element, index }">
          <LocationBox
            :item="element"
            :loading="loading"
            @click="showModal(element)"
          />
        </template>
      </draggable>
    </div>
    <MapNavigation
      @toggle="toggleDrawer"
      :planData="planData"
      @update:planData="updatePlanData"
      :loading="loading"
      :showModal="showModal"
    />
    <LocationDetail
      v-if="selectedItem"
      :item="selectedItem"
      :visible="modalVisible"
      @close="closeModal"
    />
  </div>
</template>

<style scoped>
.map-container {
  display: flex;
  height: 100vh;
  transition: margin-right 0.5s;
}

.drawer-open {
  margin-right: 550px; /* 드로어 너비에 맞게 조정 */
}

.locations-list {
  padding: 10px;
  border-left: 2px solid #ccc;
}
</style>
