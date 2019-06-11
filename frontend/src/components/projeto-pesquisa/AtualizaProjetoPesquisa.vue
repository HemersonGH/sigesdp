<template lang="pug">
  v-dialog(
    max-width='600px'
    :value='showDialogAtualizaProjetoPesquisa'
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
              v-select.font-weight-select(
                :value='projetoPesquisaAtualiza.tipo'
                label='Selecione o tipo da disciplina *'
                color='#F5DE31'
                :items='tipos'
                item-value='id'
                item-text='nome'
                no-data-text='Não há dados.'
                v-validate="'required'"
                :error-messages="errors.collect('tipo')"
                data-vv-name='tipo'
                data-vv-as='Tipo da disciplina'
                clearable
              )
            v-flex.padding(
              xs6
              sm6
              md6
            )
              v-text-field(
                :value='projetoPesquisaAtualiza.nome'
                label='Nome *'
                color='#F5DE31'
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
                :value='projetoPesquisaAtualiza.codigo'
                label='Código *'
                color='#F5DE31'
                v-validate="'required|max:6'"
                :error-messages="errors.collect('codigo')"
                data-vv-name='codigo'
                data-vv-as='Código'
                mask='AAA###'
              )
            v-flex.padding(
              xs6
              sm6
              md6
            )
              v-select(
                :value='projetoPesquisaAtualiza.cargaHoraria'
                label='Seleciona a carga horária *'
                color='#F5DE31'
                :items='cargasHoraria'
                no-data-text='Não há dados.'
                v-validate="'required'"
                :error-messages="errors.collect('cargaHoraria')"
                data-vv-name='cargaHoraria'
                data-vv-as='Carga Horária'
                suffix='horas'
                clearable
              )
            v-flex.padding(
              xs6
              sm6
              md6
            )
              v-text-field(
                :value='projetoPesquisaAtualiza.local'
                label='Local *'
                color='#F5DE31'
                v-validate="'required|max:100'"
                :error-messages="errors.collect('local')"
                data-vv-name='local'
                data-vv-as='Local'
              )
            v-flex.padding(
              xs6
              sm6
              md6
            )
              v-select.font-weight-select(
                :value='projetoPesquisaAtualiza.horario'
                label='Selecione um horário *'
                color='#F5DE31'
                :items='horarios'
                no-data-text='Não há dados.'
                v-validate="'required'"
                :error-messages="errors.collect('horario')"
                data-vv-name='horario'
                data-vv-as='Horário'
                clearable
              )
            v-flex.padding(
              xs12
              sm12
              md12
            )
              v-select.font-weight-select(
                :value='projetoPesquisaAtualiza.departamento.id'
                label='Selecione um departamento *'
                color='#F5DE31'
                :items='departamentos'
                item-value='id'
                item-text='nome'
                no-data-text='Não há dados.'
                v-validate="'required'"
                :error-messages="errors.collect('departamento')"
                data-vv-name='departamento'
                data-vv-as='Departamento'
                clearable
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
    SnackBar(
      :data='snackbarValidaAtualizaprojetoPesquisa'
    )
</template>

<script>
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

    departamentos: {
      type: [Object, Array]
    }
  },

  data () {
    return {
      tipos: [
        {
          id: 0,
          nome: 'Graduação'
        },
        {
          id: 1,
          nome: 'Pós-Graduação'
        }
      ],
      cargasHoraria: [
        '34', '68', '102'
      ],
      horarios: [
        '07:00', '08:00', '09:00', '10:00', '14:00', '13:00',
        '14:00', '15:00', '16:00', '17:00', '19:00', '21:00'
      ],
      snackbarValidaAtualizaprojetoPesquisa: {
        icon: 'mdi-alert-circle-outline',
        message: 'Verifique os campos obrigatórios.',
        value: false,
        color: 'error'
      }
    }
  },

  methods: {
    fecharAtualizaProjetoPesquisa () {
      this.$emit('closeModalAtualizaProjetoPesquisa')
    },

    atualizaProjetoPesquisa () {
      this.$validator.validateAll().then(sucess => {
        if (sucess) {
          this.$emit('atualizaProjetoPesquisa', this.projetoPesquisaAtualiza)
        } else {
          this.snackbarValidaAtualizaprojetoPesquisa.value = true
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
