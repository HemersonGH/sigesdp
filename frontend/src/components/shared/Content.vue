<template lang="pug">
  v-content
    div
      v-fade-transition(
        mode='out-in'
      )
        router-view
</template>

<script>
export default {
  name: 'Content'
}
</script>

<style>
#core-view {
  padding-bottom: 100px;
}
</style>
