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
              @click='openModalCadastraAluno()'
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
            @openModalDetalhesAluno='openModalDetalhesAluno'
            @openModalAtualizaAluno='openModalAtualizaAluno'
            @openModalConfirmaRemocaoAluno='openModalConfirmaRemocaoAluno'
          )
    CadastraAluno(
      :showDialogCadastraAluno='showDialogCadastraAluno'
      :idProfessor='getUsuarioLogado.id'
      :curso='cursos.data'
      :modalidadesBolsa='modalidadesBolsa.data'
      :snackbarCadastraAluno='snackbarCadastraAluno'
      :snackbarAlunoCadastradoSucesso='snackbarAlunoCadastradoSucesso'
      :snackbarAlunoCadastradoErro='snackbarAlunoCadastradoErro'
      @closeModalCadastraAluno='closeModalCadastraAluno'
      @getNovoAlunoCadastrado='getNovoAlunoCadastrado'
    )
    DetalhesAluno(
      :showDialogDetalhesAluno='showDialogDetalhesAluno'
      :alunoDetalhes='alunoDetalhes'
      @closeModalDetalhesAluno='closeModalDetalhesAluno'
    )
    AtualizaAluno(
      :showDialogAtualizaAluno='showDialogAtualizaAluno'
      :alunoAtualiza='alunoAtualiza'
      :curso='cursos.data'
      :modalidadesBolsa='modalidadesBolsa.data'
      @closeModalAtualizaAluno='closeModalAtualizaAluno'
      @atualizaAluno='atualizaAluno'
    )
    ModalRemoveAluno(
      :alunoRemove='alunoRemove'
      :showDialogCofirmaRemocaoAluno='showDialogCofirmaRemocaoAluno'
      @closeModalConfirmacaoRemocaoAluno='closeModalConfirmacaoRemocaoAluno'
      @removeAlunoFromDataBase='removeAlunoFromDataBase'
    )
    SnackBar(
      :data='snackbarCadastraAluno'
    )
    SnackBar(
      :data='snackbarAlunoCadastradoSucesso'
    )
    SnackBar(
      :data='snackbarAlunoCadastradoErro'
    )
    SnackBar(
      :data='snackbarAlunoAtualizadoSucesso'
    )
    SnackBar(
      :data='snackbarAlunoAtualizadoErro'
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
import Card from '@/components/shared/Card.vue'
import StatsCardTitle from '@/components/shared/StatsCardTitle.vue'
import PesquisaAlunos from '@/components/aluno/PesquisaAlunos.vue'
import ListagemAlunos from '@/components/aluno/ListagemAlunos.vue'
import CadastraAluno from '@/components/aluno/CadastraAluno.vue'
import DetalhesAluno from '@/components/aluno/DetalhesAluno.vue'
import AtualizaAluno from '@/components/aluno/AtualizaAluno.vue'
import ModalRemoveAluno from '@/components/aluno/ModalRemoveAluno.vue'
import SnackBar from '@/components/shared/SnackBar.vue'

export default {
  name: 'Alunos',

  components: {
    StatsCardTitle,
    Card,
    PesquisaAlunos,
    ListagemAlunos,
    CadastraAluno,
    DetalhesAluno,
    AtualizaAluno,
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
          value: 'modalidadeBolsa.sigla',
          align: 'center'
        },
        {
          sortable: false,
          text: 'Ações',
          value: 'actions',
          align: 'center'
        }
      ],
      alunoDetalhes: null,
      alunoAtualiza: null,
      alunoRemove: null,
      showDialogCadastraAluno: false,
      showDialogDetalhesAluno: false,
      showDialogAtualizaAluno: false,
      showDialogCofirmaRemocaoAluno: false,
      snackbarCadastraAluno: {
        icon: 'mdi-alert-circle-outline',
        message: 'Verifique os campos obrigatórios.',
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
      },
      snackbarAlunoAtualizadoSucesso: {
        icon: 'mdi-check-outline',
        message: 'Dados do aluno atualizado com sucesso.',
        value: false,
        color: 'success'
      },
      snackbarAlunoAtualizadoErro: {
        icon: 'mdi-alert-circle-outline',
        message: 'Não foi possível atualizar os dados do aluno.',
        value: false,
        color: 'error'
      },
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
      updateAluno: 'aluno/updateAluno',
      deleteAluno: 'aluno/deleteAluno',
      getModalidadesBolsa: 'modalidadesBolsa/getModalidadesBolsa',
      getCursos: 'curso/getCursos'
    }),

    openModalCadastraAluno () {
      this.showDialogCadastraAluno = true
    },

    closeModalCadastraAluno () {
      this.showDialogCadastraAluno = false
    },

    openModalDetalhesAluno (aluno) {
      this.alunoDetalhes = aluno
      this.showDialogDetalhesAluno = true
    },

    closeModalDetalhesAluno () {
      this.showDialogDetalhesAluno = false
    },

    openModalAtualizaAluno (alunoAtualizado) {
      this.alunoAtualiza = alunoAtualizado
      this.showDialogAtualizaAluno = true
    },

    closeModalAtualizaAluno () {
      this.showDialogAtualizaAluno = false
    },

    openModalConfirmaRemocaoAluno (alunoDeletado) {
      this.alunoRemove = alunoDeletado
      this.showDialogCofirmaRemocaoAluno = true
    },

    closeModalConfirmacaoRemocaoAluno () {
      this.showDialogCofirmaRemocaoAluno = false
    },

    getNovoAlunoCadastrado () {
      this.showDialogCadastraAluno = false
      this.getAlunos(this.getUsuarioLogado.id)
    },

    atualizaAluno (aluno) {
      this.updateAluno(aluno).then((response) => {
        this.getAlunos(this.getUsuarioLogado.id)
        this.showDialogAtualizaAluno = false
        this.snackbarAlunoAtualizadoSucesso.value = true
      }).catch((erro) => {
        this.snackbarAlunoAtualizadoErro.value = true
      })
    },

    removeAlunoFromDataBase (aluno) {
      this.deleteAluno(aluno.id).then((response) => {
        this.getAlunos(this.getUsuarioLogado.id)
        this.showDialogCofirmaRemocaoAluno = false
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
