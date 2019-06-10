<template lang="pug">
  v-dialog(
    max-width='600px'
    v-model='showDialogDetalhesAluno'
    :persistent='true'
    :scrollable='true'
  )
    v-card
      v-card-title.card-title.white--text
        span.headline Detalhes do Aluno
      v-divider.mx-3
      v-card-text.no-margin-top
        v-container.padding(
          grid-list-md
          fluid
        )
          v-layout(
            align-start
            justify-start
            row
            wrap
            fill-height
          )
            v-flex.padding(
              xs12
              sm12
              md12
            )
              h5.font-weight-bold
                | Nome:
                span.style-sub-title {{ alunoDetalhes.nome }}
              h5.font-weight-bold
                | Curso:
                span.style-sub-title {{ alunoDetalhes.curso.nome }}
              h5.font-weight-bold
                | Email:
                span.style-sub-title {{ alunoDetalhes.email }}
              h5.font-weight-bold.no-margin-bottom
                | Modalidade de Bolsa:
                span.style-sub-title {{ alunoDetalhes.modalidadeBolsa.nome }} - {{ alunoDetalhes.modalidadeBolsa.sigla }}
      v-divider.mx-3
      v-card-actions
        v-spacer
        v-btn.white--text.style-button(
          color='blue darken-1'
          @click='close()'
        ) Fechar
</template>

<script>
export default {
  name: 'DetalhesAluno',

  props: {
    showDialogDetalhesAluno: {
      type: Boolean,
      required: true
    },

    alunoDetalhes: {
      type: Object
    }
  },

  methods: {
    close () {
      this.$emit('closeModalDetalhesAluno')
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
  background: #3169B3;
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
