<template lang="pug">
  v-btn.style-btn(
    v-on='on'
    slot='activator'
    :to='link'
    small
  )
    v-icon.no-margin(
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
