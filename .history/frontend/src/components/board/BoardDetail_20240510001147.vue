<template>
  <div v-if="isOpen" class="modal">
    <div class="modal-content">
      <h3>{{ board.subject }}</h3>
      <p>{{ board.content }}</p>
      <button @click="close">Close</button>
    </div>
  </div>
</template>

<script setup>
const props = defineProps({
  board: Object,
  isOpen: Boolean,
});

const emit = defineEmits(["close"]);

function close() {
  emit("close");
}
</script>

<style scoped>
.modal {
  position: fixed;
  left: 0;
  top: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.5);
  display: flex;
  justify-content: center;
  align-items: center;
}

.modal-content {
  background: white;
  padding: 20px;
  border-radius: 10px;
}
</style>
