<template lang="pug">
  v-card.ajust-top
    v-card(
      color='#2CBF36'
      :class='`elevation-4`'
    )
      v-card-title.center.color
        span.font-weight Pesquisa avançada
    v-divider.mx-3
    v-card-text.padding
      v-container.padding(
        grid-list-md
      )
        v-layout(
          justify-start
          row
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
              v-model='nome'
              placeholder='Informe o nome do professor'
              v-validate="'required'"
              :error-messages="errors.collect('select')"
              data-vv-name='Nome'
            )
        v-layout(
          justify-start
          row
          align-center
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
              placeholder='Selecione um departamento'
              v-model='select'
              :items='departamentos'
              item-text='nome'
              item-value='id'
              no-data-text='Não há dados.'
              data-vv-name='Departamento'
            )
      v-divider.mx-3
      v-card-actions
        v-spacer
        v-btn.style-button(
          color='#2CBF36'
          @click='pesquisa()'
        ) Pesquisar &nbsp
          v-icon mdi-magnify
</template>

<script>
import Card from '@/components/shared/Card.vue'

export default {
  components: {
    Card
  },

  props: {
    departamentos: {
      type: [Object, Array]
    }
  },

  $_veeValidate: {
    validator: 'new'
  },

  data () {
    return {
      text: 'Pesquisa',
      nome: '',
      select: null
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
