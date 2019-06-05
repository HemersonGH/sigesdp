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
          ListagemAlunos(
            :headers='headers'
            :contentTable='alunos.data.alunos'
            @openModal='openModal'
          )
      DetalhesAlunos(
        :showDialog='showDialog'
        :data='aluno'
        @close='closeModal'
      )
</template>

<script>
import { mapActions, mapGetters } from 'vuex'
import LinkVoltar from '@/components/shared/LinkVoltar.vue'
import Card from '@/components/shared/Card.vue'
import PesquisaAlunos from '@/components/aluno/PesquisaAlunos.vue'
import ListagemAlunos from '@/components/aluno/ListagemAlunos.vue'
import DetalhesAlunos from '@/components/aluno/DetalhesAlunos.vue'

export default {
  name: 'Alunos',

  components: {
    LinkVoltar,
    Card,
    PesquisaAlunos,
    ListagemAlunos,
    DetalhesAlunos
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
          value: 'modalidadeBolsa.sigla'
        },
        {
          sortable: false,
          text: 'Ações',
          value: 'actions',
          align: 'right'
        }
      ],
      aluno: null,
      showDialog: false
    }
  },

  methods: {
    ...mapActions({
      getAlunos: 'docente/getAlunos',
      getModalidadesBolsa: 'modalidadesBolsa/getModalidadesBolsa'
    }),

    valueSearch (query) {
      this.search = query
    },

    openModal (item) {
      this.aluno = item
      this.showDialog = true
    },

    closeModal () {
      this.showDialog = false
    }
  },

  computed: {
    ...mapGetters({
      usuarioLogado: 'usuario/usuarioLogado',
      alunos: 'docente/alunos',
      modalidadesBolsa: 'modalidadesBolsa/modalidadesBolsa'
    }),

    getUsuarioLogado: {
      get () {
        return this.usuarioLogado
      },
      set () {
      }
    }
  },

  created () {
    this.getAlunos(this.getUsuarioLogado.id)
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
