<template lang="pug">
  v-card.ajust-top
    v-card(
      color='#11802C'
      :class='`elevation-4`'
    )
      v-card-title
        span.white--text.font-weight
          v-icon(
            left
            color='white'
          ) mdi-filter
          | Filtrar disciplinas
    v-divider.mx-3
    v-card-text.padding
      v-container.padding-container(
        grid-list-md
      )
        v-layout(
          justify-start
          wrap
          align-center
        )
          v-flex.padding-bottom(
            xs4
            sm2
            md2
          )
            h5.padding.font-weight Código:
          v-flex.padding(
            xs8
            sm10
            md10
          )
            v-text-field.padding-bottom(
              v-model='pesquisaDisciplina.codigo'
              placeholder='Informe o código da disciplina'
              color='#11802C'
              clearable
            )
          v-flex(
            xs4
            sm2
            md2
          )
            h5.font-weight Nome:
          v-flex.padding(
            xs8
            sm10
            md10
          )
            v-text-field.padding(
              v-model='pesquisaDisciplina.nome'
              placeholder='Informe o nome da disciplina'
              color='#11802C'
              clearable
            )
          v-flex.padding(
            xs4
            sm2
            md2
          )
            h5.font-weight Departamento:
          v-flex.padding(
            xs8
            sm10
            md10
          )
            v-select.padding(
              placeholder='Selecione um departamento'
              v-model='pesquisaDisciplina.idDepartamento'
              color='#11802C'
              :items='departamentos'
              item-text='nome'
              item-value='id'
              no-data-text='Não há dados.'
              clearable
            )
          v-flex.padding(
            xs4
            sm2
            md2
          )
            h5.font-weight Tipo:
          v-flex.padding(
            xs8
            sm10
            md10
          )
            v-select(
              placeholder='Selecione o tipo da disciplina'
              v-model='pesquisaDisciplina.idTipo'
              color='#11802C'
              :items='tipos'
              item-text='nome'
              item-value='id'
              no-data-text='Não há dados.'
              clearable
            )
      v-divider.mx-3
      v-card-actions
        v-btn.white--text.style-button(
          color='#707070'
          @click='limparFiltroDisciplinas()'
        )
          v-icon(
            left
          ) mdi-eraser
          | Limpar
        v-spacer
        v-btn.white--text.style-button(
          color='#11802C'
          @click='pesquisarDisciplinas()'
        ) Pesquisar
          v-icon(
            right
          ) mdi-magnify
</template>

<script>
import Card from '@/components/shared/Card.vue'

export default {
  name: 'PesquisaDisciplinas',

  components: {
    Card
  },

  props: {
    departamentos: {
      type: [Object, Array],
      required: true
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
      pesquisaDisciplina: {
        nome: '',
        codigo: '',
        idDepartamento: null,
        idTipo: null
      }
    }
  },

  methods: {
    reset () {
      this.pesquisaDisciplina.nome = null
      this.pesquisaDisciplina.codigo = null
      this.pesquisaDisciplina.idDepartamento = null
      this.pesquisaDisciplina.idTipo = null
      // this.$validator.reset()
    },

    limparFiltroDisciplinas () {
      this.reset()
    },

    pesquisarDisciplinas () {
      // this.filtraAluno(this.pesquisaDisciplina.nome, this.pesquisaDisciplina.idModalidade).then((response) => {
      //   this.getAlunos(this.idProfessor)
      // }).catch((erro) => {
      // })
    }
  }
}
</script>

<style scoped>
.padding-container {
  padding-top: 10px !important;
  padding-bottom: 5px !important;
  margin-top: 10px !important;
  margin-bottom: 5px !important;
  margin-left: 0px !important;
  margin-right: 0px !important;
}

.padding {
  padding-top: 0px !important;
  padding-bottom: 0px !important;
  margin-bottom: 0px !important;
  margin-top: 0px !important;
}

.padding-bottom {
  padding-bottom: 0px !important;
  margin-bottom: 0px !important;
}

.padding-top {
  padding-top: 0px !important;
  margin-top: 0px !important;
}

.font-weight {
  font-weight: 400 !important;
}

.style-button{
  font-size: 14px;
  font-weight: 500 !important;
}

.ajust-top {
  margin-top: 28px;
}
</style>
