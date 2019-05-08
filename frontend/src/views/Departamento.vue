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
          DataTable(
            :headers='headers'
            :columnsTable='columnsTable'
            :contentTable='departamentos.data'
          )
</template>

<script>
import Card from '@/components/shared/Card.vue'
import DataTable from '@/components/shared/DataTable.vue'
import { mapActions, mapGetters } from 'vuex'

export default {
  name: 'Departamento',

  components: {
    Card,
    DataTable
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
          text: 'Chefe do Departamento',
          value: 'chefe'
        },
        {
          sortable: false,
          text: 'Ações',
          value: 'actions',
          align: 'right'
        }
      ],
      columnsTable: [
        'nome',
        'sigla',
        'chefe'
      ]
    }
  },

  methods: {
    ...mapActions({
      getDepartamentos: 'departamento/getDepartamentos'
    })
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
