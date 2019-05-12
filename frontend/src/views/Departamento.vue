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
      v-flex(
        md12
      )
        Card(
          color='#3169B3'
          :title='title'
          :text='text'
          styleTitleDataTable='title-data-table'
          full-width
        )
          FieldSearch(
            :colorBottom='colorBottom'
            @valueSearch='valueSearch'
          )
          DataTable(
            :headers='headers'
            :columnsTable='columnsTable'
            :contentTable='departamentos.data'
            @openModal='openModal'
            :search='search'
          )
      Dialog(
        :showDialog='showDialog'
        :detailsDialog='detailsDialog'
        @close="closeModal"
      )
</template>

<script>
import { mapActions, mapGetters } from 'vuex'
import Card from '@/components/shared/Card.vue'
import DataTable from '@/components/shared/DataTable.vue'
import FieldSearch from '@/components/shared/FieldSearch.vue'
import Dialog from '@/components/shared/Dialog.vue'

export default {
  name: 'Departamento',

  components: {
    Card,
    DataTable,
    FieldSearch,
    Dialog
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
      columnsTable: {
        column: ['nome', 'sigla', 'chefe'],
        class: ['text-xs-left', '', '']
      },
      detailsDialog: {
        title: 'Detalhes do Departamento',
        labels:
          [
            ['Nome', 'nome'], ['Chefia', 'chefe'], ['Telefone', 'telefone'], ['Apresentação', 'descricao']
          ],
        itemDialog: null
      },
      showDialog: false,
      search: '',
      colorBottom: '#3169B3'
    }
  },

  methods: {
    ...mapActions({
      getDepartamentos: 'departamento/getDepartamentos'
    }),

    openModal (item) {
      this.detailsDialog.itemDialog = item
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
</style>
