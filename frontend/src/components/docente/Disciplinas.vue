<template lang="pug">
  v-container(
    grid-list-xl
    fluid
    fill-height
  )
    v-layout(
      justify-start
      wrap
    )
      v-flex(
        md12
      )
        v-tabs.align(
          color='transparent'
        )
          v-tabs-slider(
            color='#2196f3'
          )
          v-tab Graduação
          v-tab Pós-Graduação
          v-tab-item
            ListagemDisciplinas(
              title='Graduação'
              text='Pesquise as disciplina de graduação do professor'
            )
          v-tab-item
            ListagemDisciplinas(
              title='Pós-Graduação'
              text='Pesquise as disciplina de pós-graduação do professor'
            )
</template>

<script>
import ListagemDisciplinas from '@/components/docente/ListagemDisciplinas.vue'

export default {
  name: 'Disciplinas',

  components: {
    ListagemDisciplinas
  },

  data () {
    return {
    }
  }
}
</script>

<style scoped>
.align {
  padding-top: 10px;
}
</style>
