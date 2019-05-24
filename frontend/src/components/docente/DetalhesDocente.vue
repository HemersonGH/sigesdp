<template lang="pug">
  div
    v-tabs(
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
        ListagemProjetosPesquisa
      v-tab-item
        Disciplinas
</template>

<script>
import LinkVoltar from '@/components/shared/LinkVoltar.vue'
import PerfilPessoal from '@/components/docente/PerfilPessoal.vue'
import ListagemProjetosPesquisa from '@/components/docente/ListagemProjetosPesquisa.vue'
import Disciplinas from '@/components/docente/Disciplinas.vue'

export default {
  name: 'DetalhesDocente',

  components: {
    LinkVoltar,
    PerfilPessoal,
    ListagemProjetosPesquisa,
    Disciplinas
  },

  data () {
    return {
      routeParent: '/academico/docentes'
    }
  }
}
</script>

<style scoped>
.inherit {
  color: inherit;
}
</style>
