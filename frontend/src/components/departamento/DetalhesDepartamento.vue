<template lang="pug">
  v-dialog(
    max-width='600px'
    v-model='showDialog'
    :persistent='true'
    :scrollable='true'
  )
    v-card
      v-card-title.card-title.white--text
        span.headline Detalhes do Departamento
      v-divider.mx-3
      v-card-text.no-margin-top
        v-container(
          grid-list-md
          fluid
        )
          v-layout(
            wrap
            row
          )
            v-flex(
              xs12
              sm12
              md12
            )
              h5.font-weight-bold.no-margin-bottom Nome:
                span.style-sub-title {{ data.nome }}
            v-flex(
              xs12
              sm12
              md12
            )
              h5.font-weight-bold.no-margin-bottom Chefe:
                span.style-sub-title {{ data.chefe }}
            v-flex(
              xs12
              sm12
              md12
            )
              h5.font-weight-bold.no-margin-bottom Telefone:
                span.style-sub-title {{ data.telefone }}
            v-flex(
              xs12
              sm12
              md12
            )
              h5.font-weight-bold.no-margin-bottom Apresentação:
              span.style-sub-resumo {{ data.descricao }}
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
  name: 'DetalhesDepartamento',

  props: {
    data: {
      type: Object
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
  margin-bottom: 0;
}

.no-margin-top{
  padding-top: 0;
}

.card-title {
  justify-content: center;
  background: #3169B3;
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
