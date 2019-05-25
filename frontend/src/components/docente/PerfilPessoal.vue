<template lang="pug">
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
        InformacoesPessoais(
          :data='data'
        )
        Contato(
          :data='data'
        )
</template>

<script>
import InformacoesPessoais from '@/components/docente/InformacoesPessoais.vue'
import Contato from '@/components/docente/Contato.vue'

export default {
  name: 'PerfilPessoal',

  props: {
    data: {
      type: [Object, Array],
      required: true
    }
  },

  components: {
    InformacoesPessoais,
    Contato
  }
}
</script>

<style scoped>
</style>
