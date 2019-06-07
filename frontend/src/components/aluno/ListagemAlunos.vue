<template lang="pug">
  v-data-table(
    :headers='headers'
    :items='contentTable'
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
      td {{ item.modalidadeBolsa.sigla }}
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
              @click.stop='atualizaAluno(item)'
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
              @click.stop='removeAluno(item)'
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
  name: 'ListagemAlunos',

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
    viewDetails (aluno) {
      this.$emit('openModalDetalhesAluno', aluno)
    },

    atualizaAluno (aluno) {
      this.$emit('openModalAtualizaAluno', aluno)
    },

    removeAluno (aluno) {
      this.$emit('openModalConfirmaRemocao', aluno)
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
