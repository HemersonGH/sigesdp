<template lang="pug">
  v-container(
    grid-list-xl
    fluid
    fill-height
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
          elevation='6'
        )
          FieldSearch(
            :colorBottomFieldSearch='colorBottomFieldSearch'
            @valueSearch='valueSearch'
          )
          v-data-table(
            :headers='headers'
            :items='contentTable'
            :rows-per-page-items='setRowPerPagItens'
            rows-per-page-text='Linhas por página:'
            no-data-text='Não há dados para exibir.'
            no-results-text='Não há resultados para sua busca.'
            :pagination.sync='pagination'
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
              td {{ item.sigla }}
              td {{ item.chefe }}
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
  name: 'ListagemProjetosPesquisa',

  components: {
    Card,
    FieldSearch
  },

  props: {
    contentTable: {
      type: [Object, Array]
    }
  },

  data () {
    return {
      title: 'Projetos de Pesquisas',
      text: 'Pesquise os projetos de pesquisas da UFLA',
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
          value: 'titulo',
          align: 'right'
        },
        {
          sortable: true,
          text: 'Área do Conhecimento',
          value: 'area',
          align: 'center'
        },
        {
          sortable: false,
          text: 'Ações',
          value: 'actions',
          align: 'right'
        }
      ],
      pagination: {
        sortBy: 'titulo'
      },
      setRowPerPagItens: [
        5, 10, 20,
        {
          'text': 'Todos',
          'value': -1
        }
      ],
      showDialog: false,
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
