<template lang="pug">
  v-dialog(
    max-width='600px'
    v-model='showDialogDetalhesDisciplina'
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
                | Tipo:
                span.style-sub-title {{ disciplinaDetalhes.tipo == 0 ? 'Graduação' : 'Pós-Graduação' }}
              h5.font-weight-bold.no-margin-bottom
                | Nome:
                span.style-sub-title {{ disciplinaDetalhes.nome }}
              h5.font-weight-bold.no-margin-bottom
                | Código:
                span.style-sub-title {{ disciplinaDetalhes.codigo }}
            v-flex.padding(
              xs5
              sm5
              md5
            )
              h5.font-weight-bold.no-margin-bottom
                | Carga Horária:
                span.style-sub-title {{ disciplinaDetalhes.cargaHoraria }} horas
              h5.font-weight-bold.no-margin-bottom
                | Local:
                span.style-sub-title {{ disciplinaDetalhes.local }}
              h5.font-weight-bold.no-margin-bottom
                | Horário:
                span.style-sub-title {{ disciplinaDetalhes.horario }} horas
      v-divider.mx-3
      v-card-actions
        v-spacer
        v-btn.white--text.style-button(
          color='blue darken-1'
          @click='closeDetalhesDisciplina()'
        ) Fechar
</template>

<script>
export default {
  name: 'DetalhesDisciplina',

  props: {
    showDialogDetalhesDisciplina: {
      type: Boolean,
      required: true
    },

    disciplinaDetalhes: {
      type: Object
    }
  },

  methods: {
    closeDetalhesDisciplina () {
      this.$emit('closeModalDetalhesDisciplina')
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
  background: #11802C;
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
