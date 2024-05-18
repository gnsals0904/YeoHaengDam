<script setup>
import WordAnimation from "@/components/Landing/WordAnimation.vue";
import VideoSection from "@/components/Landing/VideoSection.vue";
</script>

<template>
  <!-- Page Main -->
  <main class="flex flex-col items-center justify-center">
    <!-- Hero -->
    <section
      class="flex flex-wrap items-center px-4 w-full 2xl:max-w-screen-2xl xl:max-w-screen-xl lg:max-w-screen-lg sm:max-w-screen-sm md:max-w-screen-md min-h-screen"
    >
      <!-- Column-1 -->
      <div class="px-3 w-full lg:w-3/5">
        <VideoSection></VideoSection>
      </div>

      <!-- Column-2 -->
      <div class="px-3 mb-12 w-full lg:mb-0 lg:w-2/5">
        <WordAnimation></WordAnimation>
        <div class="mt-12 text-center flex justify-center">
          <a
            class="py-4 px-4 mr-10 text-xl font-semibold tracking-wide text-white bg-blue-500 rounded cursor-pointer"
            >여행담 사용해보기</a
          >

          <a
            class="py-4 px-4 text-xl font-semibold bg-black text-white rounded border border-solid cursor-pointer"
            >사용 방법</a
          >
        </div>
      </div>
    </section>

    <!-- Parallax Background -->
    <section
      class="bg-gray-400 bg-blend-multiply flex-col w-full h-[500px] bg-cover bg-fixed bg-center flex justify-center items-center bg-[url('/landingimg.jpg')]"
    >
      <h1 class="text-white text-5xl font-semibold mt-20 mb-10">
        This is Parallax Effect
      </h1>

      <span class="text-center font-bold my-20 text-white/90">
        <a
          href="https://egoistdeveloper.github.io/twcss-to-sass-playground/"
          target="_blank"
          class="text-white/90 hover:text-white"
        >
          Convetert to SASS
        </a>

        <hr class="my-4" />

        <a
          href="https://unsplash.com/photos/8Pm_A-OHJGg"
          target="_blank"
          class="text-white/90 hover:text-white"
        >
          Image Source
        </a>

        <hr class="my-4" />

        <p>
          <a
            href="https://github.com/EgoistDeveloper/my-tailwind-components/blob/main/src/templates/parallax-landing-page.html"
            target="_blank"
            class="text-white/90 hover:text-white"
          >
            Source Code
          </a>
          |
          <a
            href="https://egoistdeveloper.github.io/my-tailwind-components/./src/templates/parallax-landing-page.html"
            target="_blank"
            class="text-white/90 hover:text-white"
          >
            Full Preview
          </a>
        </p>
      </span>
    </section>

    <!-- Content -->
    <section class="p-20 space-y-8">
      <h1 class="text-4xl text-center my-20">Tempor sit labore nostrud</h1>

      <p>tt</p>

      <p>tt</p>

      <p>tt</p>
    </section>
  </main>
</template>

<style scoped></style>
