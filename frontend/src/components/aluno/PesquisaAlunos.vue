<template lang="pug">
  v-card.ajust-top
    v-card(
      color='#3169B3'
      :class='`elevation-4`'
    )
      v-card-title
        span.white--text.font-weight
          v-icon(
            left
            color='white'
          ) mdi-filter
          | Filtrar alunos
    v-divider.mx-3
    v-card-text.padding
      v-container.padding(
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
            h5.padding-bottom.font-weight.no-margin-bottom Nome:
          v-flex.padding-bottom(
            xs8
            sm10
            md10
          )
            v-text-field.padding-bottom(
              v-model='pesquisaAluno.nome'
              placeholder='Informe o nome do aluno'
              color='#3169B3'
              clearable
            )
          v-flex.padding-top(
            xs4
            sm2
            md2
          )
            h5.padding-top.font-weight.no-margin-bottom Modalidade:
          v-flex.padding-top(
            xs8
            sm10
            md10
          )
            v-select.padding-top(
              placeholder='Selecione uma modalidade de bolsa'
              v-model='pesquisaAluno.idModalidade'
              color='#3169B3'
              :items='modalidades'
              item-text='nome'
              item-value='id'
              no-data-text='Não há dados.'
              clearable
            )
      v-divider.mx-3
      v-card-actions
        v-btn.white--text.style-button(
          color='#707070'
          @click='limparFiltroAlunos()'
        )
          v-icon(
            left
          ) mdi-eraser
          | Limpar
        v-spacer
        v-btn.white--text.style-button(
          color='#3169B3'
          @click='pesquisaAlunos()'
        ) Pesquisar
          v-icon(
            right
          ) mdi-magnify
</template>

<script>
import Card from '@/components/shared/Card.vue'

export default {
  name: 'PesquisaAlunos',

  components: {
    Card
  },

  props: {
    modalidades: {
      type: [Object, Array]
    }
  },

  data () {
    return {
      pesquisaAluno: {
        nome: '',
        idModalidade: null
      }
    }
  },

  methods: {
    limparFiltroAlunos () {

    },

    pesquisaAlunos () {
      // this.filtraAluno(this.pesquisaAluno.nome, this.pesquisaAluno.idModalidade).then((response) => {
      //   this.getAlunos(this.idProfessor)
      // }).catch((erro) => {
      // })
    }
  }
}
</script>

<style scoped>
.padding {
  padding-top: 0px;
  padding-bottom: 0px;
}

.padding-bottom {
  padding-bottom: 0px !important;
}

.padding-top {
  padding-top: 0px !important;
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
