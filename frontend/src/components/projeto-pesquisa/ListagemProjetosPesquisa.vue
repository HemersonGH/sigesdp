<template lang="pug">
  v-data-table(
    :headers='headers'
    :items='contentTable'
    :rows-per-page-items='setRowPerPagItens'
    rows-per-page-text='Linhas por página:'
    no-data-text='Não há dados para exibir.'
    no-results-text='Não há resultados para sua busca.'
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
      td {{ item.aluno.nome }}
      td.text-xs-center
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
              @click.stop='viewDetailsProjetoPesquisa(item)'
            )
              v-icon.no-margin(
                color='#707070'
              ) mdi-eye
          span Visualizar
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
              @click.stop='atualizaProjetoPesquisa(item)'
            )
              v-icon.no-margin(
                color='#707070'
              ) mdi-pencil
          span Editar
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
              @click.stop='removeProjetoPesquisa(item)'
            )
              v-icon.no-margin(
                color='red'
              ) mdi-delete
          span Remover
    template(
      v-slot:pageText='props'
    ) Exibindo de {{ props.pageStart }} até {{ props.pageStop }} de {{ props.itemsLength }}
</template>

<script>
export default {
  name: 'ListagemProjetosPesquisa',

  props: {
    headers: {
      type: Array,
      required: true
    },

    contentTable: {
      type: Array
    }
  },

  data () {
    return {
      pagination: {
        sortBy: 'nome'
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
    viewDetailsProjetoPesquisa (projetoPesquisa) {
      this.$emit('openModalDetalhesProjetoPesquisa', projetoPesquisa)
    },

    atualizaProjetoPesquisa (projetoPesquisa) {
      this.$emit('openModalAtualizaProjetoPesquisa', projetoPesquisa)
    },

    removeProjetoPesquisa (projetoPesquisa) {
      this.$emit('openModalConfirmaRemocaoProjetoPesquisa', projetoPesquisa)
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
