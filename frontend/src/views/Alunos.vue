<template lang="pug">
  v-container(
    fill-height
    fluid
    grid-list-xl
  )
    v-layout(
      justify-center
      wrap
    )
      v-flex.no-padding-top(
        md12
      )
        PesquisaAlunos(
          :modalidades='modalidadesBolsa.data'
        )
        Card(
          color='#3169B3'
          :title='title'
          styleTitleDataTable='title-data-table'
          full-width
          elevation='6'
        )
          ListagemDocentes(
            :headers='headers'
            :contentTable='docentes.data'
            @openDetails='openDetails'
          )
</template>

<script>
import { mapActions, mapGetters } from 'vuex'
import LinkVoltar from '@/components/shared/LinkVoltar.vue'
import Card from '@/components/shared/Card.vue'
import PesquisaAlunos from '@/components/aluno/PesquisaAlunos.vue'
import ListagemDocentes from '@/components/docente/ListagemDocentes.vue'

export default {
  name: 'Alunos',

  components: {
    LinkVoltar,
    Card,
    PesquisaAlunos,
    ListagemDocentes
  },

  data () {
    return {
      title: 'Alunos',
      headers: [
        {
          sortable: true,
          text: 'Nome',
          value: 'nome',
          align: 'left'
        },
        {
          sortable: true,
          text: 'Modalidade',
          value: 'modalidade.sigla'
        },
        {
          sortable: false,
          text: 'Ações',
          value: 'actions',
          align: 'right'
        }
      ]
    }
  },

  methods: {
    ...mapActions({
      getDocentes: 'docente/getDocentes',
      getModalidadesBolsa: 'modalidadesBolsa/getModalidadesBolsa'
    }),

    valueSearch (query) {
      this.search = query
    },

    openDetails () {
    }
  },

  computed: {
    ...mapGetters({
      docentes: 'docente/docentes',
      modalidadesBolsa: 'modalidadesBolsa/modalidadesBolsa'
    })
  },

  created () {
    this.getDocentes()
    this.getModalidadesBolsa()
  }
}
</script>

<style scoped>
.no-padding-top {
  padding-top: 0px !important;
}

.styleMouse{
  cursor: pointer;
}

.v-card--shared-stats.v-card .v-card__actions .caption {
    color: #000;
}
</style>
