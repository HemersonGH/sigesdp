<template lang="pug">
  div.test
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

<style scoped>
  .error {
    border: solid 1px firebrick;
    border-radius: 5px;
  }
</style>
