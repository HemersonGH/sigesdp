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
        ListagemProjetosPesquisa(
          :projetosPesquisa='docente.projetosPesquisa'
          @openModalDetalhesProjetoPesquisa='openModalDetalhesProjetoPesquisa'
        )
      v-tab-item
        Disciplinas(
          :disciplinas='docente.disciplinas'
        )
    DetalhesProjetoPesquisa(
      :showModalDetalhesProjetoPesquisa='showModalDetalhesProjetoPesquisa'
      :projetoPesquisa='projetoPesquisa'
      :nomeDocente='docente.nome'
      :emailDocente='docente.usuario.email'
      :areaConhecimentoDocente='docente.areaConhecimento.nome'
      @closeModalDetalhesProjetoPesquisa='closeModalDetalhesProjetoPesquisa'
    )
</template>

<script>
import _ from 'lodash'
import { mapActions, mapGetters } from 'vuex'
import LinkVoltar from '@/components/shared/LinkVoltar.vue'
import PerfilPessoal from '@/components/academico/docente/PerfilPessoal.vue'
import ListagemProjetosPesquisa from '@/components/academico/docente/ListagemProjetosPesquisa.vue'
import DetalhesProjetoPesquisa from '@/components/academico/docente/DetalhesProjetoPesquisa.vue'
import Disciplinas from '@/components/academico/docente/Disciplinas.vue'

export default {
  name: 'DetalhesDocente',

  components: {
    LinkVoltar,
    PerfilPessoal,
    ListagemProjetosPesquisa,
    DetalhesProjetoPesquisa,
    Disciplinas
  },

  data () {
    return {
      projetoPesquisa: null,
      showModalDetalhesProjetoPesquisa: false,
      routeParent: '/academico/docentes'
    }
  },

  methods: {
    ...mapActions({
      getDocente: 'docente/getDocente'
    }),

    openModalDetalhesProjetoPesquisa (item) {
      this.projetoPesquisa = _.cloneDeep(item)
      this.showModalDetalhesProjetoPesquisa = true
    },

    closeModalDetalhesProjetoPesquisa () {
      this.showModalDetalhesProjetoPesquisa = false
    }
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
