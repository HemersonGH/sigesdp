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
          :docente='docente'
        )
        Contato(
          :docente='docente'
        )
</template>

<script>
import InformacoesPessoais from '@/components/academico/docente/InformacoesPessoais.vue'
import Contato from '@/components/academico/docente/Contato.vue'

export default {
  name: 'PerfilPessoal',

  props: {
    docente: {
      type: Object
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
