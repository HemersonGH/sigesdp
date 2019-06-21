<template lang="pug">
v-dialog(
    max-width='750px'
    v-model='showModalDetalhesIniciacaoCientifica'
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
                span.style-sub-title {{ iniciacaoCientifica.codigo }}
            v-flex(
              xs6
              sm6
              md6
            )
              h5.font-weight-bold.no-margin-bottom
                | Período:
                span.style-sub-title
                  | {{ formatDate(iniciacaoCientifica.dataInicio) }}
                  | até
                  | {{ formatDate(iniciacaoCientifica.dataTermino) }}
            v-flex(
              xs12
              sm12
              md12
            )
              h5.font-weight-bold.no-margin-bottom
                | Título:
                span.style-sub-title {{ iniciacaoCientifica.titulo }}
            v-flex(
              xs6
              sm6
              md6
            )
              h5.font-weight-bold.no-margin-bottom
                | Orientador:
                span.style-sub-title {{ iniciacaoCientifica.professor.nome }}
            v-flex(
              xs8
              sm8
              md8
            )
              h5.font-weight-bold.no-margin-bottom
                | Discente Responsável:
                span.style-sub-title {{ iniciacaoCientifica.aluno.nome }}
            v-flex(
              xs4
              sm4
              md4
            )
              h5.font-weight-bold.no-margin-bottom
                | Modalidade:
                span.style-sub-title {{ iniciacaoCientifica.aluno.modalidadeBolsa.sigla }}
      v-divider.mx-3
      v-card-actions
        v-spacer
        v-btn.white--text.style-button(
          color='blue darken-1'
          @click='closeModalDetalhesIniciacaoCientifica()'
        ) Fechar
</template>

<script>
export default {
  name: 'DetalhesIniciacaoCientifica',

  props: {
    iniciacaoCientifica: {
      type: Object
    },

    showModalDetalhesIniciacaoCientifica: {
      type: Boolean,
      required: true
    }
  },

  data () {
    return {
    }
  },

  methods: {
    closeModalDetalhesIniciacaoCientifica () {
      this.$emit('closeModalDetalhesIniciacaoCientifica')
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
  background: #009194;
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
