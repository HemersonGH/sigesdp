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
          | Filtrar docentes
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
              v-model='filtroDocente.nome'
              placeholder='Informe o nome do professor'
              color='#11802C'
              clearable
            )
          v-flex.padding-top(
            xs4
            sm2
            md2
          )
            h5.padding-top.font-weight.no-margin-bottom Departamento:
          v-flex.padding-top(
            xs8
            sm10
            md10
          )
            v-select.padding-top(
              v-model='filtroDocente.idDepartamento'
              placeholder='Selecione um departamento'
              :items='departamentos'
              item-text='nome'
              item-value='id'
              no-data-text='Não há dados.'
              color='#11802C'
              clearable
            )
      v-divider.mx-3
      v-card-actions
        v-btn.white--text.style-button(
          color='#707070'
          @click='limparFiltroDocentes()'
        )
          v-icon(
            left
          ) mdi-eraser
          | Limpar
        v-spacer
        v-btn.white--text.style-button(
          color='#11802C'
          @click='pesquisaDocentes()'
        ) Pesquisar
          v-icon(
            right
          ) mdi-magnify
</template>

<script>
import Card from '@/components/shared/Card.vue'

export default {
  name: 'PesquisaDocentes',

  components: {
    Card
  },

  props: {
    departamentos: {
      type: [Object, Array]
    }
  },

  data () {
    return {
      filtroDocente: {
        nome: '',
        idDepartamento: null
      }
    }
  },

  methods: {
    pesquisaDocentes () {
    },

    limparFiltroDocentes () {
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
  font-weight: 450 !important;
}

.style-button{
  font-weight: 450 !important;
}

.ajust-top {
  margin-top: 28px;
}
</style>
