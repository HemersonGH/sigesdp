<template lang="pug">
  div
    v-tabs(
      v-model='active'
      fixed-tabs
      color='transparent'
      centered
    )
      v-tabs-slider(
        color='#2196f3'
      )
      v-tab(
        v-for='tab in tabs'
        :key='tab'
      )
        v-icon.inherit {{ tab.icon }}
        | &nbsp {{ tab.nome }}
      v-tab-item(
        v-for='tab in tabs'
        :key='tab'
      )
        v-container(
          grid-list-xl
          fluid
          fill-height
        )
          v-layout(
            justify-center
            wrap
          )
            v-flex(
              md12
            )
              PerfilPessoal
              Contato
</template>

<script>
import PerfilPessoal from '@/components/docente/PerfilPessoal.vue'
import Contato from '@/components/docente/Contato.vue'

export default {
  name: 'DetalhesDocente',

  components: {
    PerfilPessoal,
    Contato
  },

  data () {
    return {
      tabs: [
        {
          nome: 'Perfil Pessoal',
          icon: 'mdi-account',
          value: 'tab-1'
        },
        {
          nome: 'Projetos',
          icon: 'mdi-library-books',
          value: 'tab-2'
        },
        {
          nome: 'Disciplinas',
          icon: 'mdi-book-multiple-variant',
          value: 'tab-3'
        }
      ]
    }
  }
}
</script>

<style scoped>
.padding{
  padding-left: 5%;
}

.inherit {
  color: inherit;
}
</style>
