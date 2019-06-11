<template lang="pug">
  div(
    v-if='this.$route.params.id'
  )
    LinkVoltar.margin(
      :link='routeParent'
    )
    v-tabs(
      fixed-tabs
      color='transparent'
      centered
    )
      v-tabs-slider(
        color='#2196f3'
      )
      v-tab
        v-icon.inherit(
          left
        ) mdi-account
        | Perfil Pessoal
      v-tab
        v-icon.inherit(
          left
        ) mdi-library-books
        | Projetos
      v-tab
        v-icon.inherit(
          left
        ) mdi-book-multiple-variant
        | Disciplinas
      v-tab-item
        PerfilPessoal(
          :docente='docente'
        )
      v-tab-item
        ListagemProjetosPesquisa
      v-tab-item
        Disciplinas(
          :disciplinas='docente.disciplinas'
        )
</template>

<script>
import { mapActions, mapGetters } from 'vuex'
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
  },

  methods: {
    ...mapActions({
      getDocente: 'docente/getDocente'
    })
  },

  computed: {
    ...mapGetters({
      docente: 'docente/docente'
    })
  },

  created () {
    this.getDocente(this.$route.params.id)
  }
}
</script>

<style scoped>
.inherit {
  color: inherit;
}

.margin {
  margin-left: 24px;
}
</style>
