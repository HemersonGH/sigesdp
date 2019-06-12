<template lang="pug">
  v-dialog(
    v-if='disciplina'
    max-width='700px'
    v-model='showModalDetalhesDisciplina'
    :persistent='true'
    :scrollable='true'
  )
    v-card
      v-card-title.card-title.white--text
        span.headline Detalhes da Disciplina
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
              xs7
              sm7
              md7
            )
              h5.font-weight-bold.no-margin-bottom
                | Nome:
                span.style-sub-title {{ disciplina.nome }}
              h5.font-weight-bold.no-margin-bottom
                | Carga Horária:
                span.style-sub-title {{ disciplina.cargaHoraria }} horas
              h5.font-weight-bold.no-margin-bottom
                | Local:
                span.style-sub-title {{ disciplina.local }}
            v-flex.padding(
              xs5
              sm5
              md5
            )
              h5.font-weight-bold.no-margin-bottom
                | Código:
                span.style-sub-title {{ disciplina.codigo }}
              h5.font-weight-bold.no-margin-bottom
                | Horário:
                span.style-sub-title {{ disciplina.horario }} horas
      v-divider.mx-3
      v-card-actions
        v-spacer
        v-btn.white--text.style-button(
          color='blue darken-1'
          @click='closeModalDetalehesDisciplina()'
        ) Fechar
</template>

<script>
export default {
  name: 'DetalhesDisciplina',

  props: {
    disciplina: {
      type: Object
    },

    showModalDetalhesDisciplina: {
      type: Boolean,
      required: true
    }
  },

  data () {
    return {
    }
  },

  methods: {
    closeModalDetalehesDisciplina () {
      this.$emit('closeModalDetalehesDisciplina')
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

.style-button{
  font-weight: 450 !important;
}

.style-sub-title {
  padding-left: 10px;
  font-weight: 300;
  font-size: 90%;
}
</style>
