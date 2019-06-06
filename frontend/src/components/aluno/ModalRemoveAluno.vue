<template lang="pug">
  v-dialog(
    max-width='450px'
    v-model='showDialogConfirm'
    :persistent='true'
    :scrollable='true'
  )
    v-card
      v-card-title.center
        span.headline
          v-icon(
            color='red'
            size='30'
          ) mdi-alert-circle-outline
          | &nbsp Atenção
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
              h4.no-margin-bottom Tem certeza que deseja remover esse aluno?
      v-divider.mx-3
      v-card-actions
        v-btn.style-button(
          color='error darken-1'
          @click='cancela()'
        ) Não
        v-spacer
        v-btn.style-button(
          color='success darken-1'
          @click='confirmar()'
        ) Sim
</template>

<script>
export default {
  name: 'ModalRemoveAluno',

  props: {
    // data: {
    //   type: [Object, Array]
    // },

    aluno: {
      type: Object
    },

    showDialogConfirm: {
      type: Boolean,
      required: true
    }
  },

  methods: {
    cancela () {
      this.$emit('closeModalConfirmacaoRemocao')
    },

    confirmar () {
      this.$emit('removeAlunoFromDataBase', this.aluno)
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
  color: white;
  font-size: 90%;
}

.style-sub-title {
  padding-left: 10px;
  font-weight: 300;
  font-size: calc(1.0625rem - 0.0895rem);
}
</style>
