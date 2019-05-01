<template lang="pug">
    div.topo
      img.logo(
          src='@/assets/images/logo.png',
          alt='UFLA',
          name="logo"
      )
      h2.titlePage {{ title }}
      BotaoTheHeader(
          labelBtn='Entrar'
      )
</template>

<script>
import BotaoTheHeader from '@/components/shared/BotaoTheHeader.vue'

export default {
  name: 'TheHeader',

  components: {
    BotaoTheHeader
  },

  data () {
    return {
      title: 'Sistema de Gestão dos Docentes/Pesquisadores'
    }
  }
}
</script>

<style scoped>
.topo {
  height: 65px;
  display: flex;
  align-items: center;
  justify-content: space-between;
  padding: 0 1%;
  background-color: #17882c;
  font-family: Helvetica, sans-serif;
}

.logo {
  height: 80%;
  width: auto;
}

.titlePage {
  color: #ffffff;
}
</style>
