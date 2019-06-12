<template lang="pug">
  v-dialog(
    max-width='850px'
    v-model='showDialogAtualizaProjetoPesquisa'
    :persistent='true'
    :scrollable='true'
  )
    v-card
      v-card-title.v-card-title.white--text
        span.headline Atualizar Projeto de Pesquisa
      v-divider.mx-3
      v-card-text.no-margin-top
        v-container.padding(
          grid-list-md
          fluid
        )
          v-layout(
            row
            wrap
          )
            v-flex.padding(
              xs6
              sm6
              md6
            )
              v-text-field(
                v-model='projetoPesquisaAtualiza.titulo'
                label='Título *'
                color='#E20000'
                v-validate="'required|max:100'"
                :error-messages="errors.collect('nome')"
                data-vv-name='nome'
                data-vv-as='Nome'
              )
            v-flex.padding(
              xs6
              sm6
              md6
            )
              v-text-field(
                v-model='projetoPesquisaAtualiza.codigo'
                label='Código *'
                color='#E20000'
                v-validate="'required|max:15'"
                :error-messages="errors.collect('codigo')"
                data-vv-name='codigo'
                data-vv-as='Código'
              )
            v-flex.padding(
              xs6
              sm6
              md6
            )
              v-menu(
                v-model='menuDataInicio'
                :close-on-content-click='false'
                :nudge-right='30'
                lazy
                transition='scale-transition'
                offset-y
                full-width
                min-width='290px'
              )
                template(
                  v-slot:activator='{ on }'
                )
                  v-text-field(
                    v-on='on'
                    v-model='projetoPesquisaAtualiza.dataInicio'
                    color='#E20000'
                    label='Data de Início'
                    prepend-icon='event'
                    v-validate="'required'"
                    :error-messages="errors.collect('dataInicio')"
                    data-vv-name='dataInicio'
                    data-vv-as='Data de Início'
                    mask='####-##-##'
                  )
                v-date-picker(
                  v-model='projetoPesquisaAtualiza.dataInicio'
                  @input='menuDataInicio = false'
                  color='#E20000'
                  scrollable
                  locale='pt-BR'
                )
            v-flex.padding(
              xs6
              sm6
              md6
            )
              v-menu(
                v-model='menuDataTermino'
                :close-on-content-click='false'
                :nudge-right='30'
                lazy
                transition='scale-transition'
                offset-y
                full-width
                min-width='290px'
              )
                template(
                  v-slot:activator='{ on }'
                )
                  v-text-field(
                    v-on='on'
                    v-model='projetoPesquisaAtualiza.dataTermino'
                    color='#E20000'
                    label='Data de Término'
                    prepend-icon='event'
                    v-validate="'required'"
                    :error-messages="errors.collect('dataTermino')"
                    data-vv-name='dataTermino'
                    data-vv-as='Data de Término'
                    mask='####-##-##'
                  )
                v-date-picker(
                  v-model='projetoPesquisaAtualiza.dataTermino'
                  @input='menuDataTermino = false'
                  color='#E20000'
                  scrollable
                  locale='pt-BR'
                )
            v-flex.padding(
              xs12
              sm12
              md12
            )
              v-select(
                v-model='projetoPesquisaAtualiza.aluno.id'
                label='Seleciona o discente *'
                color='#E20000'
                :items='alunos'
                item-value='id'
                item-text='nome'
                no-data-text='Não há dados.'
                v-validate="'required'"
                :error-messages="errors.collect('idAluno')"
                data-vv-name='idAluno'
                data-vv-as='Discente'
                clearable
              )
            v-flex.padding(
              xs12
              sm12
              md12
            )
              v-textarea(
                v-model='projetoPesquisaAtualiza.resumo'
                label='Resumo *'
                color='#E20000'
                auto-grow
                v-validate="'required|max:800'"
                :error-messages="errors.collect('resumo')"
                data-vv-name='resumo'
                data-vv-as='Resumo'
              )
      v-divider.mx-3
      v-card-actions
        v-btn.white--text.style-button(
          color='error darken-1'
          @click='fecharAtualizaProjetoPesquisa()'
        )
          v-icon(
            left
          ) mdi-close
          | Cancelar
        v-spacer
        v-btn.white--text.style-button(
          color='success darken-1'
          @click='atualizaProjetoPesquisa()'
        ) Salvar
          v-icon(
            right
          ) mdi-content-save
</template>

<script>
import { mapActions } from 'vuex'
import SnackBar from '@/components/shared/SnackBar.vue'

export default {
  name: 'AtualizaProjetoPesquisa',

  $_veeValidate: {
    validator: 'new'
  },

  components: {
    SnackBar
  },

  props: {
    showDialogAtualizaProjetoPesquisa: {
      type: Boolean,
      required: true
    },

    projetoPesquisaAtualiza: {
      type: Object
    },

    alunos: {
      type: Array,
      required: true
    },

    snackbarValidaCamposProjetoPesquisa: {
      type: Object,
      required: true
    },

    snackbarProjetoPesquisaAtualizadoSucesso: {
      type: Object,
      required: true
    },

    snackbarProjetoPesquisaAtualizadoErro: {
      type: Object,
      required: true
    }
  },

  data () {
    return {
      menuDataInicio: false,
      menuDataTermino: false
    }
  },

  methods: {
    ...mapActions({
      updateProjetoPesquisa: 'projetoPesquisa/updateProjetoPesquisa'
    }),

    fecharAtualizaProjetoPesquisa () {
      this.$emit('closeModalAtualizaProjetoPesquisa')
    },

    atualizaProjetoPesquisa () {
      this.$validator.validateAll().then(sucess => {
        if (sucess) {
          this.updateProjetoPesquisa(this.projetoPesquisaAtualiza).then((response) => {
            this.snackbarProjetoPesquisaAtualizadoSucesso.value = true
            this.$emit('atualizaListaProjetoPesquisa')
          }).catch((erro) => {
            this.snackbarProjetoPesquisaAtualizadoErro.value = true
          })
        } else {
          this.snackbarValidaCamposProjetoPesquisa.value = true
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

.v-card-title {
  justify-content: center;
  background: #E20000;
}

.style-button {
  font-size: 13.8px;
  font-weight: 450 !important;
}
</style>
