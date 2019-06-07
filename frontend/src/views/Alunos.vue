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
            h2 Gerenciar Alunos
          div.text-xs-right
            v-btn.white--text.style-button(
              color='#3169B3'
              @click='openModalCadastro()'
            ) Adicionar aluno
              v-icon(
                color='white'
                size='25'
                right
              ) mdi-plus
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
            @openModalDetalhesAlunos='openModalDetalhesAlunos'
            @openModalConfirmaRemocao='openModalConfirmaRemocao'
          )
    CadastraAluno(
      :showDialogCadastraAluno='showDialogCadastraAluno'
      :curso='cursos.data'
      :modalidadesBolsa='modalidadesBolsa.data'
      @closeModalCadastro='closeModalCadastro'
      @cadastraAluno='cadastraAluno'
    )
    DetalhesAluno(
      :showDialogDetalhesAluno='showDialogDetalhesAluno'
      :data='alunoDetalhes'
      @closeModalDetalhesAluno='closeModalDetalhesAluno'
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
    SnackBar(
      :data='snackbarAlunoCadastradoSucesso'
    )
    SnackBar(
      :data='snackbarAlunoCadastradoErro'
    )
</template>

<script>
import { mapActions, mapGetters } from 'vuex'
import LinkVoltar from '@/components/shared/LinkVoltar.vue'
import Card from '@/components/shared/Card.vue'
import StatsCardTitle from '@/components/shared/StatsCardTitle.vue'
import PesquisaAlunos from '@/components/aluno/PesquisaAlunos.vue'
import ListagemAlunos from '@/components/aluno/ListagemAlunos.vue'
import CadastraAluno from '@/components/aluno/CadastraAluno.vue'
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
    CadastraAluno,
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
      alunoDetalhes: null,
      alunoRemove: null,
      showDialogCadastraAluno: false,
      showDialogDetalhesAluno: false,
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
      },
      snackbarAlunoCadastradoSucesso: {
        icon: 'mdi-check-outline',
        message: 'Aluno cadastrado com sucesso.',
        value: false,
        color: 'success'
      },
      snackbarAlunoCadastradoErro: {
        icon: 'mdi-alert-circle-outline',
        message: 'Não foi possível cadastrar o aluno.',
        value: false,
        color: 'error'
      }
    }
  },

  methods: {
    ...mapActions({
      getAlunos: 'aluno/getAlunos',
      createAluno: 'aluno/createAluno',
      removeAluno: 'aluno/removeAluno',
      getModalidadesBolsa: 'modalidadesBolsa/getModalidadesBolsa',
      getCursos: 'curso/getCursos'
    }),

    valueSearch (query) {
      this.search = query
    },

    openModalCadastro () {
      this.showDialogCadastraAluno = true
    },

    closeModalCadastro () {
      this.showDialogCadastraAluno = false
    },

    openModalDetalhesAlunos (item) {
      this.alunoDetalhes = item
      this.showDialogDetalhesAluno = true
    },

    closeModalDetalhesAluno () {
      this.showDialogDetalhesAluno = false
    },

    openModalConfirmaRemocao (aluno) {
      this.alunoRemove = aluno
      this.showDialogCofirmaRemocao = true
    },

    closeModalConfirmacaoRemocao () {
      this.showDialogCofirmaRemocao = false
    },

    cadastraAluno (aluno) {
      aluno.professor.id = this.getUsuarioLogado.id

      this.createAluno(aluno).then((response) => {
        this.getAlunos(this.getUsuarioLogado.id)

        this.showDialogCadastraAluno = false
        this.snackbarAlunoCadastradoSucesso.value = true
      }).catch((erro) => {
        this.snackbarAlunoCadastradoErro.value = true
      })
    },

    removeAlunoFromDataBase (aluno) {
      this.removeAluno(aluno.id).then((response) => {
        this.getAlunos(this.getUsuarioLogado.id)

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
      modalidadesBolsa: 'modalidadesBolsa/modalidadesBolsa',
      cursos: 'curso/cursos'
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
    this.getCursos()
  }
}
</script>

<style scoped>
.no-padding-top {
  padding-top: 0px !important;
}

.style-button {
  font-size: 14px;
  font-weight: 500 !important;
}
</style>
