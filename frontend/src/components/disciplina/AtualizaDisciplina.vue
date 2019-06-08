<template lang="pug">
  v-dialog(
    max-width='600px'
    v-model='showDialogAtualizaDisciplina'
    :persistent='true'
    :scrollable='true'
  )
    v-card
      v-card-title.center
        span.headline Atualizar Disciplina
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
                v-model='disciplinaAtualiza.nome'
                label='Nome * '
                color='#2196f3'
                v-validate="'required'"
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
                v-model='disciplinaAtualiza.email'
                label='Email * '
                color='#2196f3'
                v-validate="'required|email'"
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
                v-model='disciplinaAtualiza.curso.id'
                label='Selecione um curso *'
                color='#2196f3'
                :items='curso'
                item-text='nome'
                item-value='id'
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
                v-model='disciplinaAtualiza.departamento.id'
                label='Selecione um modalidade de bolsa *'
                color='#2196f3'
                :items='departamentos'
                item-text='sigla'
                item-value='id'
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
          @click='fecharAtualizaDisciplina()'
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
    SnackBar(
      :data='snackbarValidaAtualizaDisciplina'
    )
</template>

<script>
import SnackBar from '@/components/shared/SnackBar.vue'

export default {
  name: 'AtualizaDisciplina',

  $_veeValidate: {
    validator: 'new'
  },

  components: {
    SnackBar
  },

  props: {
    showDialogAtualizaDisciplina: {
      type: Boolean,
      required: true
    },

    disciplinaAtualiza: {
      type: Object
    },

    departamentos: {
      type: [Object, Array]
    }
  },

  data () {
    return {
      snackbarValidaAtualizaDisciplina: {
        icon: 'mdi-alert-circle-outline',
        message: 'Verifique os campos obrigatórios.',
        value: false,
        color: 'error'
      }
    }
  },

  methods: {
    fecharAtualizaDisciplina () {
      this.$emit('closeModalAtualizaDisciplina')
    },

    atualizaAluno () {
      this.$validator.validateAll().then(sucess => {
        if (sucess) {
          this.$emit('atualizaAluno', this.disciplinaAtualiza)
        } else {
          this.snackbarValidaAtualizaDisciplina.value = true
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

.center {
  justify-content: center;
}

.style-button {
  font-size: 13.8px;
  font-weight: 450 !important;
}
</style>
