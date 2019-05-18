<template lang="pug">
  router-link(
    :to='link'
  )
    span.style-span < Voltar
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
.style-span {
  font-size: 100%;
  color: #0000FF;
  width: 105px;
  text-decoration: underline;
}

.style-span:hover {
  color: #800080;
}
</style>
