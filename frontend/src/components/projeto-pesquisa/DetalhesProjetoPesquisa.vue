<template lang="pug">
  v-dialog(
    max-width='750px'
    v-model='showDialogDetalhesProjetoPesquisa'
    :persistent='true'
    :scrollable='true'
  )
    v-card
      v-card-title.card-title.white--text
        span.headline Detalhes do Projeto de Pesquisa
      v-divider.mx-3
      v-card-text.no-margin-top
        v-container.padding(
          grid-list-md
          fluid
        )
          v-layout(
            row
            wrap
          )
            v-flex.padding(
              xs6
              sm6
              md6
            )
              h5.font-weight-bold.no-margin-bottom
                | Código:
                span.style-sub-title {{ projetoPesquisaDetalhes.codigo }}
            v-flex.padding(
              xs6
              sm6
              md6
            )
              h5.font-weight-bold.no-margin-bottom
                | Período:
                span.style-sub-title {{ projetoPesquisaDetalhes.dataInicio.replace(/\-/g, '/') }} até {{ projetoPesquisaDetalhes.dataTermino.replace(/\-/g, '/') }}
            v-flex.padding(
              xs12
              sm12
              md12
            )
              h5.font-weight-bold.no-margin-bottom
                | Título:
                span.style-sub-title {{ projetoPesquisaDetalhes.titulo }}
            v-flex.padding(
              xs6
              sm6
              md6
            )
              h5.font-weight-bold.no-margin-bottom
                | Coordenador:
                span.style-sub-title {{ projetoPesquisaDetalhes.professor }}
            v-flex.padding(
              xs6
              sm6
              md6
            )
              h5.font-weight-bold.no-margin-bottom
                | Email:
                span.style-sub-title {{ projetoPesquisaDetalhes.professor }}
            v-flex.padding(
              xs12
              sm12
              md12
            )
              h5.font-weight-bold.no-margin-bottom
                | Área do Conhecimeto:
                span.style-sub-title {{ projetoPesquisaDetalhes.professor }}
            v-flex.padding(
              xs12
              sm12
              md12
            )
              h5.font-weight-bold.no-margin-bottom
                | Discente Responsável:
                span.style-sub-title {{ projetoPesquisaDetalhes.aluno.nome }}
              h5.font-weight-bold.no-margin-bottom
                | Resumo:
                span.style-sub-title {{ projetoPesquisaDetalhes.resumo }}
      v-divider.mx-3
      v-card-actions
        v-spacer
        v-btn.white--text.style-button(
          color='blue darken-1'
          @click='closeDetalhesProjetoPesquisa()'
        ) Fechar
</template>

<script>
export default {
  name: 'DetalhesProjetoPesquisa',

  props: {
    showDialogDetalhesProjetoPesquisa: {
      type: Boolean,
      required: true
    },

    projetoPesquisaDetalhes: {
      type: Object
    }
  },

  methods: {
    closeDetalhesProjetoPesquisa () {
      this.$emit('closeModalDetalhesProjetoPesquisa')
    }
  }
}
</script>

<style scoped>
.no-margin-bottom {
  padding-bottom: 0;
  margin-bottom: 0;
}

.no-margin-top {
  padding-top: 0;
}

.card-title {
  justify-content: center;
  background: #EF154B;
}

.style-button {
  font-weight: 450 !important;
}

.style-sub-title {
  padding-left: 10px;
  font-weight: 300;
  font-size: calc(1.0625rem - 0.0895rem);
}
</style>
