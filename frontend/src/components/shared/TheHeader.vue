<template lang="pug">
  div
    v-toolbar.style-toolbar(flat)
      v-toolbar-items
        img.logo(
          src='@/assets/images/logo.png'
        )
      v-spacer
      v-toolbar-title.style-title Sistema de Gestão do Docente/Professor
      v-spacer
      v-toolbar-items
        ButtonTheHeader(
          labelBtn='Login'
        )
</template>

<script>
import ButtonTheHeader from '@/components/shared/ButtonTheHeader.vue'

export default {
  name: 'TheHeader',

  components: {
    ButtonTheHeader
  }
}
</script>

<style scoped>
  .logo {
    margin-top: 1.0vh;
    height: 7.9vh;
    width: 20.0vh;
  }

  .style-toolbar {
    background-color: #17882c;
  }

  .style-title {
    font-size: 3.4vh;
    color: #ffffff;
    font-weight: bold;
  }
</style>
