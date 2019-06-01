<template lang="pug">
  v-snackbar(
    v-model='data.value'
    :color='data.color'
    :top='true'
    :right='true'
  )
    v-icon(
      color='white'
      class='mr-3'
    ) {{ data.icon }}
    div
      | {{ data.message }}
    v-icon(
      size="16"
      @click='data.value = false'
    ) mdi-close-circle
</template>

<script>
export default {
  name: 'SnackBar',

  props: {
    data: {
      type: Object,
      required: true
    }
  }
}
</script>

<style lang="scss" scoped>
</style>
