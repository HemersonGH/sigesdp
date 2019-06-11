<template lang="pug">
  v-dialog(
    max-width='450px'
    v-model='showDialogCofirmaRemocaoAluno'
    :persistent='true'
    :scrollable='true'
  )
    v-card
      v-card-title.card-title
        span.headline
          v-icon(
            color='red'
            size='30'
            left
          ) mdi-alert-circle-outline
          | Atenção
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
        v-btn.white--text.style-button(
          color='error darken-1'
          small
          @click.stop='cancelaRemocaoAluno()'
        ) Não
        v-spacer
        v-btn.white--text.style-button(
          color='success darken-1'
          small
          @click='confirmarRemocaoAluno()'
        ) Sim
</template>

<script>
export default {
  name: 'ModalRemoveAluno',

  props: {
    alunoRemove: {
      type: Object
    },

    showDialogCofirmaRemocaoAluno: {
      type: Boolean,
      required: true
    }
  },

  methods: {
    cancelaRemocaoAluno () {
      this.$emit('closeModalConfirmacaoRemocaoAluno')
    },

    confirmarRemocaoAluno () {
      this.$emit('removeAlunoFromDataBase', this.alunoRemove)
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
}

.style-button {
  font-weight: 450 !important;
  font-size: 90%;
}

.style-sub-title {
  padding-left: 10px;
  font-weight: 300;
  font-size: calc(1.0625rem - 0.0895rem);
}
</style>
