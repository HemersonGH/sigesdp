<template lang="pug">
  v-container.no-padding-top(
    fill-height
    fluid
    grid-list-xl
  )
    v-layout.no-padding-top(
      justify-center
      wrap
    )
      v-flex.no-padding-top(
        md12
      )
        div
          div.text-xs-center
            h2.style-title Gerenciar Alunos
          div.text-xs-right
            v-btn.style-button(
              color='#3169B3'
              @click='novoAluno()'
            )
              v-icon(
                color='white'
                size='25'
              ) mdi-plus
              | &nbsp Novo aluno
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
            @openModalConfirmaRemocao='openModalConfirmaRemocao'
          )
    DetalhesAluno(
      :showDialog='showDialog'
      :data='aluno'
      @close='closeModal'
    )
    ModalRemoveAluno(
      :aluno='alunoRemove'
      :showDialogConfirm='showDialogCofirmaRemocao'
      @closeModalConfirmacaoRemocao='closeModalConfirmacaoRemocao'
      @removeAlunoFromDataBase='removeAlunoFromDataBase'
    )
    SnackBar(
      :data='snackbarAlunoRemovidoSucesso'
    )
    SnackBar(
      :data='snackbarAlunoRemovidoErro'
    )
</template>

<script>
import { mapActions, mapGetters } from 'vuex'
import LinkVoltar from '@/components/shared/LinkVoltar.vue'
import Card from '@/components/shared/Card.vue'
import StatsCardTitle from '@/components/shared/StatsCardTitle.vue'
import PesquisaAlunos from '@/components/aluno/PesquisaAlunos.vue'
import ListagemAlunos from '@/components/aluno/ListagemAlunos.vue'
import DetalhesAluno from '@/components/aluno/DetalhesAluno.vue'
import ModalRemoveAluno from '@/components/aluno/ModalRemoveAluno.vue'
import SnackBar from '@/components/shared/SnackBar.vue'

export default {
  name: 'Alunos',

  components: {
    LinkVoltar,
    StatsCardTitle,
    Card,
    PesquisaAlunos,
    ListagemAlunos,
    DetalhesAluno,
    ModalRemoveAluno,
    SnackBar
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
      alunoRemove: null,
      showDialog: false,
      showDialogCofirmaRemocao: false,
      snackbarAlunoRemovidoSucesso: {
        icon: 'mdi-check-outline',
        message: 'Aluno removido com sucesso.',
        value: false,
        color: 'success'
      },
      snackbarAlunoRemovidoErro: {
        icon: 'mdi-alert-circle-outline',
        message: 'Não foi possível remover o aluno.',
        value: false,
        color: 'error'
      }
    }
  },

  methods: {
    ...mapActions({
      getAlunos: 'aluno/getAlunos',
      removeAluno: 'aluno/removeAluno',
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
    },

    openModalConfirmaRemocao (aluno) {
      this.showDialogCofirmaRemocao = true
      this.alunoRemove = aluno
    },

    closeModalConfirmacaoRemocao () {
      this.showDialogCofirmaRemocao = false
    },

    removeAlunoFromDataBase (aluno) {
      this.removeAluno(aluno.id).then((response) => {
        this.removeAlunoListagem(aluno)
        this.showDialogCofirmaRemocao = false
        this.snackbarAlunoRemovidoSucesso.value = true
        this.alunoRemove = null
      }).catch((erro) => {
        this.snackbarAlunoRemovidoErro.value = true
      })
    },

    removeAlunoListagem (aluno) {
      let index = this.alunos.data.alunos.indexOf(aluno)
      this.alunos.data.alunos.splice(index, 1)
    }
  },

  computed: {
    ...mapGetters({
      usuarioLogado: 'usuario/usuarioLogado',
      alunos: 'aluno/alunos',
      alunoRemovido: 'aluno/alunoRemovido',
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
    this.removeAluno()
  }
}
</script>

<style scoped>
.no-padding-top {
  padding-top: 0px !important;
}

.style-title {
  font-weight: 300 !important;
  margin-top: 10px;
}

.style-button {
  font-size: 15px;
  font-weight: 500 !important;
  color: white;
}
</style>
