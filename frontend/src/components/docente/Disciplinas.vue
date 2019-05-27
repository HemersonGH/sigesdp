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
          v-tabs-slider.width(
            color='#2196f3'
          )
          v-tab Graduação
          v-tab Pós-Graduação
          v-tab-item
            ListagemDisciplinas(
              title='Graduação'
              text='Pesquise as disciplina de graduação do professor'
              :data='graduacao'
              @openModal='openModal'
            )
          v-tab-item
            ListagemDisciplinas(
              title='Pós-Graduação'
              text='Pesquise as disciplina de pós-graduação do professor'
              :data='posGraduacao'
              @openModal='openModal'
            )
      DetalhesDisciplina(
        :showDialog='showDialog'
        :data='disciplina'
        @close='closeModal'
      )
</template>

<script>
import ListagemDisciplinas from '@/components/docente/ListagemDisciplinas.vue'
import DetalhesDisciplina from '@/components/docente/DetalhesDisciplina.vue'

export default {
  name: 'Disciplinas',

  props: {
    data: {
      type: [Object, Array],
      required: true
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

  created () {
    this.graduacao = this.data.filter(function (disciplina) {
      return disciplina.tipo === 0
    })

    this.posGraduacao = this.data.filter(function (disciplina) {
      return disciplina.tipo === 1
    })
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
