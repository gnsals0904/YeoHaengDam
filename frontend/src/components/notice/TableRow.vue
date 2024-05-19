<script setup>
import { defineProps, defineEmits } from "vue";

const props = defineProps({
  item: {
    type: Object,
    required: true,
  },
});

const emit = defineEmits(["row-click"]);

const handleClick = () => {
  emit("row-click", props.item);
};
</script>

<template>
  <tr class="hover:bg-gray-100 border-b border-gray-200" @click="handleClick">
    <td class="px-4 py-4 flex items-center">{{ item.title }}</td>
    <td class="px-4 py-4">{{ item.author }}</td>
    <td class="px-4 py-4">{{ item.views }}</td>
  </tr>
</template>

<style scoped></style>
