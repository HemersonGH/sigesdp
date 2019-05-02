<template lang="pug">
  div.body
    TheHeader
    TheMenuLateral
    router-view
</template>

<script>
import TheHeader from '@/components/shared/TheHeader.vue'
import TheMenuLateral from '@/components/shared/TheMenuLateral.vue'
import TheCard from '@/components/shared/TheCard.vue'

export default {
  name: 'App',

  components: {
    TheHeader,
    TheMenuLateral,
    TheCard
  }
}
</script>

<style>
.body {
  height: 100vh;
}
</style>
