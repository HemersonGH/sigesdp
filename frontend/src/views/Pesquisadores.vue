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
        PesquisaPesquisadores(
          :departamentos='departamentosSelect'
          :areasConhecimento='areasConhecimento'
        )
        Card(
          color='#BC2121'
          :title='title'
          styleTitleDataTable='title-data-table'
          full-width
          elevation='6'
        )
          ListagemPesquisadores(
            :headers='headers'
            :contentTable='projetosPesquisa'
            @openModalDetalhesPesquisador='openModalDetalhesPesquisador'
          )
    DetalhesPesquisador(
      :showModalDetalhesPesquisador='showModalDetalhesPesquisador'
      :pesquisador='pesquisador'
      @closeModalDetalhesPesquisador='closeModalDetalhesPesquisador'
    )
    SnackBar(
      :data='snackbarErroObterPesquisadores'
    )
</template>

<script>
import _ from 'lodash'
import { mapActions, mapGetters } from 'vuex'
import LinkVoltar from '@/components/shared/LinkVoltar.vue'
import Card from '@/components/shared/Card.vue'
import PesquisaPesquisadores from '@/components/pesquisa/pesquisadores/PesquisaPesquisadores.vue'
import ListagemPesquisadores from '@/components/pesquisa/pesquisadores/ListagemPesquisadores.vue'
import DetalhesPesquisador from '@/components/pesquisa/pesquisadores/DetalhesPesquisador.vue'
import SnackBar from '@/components/shared/SnackBar.vue'

export default {
  name: 'Docentes',

  components: {
    LinkVoltar,
    Card,
    PesquisaPesquisadores,
    ListagemPesquisadores,
    DetalhesPesquisador,
    SnackBar
  },

  data () {
    return {
      title: 'Listagem de Pesquisadores',
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
          text: 'Coordenador',
          value: 'professor.nome'
        },
        {
          sortable: false,
          text: 'Ações',
          value: 'actions',
          align: 'right'
        }
      ],
      pesquisador: null,
      showModalDetalhesPesquisador: false,
      routeParent: '/academico',
      snackbarErroObterPesquisadores: {
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
      getAreasConhecimento: 'areasConhecimento/getAreasConhecimento'
    }),

    openModalDetalhesPesquisador (item) {
      this.pesquisador = _.cloneDeep(item)
      this.showModalDetalhesPesquisador = true
    },

    closeModalDetalhesPesquisador () {
      this.showModalDetalhesPesquisador = false
    }
  },

  computed: {
    ...mapGetters({
      projetosPesquisa: 'projetoPesquisa/allProjetosPesquisa',
      departamentosSelect: 'departamento/departamentosSelect',
      areasConhecimento: 'areasConhecimento/areaConhecimento'
    })
  },

  created () {
    this.getAllProjetosPesquisa()
    this.getDepartamentosSelect()
    this.getAreasConhecimento()
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
