<template lang="pug">
  v-dialog(
    max-width='600px'
    v-model='showDialog'
    :persistent='true'
    :scrollable='true'
  )
    v-card
      v-card-title.center
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
                span.style-sub-title {{ data.nome }}
              h5.font-weight-bold
                | Curso:
                span.style-sub-title {{ data.curso.nome }}
              h5.font-weight-bold
                | Email:
                span.style-sub-title {{ data.email }}
              h5.font-weight-bold.no-margin-bottom
                | Modalidade de Bolsa:
                span.style-sub-title {{ data.modalidadeBolsa.nome }} - {{ data.modalidadeBolsa.sigla }}
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
    data: {
      type: [Object, Array]
    },

    showDialog: {
      type: Boolean,
      required: true
    }
  },

  data () {
    return {
    }
  },

  methods: {
    close () {
      this.$emit('close')
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

.center {
  justify-content: center;
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
