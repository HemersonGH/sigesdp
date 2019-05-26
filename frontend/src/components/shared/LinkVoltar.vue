<template lang="pug">
  v-btn.style-btn(
    :to='link'
    small
  )
    v-icon(
    ) mdi-arrow-left
    | &nbsp Voltar
</template>

<script>
export default {
  name: 'LinkVoltar',

  props: {
    link: {
      type: String,
      required: true
    }
  }
}
</script>

<style scoped>
.style-btn {
  text-transform: capitalize;
  font-size: 80%;
}
</style>
