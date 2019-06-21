<template lang="pug">
  v-card.ajust-top
    v-card(
      color='#009194'
      :class='`elevation-4`'
    )
      v-card-title
        span.white--text.font-weight
          v-icon(
            left
            color='white'
          ) mdi-filter
          | Filtrar bolsistas
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
              v-model='filtroIniciacaoCientifica.nome'
              placeholder='Informe o nome do bolsista'
              color='#009194'
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
              v-model='filtroIniciacaoCientifica.idDepartamento'
              placeholder='Selecione um departamento'
              :items='departamentos'
              item-text='nome'
              item-value='id'
              no-data-text='Não há dados.'
              color='#009194'
              clearable
            )
          v-flex.padding-top(
            xs3
            sm3
            md3
          )
            h5.padding-top.font-weight Modalidade da Bolsa:
          v-flex.padding-top(
            xs9
            sm9
            md9
          )
            v-select.padding-top(
              v-model='filtroIniciacaoCientifica.idModalidadesBolsa'
              placeholder='Selecione uma modalidade de bolsa'
              :items='modalidadesBolsa'
              item-text='nome'
              item-value='id'
              no-data-text='Não há dados.'
              color='#009194'
              clearable
            )
      v-divider.mx-3
      v-card-actions
        v-btn.white--text.style-button(
          color='#707070'
          @click='limparFiltroIniciacaoCientifica()'
        )
          v-icon(
            left
          ) mdi-eraser
          | Limpar
        v-spacer
        v-btn.white--text.style-button(
          color='#009194'
          @click='pesquisaIniciacaoCientifica()'
        ) Pesquisar
          v-icon(
            right
          ) mdi-magnify
</template>

<script>
import Card from '@/components/shared/Card.vue'

export default {
  name: 'PesquisaIniciacaoCientifica',

  components: {
    Card
  },

  props: {
    departamentos: {
      type: [Object, Array]
    },

    modalidadesBolsa: {
      type: [Object, Array]
    }
  },

  data () {
    return {
      filtroIniciacaoCientifica: {
        nome: null,
        idDepartamento: null,
        idModalidadesBolsa: null
      }
    }
  },

  methods: {
    reset () {
      this.filtroIniciacaoCientifica.nome = null
      this.filtroIniciacaoCientifica.idDepartamento = null
      this.filtroIniciacaoCientifica.idModalidadesBolsa = null
      // this.$validator.reset()
    },

    pesquisaIniciacaoCientifica () {
    },

    limparFiltroIniciacaoCientifica () {
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
