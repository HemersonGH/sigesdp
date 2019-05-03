<template lang="pug">
  div.body
    TheHeader
    TheSideMenu
      template(slot='router')
        router-view
</template>

<script>
import TheHeader from '@/components/shared/TheHeader.vue'
import TheSideMenu from '@/components/shared/TheSideMenu.vue'

export default {
  name: 'App',

  components: {
    TheHeader,
    TheSideMenu
  }
}
</script>

<style>
  body {
    height: 100%;
    width: 100%;
    font-family: Helvetica, sans-serif;
  }

  .body {
    height: 100vh;
  }

  html {
    height: 100%;
    width: 100%;
  }
</style>
