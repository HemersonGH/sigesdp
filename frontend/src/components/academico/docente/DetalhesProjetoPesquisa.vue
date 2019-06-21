<template lang="pug">
v-dialog(
    max-width='750px'
    v-model='showModalDetalhesProjetoPesquisa'
    :persistent='true'
    :scrollable='true'
  )
    v-card
      v-card-title.card-title.white--text
        span.headline Detalhes do Projeto de Pesquisa
      v-divider.mx-3
      v-card-text.no-margin-top
        v-container(
          grid-list-md
          fluid
        )
          v-layout(
            row
            wrap
          )
            v-flex(
              xs6
              sm6
              md6
            )
              h5.font-weight-bold.no-margin-bottom
                | Código:
                span.style-sub-title {{ projetoPesquisa.codigo }}
            v-flex(
              xs6
              sm6
              md6
            )
              h5.font-weight-bold.no-margin-bottom
                | Período:
                span.style-sub-title
                  | {{ formatDate(projetoPesquisa.dataInicio) }}
                  | até
                  | {{ formatDate(projetoPesquisa.dataTermino) }}
            v-flex(
              xs12
              sm12
              md12
            )
              h5.font-weight-bold.no-margin-bottom
                | Título:
                span.style-sub-title {{ projetoPesquisa.titulo }}
            v-flex(
              xs6
              sm6
              md6
            )
              h5.font-weight-bold.no-margin-bottom
                | Coordenador:
                span.style-sub-title {{ nomeDocente }}
            v-flex(
              xs6v
              sm6
              md6
            )
              h5.font-weight-bold.no-margin-bottom
                | Email:
                span.style-sub-title {{ emailDocente }}
            v-flex(
              xs12
              sm12
              md12
            )
              h5.font-weight-bold.no-margin-bottom
                | Área do Conhecimento:
                span.style-sub-title {{ areaConhecimentoDocente }}
            v-flex(
              xs8
              sm8
              md8
            )
              h5.font-weight-bold.no-margin-bottom
                | Discente Responsável:
                span.style-sub-title {{ projetoPesquisa.aluno.nome }}
            v-flex(
              xs4
              sm4
              md4
            )
              h5.font-weight-bold.no-margin-bottom
                | Modalidade:
                span.style-sub-title {{ projetoPesquisa.aluno.modalidadeBolsa.sigla }}
            v-flex(
              xs12
              sm12
              md12
            )
              h5.font-weight-bold.no-margin-bottom
                | Resumo:
                span.style-sub-title {{ projetoPesquisa.resumo }}
      v-divider.mx-3
      v-card-actions
        v-spacer
        v-btn.white--text.style-button(
          color='blue darken-1'
          @click='closeModalDetalhesProjetoPesquisa()'
        ) Fechar
</template>

<script>
export default {
  name: 'DetalhesProjetoPesquisa',

  props: {
    nomeDocente: {
      type: String
    },

    emailDocente: {
      type: String
    },

    areaConhecimentoDocente: {
      type: String
    },

    projetoPesquisa: {
      type: Object
    },

    showModalDetalhesProjetoPesquisa: {
      type: Boolean,
      required: true
    }
  },

  methods: {
    closeModalDetalhesProjetoPesquisa () {
      this.$emit('closeModalDetalhesProjetoPesquisa')
    },

    formatDate (date) {
      if (!date) {
        return null
      } else {
        const [year, month, day] = date.split('-')
        return `${day}/${month}/${year}`
      }
    }
  }
}
</script>

<style scoped>
.no-margin-bottom {
  margin-bottom: 0;
}

.no-margin-top{
  padding-top: 0;
}

.card-title {
  justify-content: center;
  background: #2196f3;
}

.style-sub-title {
  padding-left: 10px;
  font-weight: 300;
  font-size: 95%;
}

.style-sub-resumo {
  font-weight: 300;
  font-size: 95%;
}

.style-button{
  font-weight: 450 !important;
}
</style>
