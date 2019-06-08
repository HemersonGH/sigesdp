<template lang="pug">
  v-dialog(
    max-width='700px'
    v-model='showDialogCadastraDisciplina'
    :persistent='true'
    :scrollable='true'
  )
    v-card
      v-card-title.center
        span.headline Adicionar Disciplina
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
                v-model='disciplina.tipo'
                label='Selecione o tipo da disciplina *'
                color='#11802C'
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
                v-model='disciplina.nome'
                label='Nome *'
                color='#11802C'
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
                v-model='disciplina.codigo'
                label='Código *'
                color='#11802C'
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
                v-model='disciplina.cargaHoraria'
                label='Seleciona a carga horária *'
                color='#11802C'
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
                v-model='disciplina.local'
                label='Local *'
                color='#11802C'
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
                v-model='disciplina.horario'
                label='Selecione um horário *'
                color='#11802C'
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
                v-model='disciplina.departamento.id'
                label='Selecione um departamento *'
                color='#11802C'
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
          @click='cancelaCadastroDisciplina()'
        )
          v-icon(
            left
          ) mdi-close
          | Cancelar
        v-spacer
        v-btn.white--text.style-button(
          color='success darken-1'
          @click='cadastrarDisciplina()'
        ) Salvar
          v-icon(
            right
          ) mdi-content-save
</template>

<script>
import { mapActions } from 'vuex'
import SnackBar from '@/components/shared/SnackBar.vue'

export default {
  name: 'CadastraDisciplina',

  $_veeValidate: {
    validator: 'new'
  },

  components: {
    SnackBar
  },

  props: {
    showDialogCadastraDisciplina: {
      type: Boolean,
      required: true
    },

    idProfessor: {
      type: Number,
      required: true
    },

    departamentos: {
      type: [Object, Array],
      required: true
    },

    snackbarCadastraDisciplina: {
      type: Object,
      required: true
    },

    snackbarDisciplinaCadastradaSucesso: {
      type: Object,
      required: true
    },

    snackbarDisciplinaCadastradaErro: {
      type: Object,
      required: true
    }
  },

  data () {
    return {
      disciplina: {
        nome: null,
        codigo: null,
        cargaHoraria: null,
        local: null,
        horario: null,
        tipo: null,
        professor: {
          id: null
        },
        departamento: {
          id: null
        }
      },
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
      ]
    }
  },

  methods: {
    ...mapActions({
      createDisciplina: 'disciplina/createDisciplina'
    }),

    reset () {
      this.disciplina.nome = null
      this.disciplina.codigo = null
      this.disciplina.cargaHoraria = null
      this.disciplina.local = null
      this.disciplina.horario = null
      this.disciplina.tipo = null
      this.disciplina.professor.id = null
      this.disciplina.departamento.id = null
      this.$validator.reset()
    },

    cancelaCadastroDisciplina () {
      this.$emit('closeModalCadastraDisciplina')
      this.reset()
    },

    cadastrarDisciplina () {
      this.disciplina.professor.id = this.idProfessor
      this.$validator.validateAll().then(sucess => {
        if (sucess) {
          this.createDisciplina(this.disciplina).then((response) => {
            this.showDialogCadastraDisciplina = false
            this.snackbarDisciplinaCadastradaSucesso.value = true
            this.$emit('getNovaDisciplinaCadastrada')
            this.reset()
          }).catch((erro) => {
            this.snackbarDisciplinaCadastradaErro.value = true
          })
        } else {
          this.snackbarCadastraDisciplina.value = true
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
