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
            :contentTable='departamentos.data'
            :search='search'
            @openModal='openModal'
          )
      DetalhesDepartamento(
        :showDialog='showDialog'
        :data='departamento'
        @close='closeModal'
      )
</template>

<script>
import { mapActions, mapGetters } from 'vuex'
import LinkVoltar from '@/components/shared/LinkVoltar.vue'
import Card from '@/components/shared/Card.vue'
import ListagemDepartamentos from '@/components/departamento/ListagemDepartamentos.vue'
import FieldSearch from '@/components/shared/FieldSearch.vue'
import DetalhesDepartamento from '@/components/departamento/DetalhesDepartamento.vue'

export default {
  name: 'Departamento',

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
      showDialog: false,
      search: '',
      colorBottomFieldSearch: '#3169B3',
      routeParent: '/academico'
    }
  },

  methods: {
    ...mapActions({
      getDepartamentos: 'departamento/getDepartamentos'
    }),

    openModal (item) {
      this.departamento = item
      this.showDialog = true
    },

    closeModal () {
      this.showDialog = false
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
