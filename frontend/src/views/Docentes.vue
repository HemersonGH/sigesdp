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
          :departamentos='departamentosSelect.data'
        )
        Card(
          color='#2CBF36'
          :title='title'
          :text='text'
          styleTitleDataTable='title-data-table'
          full-width
          elevation='6'
        )
          ListagemDocentes(
            :headers='headers'
            :contentTable='docentes.data'
            @openDetails='openDetails'
          )
</template>

<script>
import { mapActions, mapGetters } from 'vuex'
import LinkVoltar from '@/components/shared/LinkVoltar.vue'
import Card from '@/components/shared/Card.vue'
import PesquisaDocentes from '@/components/docente/PesquisaDocentes.vue'
import ListagemDocentes from '@/components/docente/ListagemDocentes.vue'

export default {
  name: 'Docentes',

  components: {
    LinkVoltar,
    Card,
    PesquisaDocentes,
    ListagemDocentes
  },

  data () {
    return {
      title: 'Docentes',
      text: 'Pesquise os docentes da UFLA',
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
      routeParent: '/academico'
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

    openDetails () {
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
