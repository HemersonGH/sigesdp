<template lang="pug">
  div.body
    TheHeader
    TheMenuLateral
    router-view
</template>

<script>
import TheHeader from './components/shared/TheHeader.vue'
import TheMenuLateral from './components/shared/TheMenuLateral.vue'

export default {
  name: 'App',

  components: {
    TheHeader,
    TheMenuLateral
  }
}
</script>

<style>
.body {
  height: 100vh;
}
</style>
