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
              title='Listagem de Disciplinas de Graduação'
              text='Pesquise as disciplina de graduação do professor'
              :disciplinas='this.disciplinas.filter(function (disciplina) { return disciplina.tipo === 0 })'
              @openModalDetalhesDisciplina='openModalDetalhesDisciplina'
            )
          v-tab-item
            ListagemDisciplinas(
              title='Listagem de Disciplinas de Pós-Graduação'
              text='Pesquise as disciplina de pós-graduação do professor'
              :disciplinas='this.posGraduacao = this.disciplinas.filter(function (disciplina) { return disciplina.tipo === 1 })'
              @openModalDetalhesDisciplina='openModalDetalhesDisciplina'
            )
      DetalhesDisciplina(
        :showModalDetalhesDisciplina='showModalDetalhesDisciplina'
        :disciplina='disciplina'
        @closeModalDetalehesDisciplina='closeModalDetalehesDisciplina'
      )
</template>

<script>
import _ from 'lodash'
import ListagemDisciplinas from '@/components/academico/docente/ListagemDisciplinas.vue'
import DetalhesDisciplina from '@/components/academico/docente/DetalhesDisciplina.vue'

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
      showModalDetalhesDisciplina: false
    }
  },

  methods: {
    openModalDetalhesDisciplina (disciplina) {
      this.disciplina = _.cloneDeep(disciplina)
      this.showModalDetalhesDisciplina = true
    },

    closeModalDetalehesDisciplina () {
      this.showModalDetalhesDisciplina = false
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
