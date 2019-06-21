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
      td.text-xs-left {{ item.tipo == 0 ? 'Graduação' : 'Pós-Graduação' }}
      td {{ item.nome }}
      td {{ item.codigo }}
      td.text-xs-center {{ item.departamento.sigla }}
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
              @click.stop='viewDetailsDisciplina(item)'
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
              @click.stop='atualizaDisciplina(item)'
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
              @click.stop='removeDisciplina(item)'
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
  name: 'ListagemDisciplinas',

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
    viewDetailsDisciplina (disciplina) {
      this.$emit('openModalDetalhesDisciplina', disciplina)
    },

    atualizaDisciplina (disciplina) {
      this.$emit('openModalAtualizaDisciplina', disciplina)
    },

    removeDisciplina (disciplina) {
      this.$emit('openModalConfirmaRemocaoDisciplina', disciplina)
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
