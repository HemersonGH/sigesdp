<template lang="pug">
  v-container(
    fill-height
    fluid
    grid-list-xl
  )
    v-layout(
      justify-center
      wrap
    )
      v-flex.no-padding-top(
        md12
      )
        LinkVoltar(
          :link='routeParent'
        )
        PesquisaIniciacaoCientifica(
          :departamentos='departamentosSelect'
          :modalidadesBolsa='modalidadesBolsa'
        )
        Card(
          color='#009194'
          :title='title'
          styleTitleDataTable='title-data-table'
          full-width
          elevation='6'
        )
          ListagemIniciacaoCientifica(
            :headers='headers'
            :contentTable='projetosPesquisa'
            @openModalDetalhesIniciacaoCientifica='openModalDetalhesIniciacaoCientifica'
          )
    DetalhesIniciacaoCientifica(
      :showModalDetalhesIniciacaoCientifica='showModalDetalhesIniciacaoCientifica'
      :iniciacaoCientifica='iniciacaoCientifica'
      @closeModalDetalhesIniciacaoCientifica='closeModalDetalhesIniciacaoCientifica'
    )
    SnackBar(
      :data='snackbarErroObterIniciacaoCientifica'
    )
</template>

<script>
import _ from 'lodash'
import { mapActions, mapGetters } from 'vuex'
import LinkVoltar from '@/components/shared/LinkVoltar.vue'
import Card from '@/components/shared/Card.vue'
import PesquisaIniciacaoCientifica from '@/components/pesquisa/iniciacao-cientifica/PesquisaIniciacaoCientifica.vue'
import ListagemIniciacaoCientifica from '@/components/pesquisa/iniciacao-cientifica/ListagemIniciacaoCientifica.vue'
import DetalhesIniciacaoCientifica from '@/components/pesquisa/iniciacao-cientifica/DetalhesIniciacaoCientifica.vue'
import SnackBar from '@/components/shared/SnackBar.vue'

export default {
  name: 'IniciacaoCientifica',

  components: {
    LinkVoltar,
    Card,
    PesquisaIniciacaoCientifica,
    ListagemIniciacaoCientifica,
    DetalhesIniciacaoCientifica,
    SnackBar
  },

  data () {
    return {
      title: 'Listagem de Bolsistas',
      headers: [
        {
          sortable: true,
          text: 'Código',
          value: 'codigo',
          align: 'left'
        },
        {
          sortable: true,
          text: 'Título',
          value: 'titulo'
        },
        {
          sortable: true,
          text: 'Bolsista',
          value: 'aluno.nome'
        },
        {
          sortable: false,
          text: 'Ações',
          value: 'actions',
          align: 'right'
        }
      ],
      iniciacaoCientifica: null,
      showModalDetalhesIniciacaoCientifica: false,
      routeParent: '/academico',
      snackbarErroObterIniciacaoCientifica: {
        icon: 'mdi-alert-circle-outline',
        message: 'Ocorreu um erro no sistema, tente novamente ou entre em contato com o administrador.',
        value: false,
        color: 'error'
      }
    }
  },

  methods: {
    ...mapActions({
      getAllProjetosPesquisa: 'projetoPesquisa/getAllProjetosPesquisa',
      getDepartamentosSelect: 'departamento/getDepartamentosSelect',
      getModalidadesBolsa: 'modalidadesBolsa/getModalidadesBolsa'
    }),

    openModalDetalhesIniciacaoCientifica (item) {
      this.iniciacaoCientifica = _.cloneDeep(item)
      this.showModalDetalhesIniciacaoCientifica = true
    },

    closeModalDetalhesIniciacaoCientifica () {
      this.showModalDetalhesIniciacaoCientifica = false
    }
  },

  computed: {
    ...mapGetters({
      projetosPesquisa: 'projetoPesquisa/allProjetosPesquisa',
      departamentosSelect: 'departamento/departamentosSelect',
      modalidadesBolsa: 'modalidadesBolsa/modalidadesBolsa'
    })
  },

  created () {
    this.getAllProjetosPesquisa()
    this.getDepartamentosSelect()
    this.getModalidadesBolsa()
  }
}
</script>

<style scoped>
.no-padding-top {
  padding-top: 0px !important;
}

.styleMouse{
  cursor: pointer;
}

.v-card--shared-stats.v-card .v-card__actions .caption {
    color: #000;
}
</style>
