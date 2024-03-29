<template lang="pug">
  v-dialog(
    max-width='600px'
    v-model='showDialogAtualizaAluno'
    :persistent='true'
    :scrollable='true'
  )
    v-card
      v-card-title.card-title.white--text
        span.headline Atualizar Aluno
      v-divider.mx-3
      v-card-text.no-margin-top
        v-container.padding(
          grid-list-md
          fluid
        )
          v-layout(
            wrap
          )
            v-flex.padding(
              xs12
              sm12
              md12
            )
              v-text-field(
                v-model='aluno.nome'
                label='Nome *'
                color='#3169B3'
                v-validate="'required|max:150'"
                :error-messages="errors.collect('nome')"
                data-vv-name='nome'
                data-vv-as='Nome'
              )
            v-flex.padding(
              xs12
              sm12
              md12
            )
              v-text-field(
                v-model='aluno.email'
                label='Email *'
                color='#3169B3'
                v-validate="'required|email|max:200'"
                :error-messages="errors.collect('email')"
                data-vv-name='email'
                data-vv-as='Email'
              )
            v-flex.padding(
              xs12
              sm12
              md12
            )
              v-select.font-weight-select(
                v-model='aluno.curso.id'
                label='Selecione um curso *'
                color='#3169B3'
                :items='curso'
                item-value='id'
                item-text='nome'
                no-data-text='Não há dados.'
                v-validate="'required'"
                :error-messages="errors.collect('curso')"
                data-vv-name='curso'
                data-vv-as='Curso'
                clearable
              )
            v-flex.padding(
              xs12
              sm12
              md12
            )
              v-select.font-weight-select(
                v-model='aluno.modalidadeBolsa.id'
                label='Selecione uma modalidade de bolsa *'
                color='#3169B3'
                :items='modalidadesBolsa'
                item-value='id'
                item-text='sigla'
                no-data-text='Não há dados.'
                v-validate="'required'"
                :error-messages="errors.collect('modalidadeBolsa')"
                data-vv-name='modalidadeBolsa'
                data-vv-as='Modalidade da Bolsa'
                clearable
              )
      v-divider.mx-3
      v-card-actions
        v-btn.white--text.style-button(
          color='error darken-1'
          @click='fechar()'
        )
          v-icon(
            left
          ) mdi-close
          | Cancelar
        v-spacer
        v-btn.white--text.style-button(
          color='success darken-1'
          @click='atualizaAluno()'
        ) Salvar
          v-icon(
            right
          ) mdi-content-save
</template>

<script>
import { mapActions } from 'vuex'

export default {
  name: 'AtualizaAluno',

  $_veeValidate: {
    validator: 'new'
  },

  props: {
    showDialogAtualizaAluno: {
      type: Boolean,
      required: true
    },

    aluno: {
      type: Object,
      required: true
    },

    curso: {
      type: [Object, Array],
      required: true
    },

    modalidadesBolsa: {
      type: [Object, Array],
      required: true
    },

    snackbarValidaAtualizaAluno: {
      type: Object,
      required: true
    },

    snackbarAlunoAtualizadoSucesso: {
      type: Object,
      required: true
    },

    snackbarAlunoAtualizadoErro: {
      type: Object,
      required: true
    }
  },

  methods: {
    ...mapActions({
      updateAluno: 'aluno/updateAluno'
    }),

    fechar () {
      this.$emit('closeModalAtualizaAluno')
    },

    atualizaAluno () {
      this.$validator.validateAll().then(sucess => {
        if (sucess) {
          this.updateAluno(this.aluno).then((response) => {
            this.snackbarAlunoAtualizadoSucesso.value = true
            this.$emit('getNovoAlunoCadastrado')
          }).catch((erro) => {
            this.snackbarAlunoAtualizadoErro.value = true
          })
        } else {
          this.snackbarValidaAtualizaAluno.value = true
        }
      })
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
  font-size: 13.8px;
  font-weight: 450 !important;
}
</style>
