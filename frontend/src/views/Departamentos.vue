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
        Card(
          color='#3169B3'
          :title='title'
          :text='text'
          styleTitleDataTable='title-data-table'
          full-width
          elevation='6'
        )
          FieldSearch(
            :colorBottomFieldSearch='colorBottomFieldSearch'
            @valueSearch='valueSearch'
          )
          ListagemDepartamentos(
            :headers='headers'
            :contentTable='departamentos'
            :search='search'
            @openModalDetalhesDepartamento='openModalDetalhesDepartamento'
          )
      DetalhesDepartamento(
        :showModalDetalhesDepartamento='showModalDetalhesDepartamento'
        :data='departamento'
        @closeModalDetalhesDepartamento='closeModalDetalhesDepartamento'
      )
</template>

<script>
import _ from 'lodash'
import { mapActions, mapGetters } from 'vuex'
import LinkVoltar from '@/components/shared/LinkVoltar.vue'
import Card from '@/components/shared/Card.vue'
import ListagemDepartamentos from '@/components/departamento/ListagemDepartamentos.vue'
import FieldSearch from '@/components/shared/FieldSearch.vue'
import DetalhesDepartamento from '@/components/departamento/DetalhesDepartamento.vue'

export default {
  name: 'Departamentos',

  components: {
    LinkVoltar,
    Card,
    ListagemDepartamentos,
    FieldSearch,
    DetalhesDepartamento
  },

  data () {
    return {
      title: 'Departamentos',
      text: 'Pesquise os departamentos da UFLA',
      headers: [
        {
          sortable: true,
          text: 'Nome',
          value: 'nome',
          align: 'left'
        },
        {
          sortable: true,
          text: 'Sigla',
          value: 'sigla'
        },
        {
          sortable: true,
          text: 'Chefe',
          value: 'chefe'
        },
        {
          sortable: false,
          text: 'Ações',
          value: 'actions',
          align: 'right'
        }
      ],
      departamento: null,
      showModalDetalhesDepartamento: false,
      search: '',
      colorBottomFieldSearch: '#3169B3',
      routeParent: '/academico'
    }
  },

  methods: {
    ...mapActions({
      getDepartamentos: 'departamento/getDepartamentos'
    }),

    openModalDetalhesDepartamento (item) {
      this.departamento = _.cloneDeep(item)
      this.showModalDetalhesDepartamento = true
    },

    closeModalDetalhesDepartamento () {
      this.showModalDetalhesDepartamento = false
    },

    valueSearch (query) {
      this.search = query
    }
  },

  computed: {
    ...mapGetters({
      departamentos: 'departamento/departamentos'
    })
  },

  created () {
    this.getDepartamentos()
  }
}
</script>

<style scoped>
.no-padding-top {
  padding-top: 0px !important;
}
</style>
