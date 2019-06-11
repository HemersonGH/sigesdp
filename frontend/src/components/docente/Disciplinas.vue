<template lang="pug">
  v-container(
    v-if='disciplinas'
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
          v-tabs-slider.width(
            color='#2196f3'
          )
          v-tab Graduação
          v-tab Pós-Graduação
          v-tab-item
            ListagemDisciplinas(
              title='Graduação'
              text='Pesquise as disciplina de graduação do professor'
              :disciplinas='this.disciplinas.filter(function (disciplina) { return disciplina.tipo === 0 })'
              @openModal='openModal'
            )
          v-tab-item
            ListagemDisciplinas(
              title='Pós-Graduação'
              text='Pesquise as disciplina de pós-graduação do professor'
              :disciplinas='this.posGraduacao = this.disciplinas.filter(function (disciplina) { return disciplina.tipo === 1 })'
              @openModal='openModal'
            )
      DetalhesDisciplina(
        :showDialog='showDialog'
        :disciplina='disciplina'
        @close='closeModal'
      )
</template>

<script>
import ListagemDisciplinas from '@/components/docente/ListagemDisciplinas.vue'
import DetalhesDisciplina from '@/components/docente/DetalhesDisciplina.vue'

export default {
  name: 'Disciplinas',

  props: {
    disciplinas: {
      type: Array
    }
  },

  components: {
    ListagemDisciplinas,
    DetalhesDisciplina
  },

  data () {
    return {
      graduacao: null,
      posGraduacao: null,
      disciplina: null,
      showDialog: false
    }
  },

  methods: {
    openModal (item) {
      this.disciplina = item
      this.showDialog = true
    },

    closeModal () {
      this.showDialog = false
    }
  }
}
</script>

<style scoped>
.align {
  padding-top: 10px;
}

.width {
  min-width: 91.95px;
}
</style>
