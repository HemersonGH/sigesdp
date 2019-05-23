<template lang="pug">
  div
    v-tabs(
      v-model='active'
      fixed-tabs
      color='transparent'
      centered
    )
      v-tabs-slider(
        color='#2196f3'
      )
      v-tab
        v-icon.inherit mdi-account
        | &nbsp Perfil Pessoal
      v-tab
        v-icon.inherit mdi-library-books
        | &nbsp Projetos
      v-tab
        v-icon.inherit mdi-book-multiple-variant
        | &nbsp Disciplinas
      v-tab-item
        PerfilPessoal
      v-tab-item
        v-container(
          grid-list-xl
          fluid
          fill-height
        )
          v-layout(
            justify-center
            wrap
          )
            v-flex(
              md12
            )
      v-tab-item
</template>

<script>
import PerfilPessoal from '@/components/docente/PerfilPessoal.vue'

export default {
  name: 'DetalhesDocente',

  components: {
    PerfilPessoal
  },

  data () {
    return {
    }
  }
}
</script>

<style scoped>
.padding{
  padding-left: 5%;
}

.inherit {
  color: inherit;
}
</style>
