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
        PesquisaDocentes(
          :departamentos='departamentosSelect'
        )
        Card(
          color='#11802C'
          :title='title'
          styleTitleDataTable='title-data-table'
          full-width
          elevation='6'
        )
          ListagemDocentes(
            :headers='headers'
            :contentTable='docentes'
            @openDetalhesDocente='openDetalhesDocente'
          )
    SnackBar(
      :data='snackbarErroObterDadosDocente'
    )
</template>

<script>
import { mapActions, mapGetters } from 'vuex'
import LinkVoltar from '@/components/shared/LinkVoltar.vue'
import Card from '@/components/shared/Card.vue'
import PesquisaDocentes from '@/components/docente/PesquisaDocentes.vue'
import ListagemDocentes from '@/components/docente/ListagemDocentes.vue'
import SnackBar from '@/components/shared/SnackBar.vue'

export default {
  name: 'Docentes',

  components: {
    LinkVoltar,
    Card,
    PesquisaDocentes,
    ListagemDocentes,
    SnackBar
  },

  data () {
    return {
      title: 'Docentes',
      headers: [
        {
          sortable: true,
          text: 'Nome',
          value: 'nome',
          align: 'left'
        },
        {
          sortable: true,
          text: 'Departamento',
          value: 'departamento.sigla'
        },
        {
          sortable: false,
          text: 'Ações',
          value: 'actions',
          align: 'right'
        }
      ],
      routeParent: '/academico',
      snackbarErroObterDadosDocente: {
        icon: 'mdi-alert-circle-outline',
        message: 'Ocorreu um erro no sistema, tente novamente ou entre em contato com o administrador.',
        value: false,
        color: 'error'
      }
    }
  },

  methods: {
    ...mapActions({
      getDocentes: 'docente/getDocentes',
      getDepartamentosSelect: 'departamento/getDepartamentosSelect'
    }),

    valueSearch (query) {
      this.search = query
    },

    openDetalhesDocente (idDocente) {
      this.$router.push({
        name: 'detalhesDocentes',
        params: {
          id: idDocente
        }
      })
    }
  },

  computed: {
    ...mapGetters({
      docentes: 'docente/docentes',
      departamentosSelect: 'departamento/departamentosSelect'
    })
  },

  created () {
    this.getDocentes()
    this.getDepartamentosSelect()
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
