<template lang="pug">
  v-data-table(
    v-if='contentTable'
    :headers='headers'
    :items='contentTable'
    :rows-per-page-items='setRowPerPagItens'
    rows-per-page-text='Linhas por página:'
    no-data-text='Não há dados para exibir.'
    no-results-text='Não há resultados para sua busca.'
    :search='search'
    :pagination.sync='pagination'
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
      td.text-xs-left {{ item.codigo }}
      td {{ item.titulo }}
      td {{ item.professor.nome }}
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
              @click.stop='viewDetailsPesquisador(item)'
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
export default {
  name: 'ListagemPesquisadores',

  props: {
    headers: {
      type: Array,
      required: true
    },

    contentTable: {
      type: Array
    },

    search: {
      type: String
    }
  },

  data () {
    return {
      pagination: {
        sortBy: 'titulo'
      },
      setRowPerPagItens: [
        5, 10, 20,
        {
          'text': 'Todos',
          'value': -1
        }
      ]
    }
  },

  methods: {
    viewDetailsPesquisador (pesquisador) {
      this.$emit('openModalDetalhesPesquisador', pesquisador)
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
