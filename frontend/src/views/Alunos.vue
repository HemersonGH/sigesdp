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
          :modalidades='modalidadesBolsa'
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
            :contentTable='alunos.alunos'
            @openModalDetalhesAluno='openModalDetalhesAluno'
            @openModalAtualizaAluno='openModalAtualizaAluno'
            @openModalConfirmaRemocaoAluno='openModalConfirmaRemocaoAluno'
          )
    CadastraAluno(
      :showDialogCadastraAluno='showDialogCadastraAluno'
      :idProfessor='getUsuarioLogado.id'
      :curso='cursos'
      :modalidadesBolsa='modalidadesBolsa'
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
      :aluno='alunoAtualiza'
      :curso='cursos'
      :modalidadesBolsa='modalidadesBolsa'
      :snackbarValidaAtualizaAluno='snackbarValidaAtualizaAluno'
      :snackbarAlunoAtualizadoSucesso='snackbarAlunoAtualizadoSucesso'
      :snackbarAlunoAtualizadoErro='snackbarAlunoAtualizadoErro'
      @getNovoAlunoCadastrado='getNovoAlunoCadastrado'
      @closeModalAtualizaAluno='closeModalAtualizaAluno'
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
      :data='snackbarValidaAtualizaAluno'
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
import _ from 'lodash'
import { mapActions, mapGetters } from 'vuex'
import Card from '@/components/shared/Card.vue'
import PesquisaAlunos from '@/components/docente/aluno/PesquisaAlunos.vue'
import ListagemAlunos from '@/components/docente/aluno/ListagemAlunos.vue'
import CadastraAluno from '@/components/docente/aluno/CadastraAluno.vue'
import DetalhesAluno from '@/components/docente/aluno/DetalhesAluno.vue'
import AtualizaAluno from '@/components/docente/aluno/AtualizaAluno.vue'
import ModalRemoveAluno from '@/components/docente/aluno/ModalRemoveAluno.vue'
import SnackBar from '@/components/shared/SnackBar.vue'

export default {
  name: 'Alunos',

  components: {
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
      title: 'Listagem de Alunos',
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
      snackbarValidaAtualizaAluno: {
        icon: 'mdi-alert-circle-outline',
        message: 'Verifique os campos obrigatórios.',
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
      this.alunoDetalhes = _.cloneDeep(aluno)
      this.showDialogDetalhesAluno = true
    },

    closeModalDetalhesAluno () {
      this.showDialogDetalhesAluno = false
    },

    openModalAtualizaAluno (alunoAtualizado) {
      this.alunoAtualiza = _.cloneDeep(alunoAtualizado)
      this.showDialogAtualizaAluno = true
    },

    closeModalAtualizaAluno () {
      this.showDialogAtualizaAluno = false
    },

    openModalConfirmaRemocaoAluno (alunoDeletado) {
      this.alunoRemove = _.cloneDeep(alunoDeletado)
      this.showDialogCofirmaRemocaoAluno = true
    },

    closeModalConfirmacaoRemocaoAluno () {
      this.showDialogCofirmaRemocaoAluno = false
    },

    getNovoAlunoCadastrado () {
      this.getAlunos(this.getUsuarioLogado.id)
      this.showDialogCadastraAluno = false
      this.showDialogAtualizaAluno = false
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
      let index = this.alunos.alunos.indexOf(aluno)
      this.alunos.alunos.splice(index, 1)
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
