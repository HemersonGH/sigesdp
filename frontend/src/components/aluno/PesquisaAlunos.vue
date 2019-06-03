<template lang="pug">
  v-card.ajust-top
    v-card(
      color='#3169B3'
      :class='`elevation-4`'
    )
      v-card-title.center.color
        span.font-weight Pesquisar alunos
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
              v-model='pesquisaAluno.nomeAluno'
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
              item-text='sigla'
              item-value='id'
              no-data-text='Não há dados.'
              clearable
            )
      v-divider.mx-3
      v-card-actions
        v-spacer
        v-btn.style-button(
          color='#3169B3'
          @click='pesquisa()'
        ) Pesquisar &nbsp
          v-icon mdi-magnify
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
        nomeAluno: '',
        idModalidade: null
      }
    }
  },

  methods: {
    pesquisa () {
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
  font-weight: 450 !important;
  color: white;
}

.ajust-top {
  margin-top: 28px;
}

.color {
  color: white;
}
</style>
