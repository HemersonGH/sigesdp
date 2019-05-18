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
          color='#2CBF36'
          :title='title'
          :text='text'
          styleTitleDataTable='title-data-table'
          full-width
          elevation='6'
        )
          DataTable(
            :headers='headers'
            :columnsTable='columnsTable'
            :contentTable='docentes.data'
            @openModal='openModal'
          )
</template>

<script>
import { mapActions, mapGetters } from 'vuex'
import LinkVoltar from '@/components/shared/LinkVoltar.vue'
import Card from '@/components/shared/Card.vue'
import DataTable from '@/components/shared/DataTable.vue'
import Dialog from '@/components/shared/Dialog.vue'

export default {
  name: 'Docentes',

  components: {
    LinkVoltar,
    Card,
    DataTable,
    Dialog
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
      columnsTable: {
        column: ['nome', 'departamento.sigla'],
        class: ['text-xs-left', '']
      },
      routeParent: '/academico'
    }
  },

  methods: {
    ...mapActions({
      getDocentes: 'docente/getDocentes'
    }),

    valueSearch (query) {
      this.search = query
    }
  },

  computed: {
    ...mapGetters({
      docentes: 'docente/docentes'
    })
  },

  created () {
    this.getDocentes()
  }
}
</script>

<style scoped>
.no-padding-top {
  padding-top: 0px !important;
}
</style>
