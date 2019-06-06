<template lang="pug">
  v-dialog(
    max-width='600px'
    v-model='showDialog'
    :persistent='true'
    :scrollable='true'
  )
    v-card
      v-card-title.center
        span.headline Detalhes do Departamento
      v-divider.mx-3
      v-card-text.no-margin-top
        v-container(
          grid-list-md
        )
          v-layout(
            wrap
          )
            v-flex(
              xs12
              sm12
              md12
            )
              h5.font-weight-bold.no-margin-bottom Nome:
              p {{ data.nome }}
            v-flex(
              xs12
              sm12
              md12
            )
              h5.font-weight-bold.no-margin-bottom Chefe:
              p {{ data.chefe }}
            v-flex(
              xs12
              sm12
              md12
            )
              h5.font-weight-bold.no-margin-bottom Telefone:
              p {{ data.telefone }}
            v-flex(
              xs12
              sm12
              md12
            )
              h5.font-weight-bold.no-margin-bottom Apresentação:
              p {{ data.descricao }}
      v-divider.mx-3
      v-card-actions
        v-spacer
        v-btn.style-button(
          color='blue darken-1'
          @click='close()'
        ) Fechar
</template>

<script>
export default {
  name: 'DetalhesDepartamento',

  props: {
    data: {
      type: [Object, Array],
      required: true
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

.center {
  justify-content: center;
}

.style-button{
  font-weight: 450 !important;
  color: white;
}
</style>
