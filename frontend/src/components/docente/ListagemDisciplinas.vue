<template lang="pug">
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
    v-data-table(
      :headers='headers'
      :items='data'
      :rows-per-page-items='setRowPerPagItens'
      rows-per-page-text='Linhas por página:'
      no-data-text='Não há dados para exibir.'
      no-results-text='Não há resultados para sua busca.'
      :search='search'
    )
      template(
        slot='headerCell'
        slot-scope='{ header }'
      )
        span.subheading.font-weight-bold.text--darken-3(
          v-text='header.text'
        )
      template(
        slot='items'
        slot-scope='{ item }'
      )
        td.text-xs-left {{ item.nome }}
        td.text-xs-left {{ item.codigo }}
        td.text-xs-right
          v-tooltip(
            top
            content-class='top'
          )
            template(
              v-slot:activator='{ on }'
            )
              v-btn.v-btn--simple.no-margin(
                v-on='on'
                slot='activator'
                icon
                @click.stop='viewDetails(item)'
              )
                v-icon.no-margin(
                  color='#707070'
                ) mdi-eye
            span Visualizar
      template(
        v-slot:pageText='props'
      ) Exibindo de {{ props.pageStart }} até {{ props.pageStop }} de {{ props.itemsLength }}
</template>

<script>
import Card from '@/components/shared/Card.vue'
import FieldSearch from '@/components/shared/FieldSearch.vue'

export default {
  name: 'ListagemDisciplinas',

  components: {
    Card,
    FieldSearch
  },

  props: {
    title: {
      type: String,
      required: true
    },

    text: {
      type: String,
      required: true
    },

    data: {
      type: [Object, Array],
      required: false
    }
  },

  data () {
    return {
      headers: [
        {
          sortable: true,
          text: 'Nome',
          value: 'nome',
          align: 'left'
        },
        {
          sortable: true,
          text: 'Código',
          value: 'codigo',
          align: 'left'
        },
        {
          sortable: false,
          text: 'Ações',
          value: 'actions',
          align: 'right'
        }
      ],
      setRowPerPagItens: [
        5, 10, 20,
        {
          'text': 'Todos',
          'value': -1
        }
      ],
      search: '',
      colorBottomFieldSearch: '#3169B3'
    }
  },

  methods: {
    viewDetails (item) {
      this.$emit('openModal', item)
    },

    valueSearch (query) {
      this.search = query
    }
  }
}
</script>

<style scoped>
.no-margin {
  margin-top: 0;
  margin-bottom: 0;
}
</style>
