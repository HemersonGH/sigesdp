<template lang="pug">
  v-card.ajust-top
    v-card(
      color='#BC2121'
      :class='`elevation-4`'
    )
      v-card-title
        span.white--text.font-weight
          v-icon(
            left
            color='white'
          ) mdi-filter
          | Filtrar pesquisadores
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
            xs3
            sm3
            md3
          )
            h5.padding-bottom.font-weight Nome:
          v-flex.padding-bottom(
            xs9
            sm9
            md9
          )
            v-text-field.padding-bottom(
              v-model='filtroPesquisador.nome'
              placeholder='Informe o nome do pesquisador'
              color='#BC2121'
              clearable
            )
          v-flex.padding-top(
            xs3
            sm3
            md3
          )
            h5.padding-top.font-weight Departamento:
          v-flex.padding-top(
            xs9
            sm9
            md9
          )
            v-select.padding-top(
              v-model='filtroPesquisador.idDepartamento'
              placeholder='Selecione um departamento'
              :items='departamentos'
              item-text='nome'
              item-value='id'
              no-data-text='Não há dados.'
              color='#BC2121'
              clearable
            )
          v-flex.padding-top(
            xs3
            sm3
            md3
          )
            h5.padding-top.font-weight Área de Conhecimento:
          v-flex.padding-top(
            xs9
            sm9
            md9
          )
            v-select.padding-top(
              v-model='filtroPesquisador.idAreaConhecimento'
              placeholder='Selecione uma área de conhecimento'
              :items='areasConhecimento'
              item-text='nome'
              item-value='id'
              no-data-text='Não há dados.'
              color='#BC2121'
              clearable
            )
      v-divider.mx-3
      v-card-actions
        v-btn.white--text.style-button(
          color='#707070'
          @click='limparFiltroPesquisadores()'
        )
          v-icon(
            left
          ) mdi-eraser
          | Limpar
        v-spacer
        v-btn.white--text.style-button(
          color='#BC2121'
          @click='pesquisaPesquisadores()'
        ) Pesquisar
          v-icon(
            right
          ) mdi-magnify
</template>

<script>
import Card from '@/components/shared/Card.vue'

export default {
  name: 'PesquisaPesquisadores',

  components: {
    Card
  },

  props: {
    departamentos: {
      type: [Object, Array]
    },

    areasConhecimento: {
      type: [Object, Array]
    }
  },

  data () {
    return {
      filtroPesquisador: {
        nome: null,
        idDepartamento: null,
        idAreaConhecimento: null
      }
    }
  },

  methods: {
    reset () {
      this.filtroPesquisador.nome = null
      this.filtroPesquisador.idDepartamento = null
      this.filtroPesquisador.idAreaConhecimento = null
      // this.$validator.reset()
    },

    pesquisaPesquisadores () {
    },

    limparFiltroPesquisadores () {
      this.reset()
    }
  }
}
</script>

<style scoped>
.padding {
  padding-top: 0px;
  padding-bottom: 0px;
  margin: 0px !important;
}

.padding-bottom {
  padding-bottom: 0px !important;
}

.padding-top {
  padding-top: 0px !important;
}

.font-weight {
  font-weight: 450 !important;
}

.style-button{
  font-weight: 450 !important;
}

.ajust-top {
  margin-top: 28px;
}
</style>
