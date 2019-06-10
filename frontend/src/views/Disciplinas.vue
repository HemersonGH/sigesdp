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
            h2 Gerenciar Disciplinas
          div.text-xs-right
            v-btn.white--text.style-button(
              color='#11802C'
              @click='openModalCadastraDisciplina()'
            ) Adicionar disciplina
              v-icon(
                color='white'
                size='25'
                right
              ) mdi-plus
        PesquisaDisciplinas(
          :departamentos='departamentosSelect.data'
        )
        Card(
          color='#11802C'
          :title='title'
          styleTitleDataTable='title-data-table'
          full-width
          elevation='6'
        )
          ListagemDisciplinas(
            :headers='headers'
            :contentTable='disciplinas.data.disciplinas'
            @openModalDetalhesDisciplina='openModalDetalhesDisciplina'
            @openModalAtualizaDisciplina='openModalAtualizaDisciplina'
            @openModalConfirmaRemocaoDisciplina='openModalConfirmaRemocaoDisciplina'
          )
    CadastraDisciplina(
      :showDialogCadastraDisciplina='showDialogCadastraDisciplina'
      :idProfessor='getUsuarioLogado.id'
      :departamentos='departamentosSelect.data'
      :snackbarCadastraDisciplina='snackbarCadastraDisciplina'
      :snackbarDisciplinaCadastradaSucesso='snackbarDisciplinaCadastradaSucesso'
      :snackbarDisciplinaCadastradaErro='snackbarDisciplinaCadastradaErro'
      @closeModalCadastraDisciplina='closeModalCadastraDisciplina'
      @getNovaDisciplinaCadastrada='getNovaDisciplinaCadastrada'
    )
    DetalhesDisciplina(
      :showDialogDetalhesDisciplina='showDialogDetalhesDisciplina'
      :disciplinaDetalhes='disciplinaDetalhes'
      @closeModalDetalhesDisciplina='closeModalDetalhesDisciplina'
    )
    AtualizaDisciplina(
      :showDialogAtualizaDisciplina='showDialogAtualizaDisciplina'
      :disciplinaAtualiza='disciplinaAtualiza'
      :departamentos='departamentosSelect.data'
      @closeModalAtualizaDisciplina='closeModalAtualizaDisciplina'
      @atualizaDisciplina='atualizaDisciplina'
    )
    ModalRemoveDisciplina(
      :disciplina='disciplinaRemove'
      :showDialogCofirmaRemocaoDisciplina='showDialogCofirmaRemocaoDisciplina'
      @closeModalConfirmacaoRemocaoDisciplina='closeModalConfirmacaoRemocaoDisciplina'
      @removeDisciplinaFromDataBase='removeDisciplinaFromDataBase'
    )
    SnackBar(
      :data='snackbarCadastraDisciplina'
    )
    SnackBar(
      :data='snackbarDisciplinaCadastradaSucesso'
    )
    SnackBar(
      :data='snackbarDisciplinaCadastradaErro'
    )
    SnackBar(
      :data='snackbarDisciplinaAtualizadaSucesso'
    )
    SnackBar(
      :data='snackbarDisciplinaAtualizadaErro'
    )
    SnackBar(
      :data='snackbarDisciplinaRemovidaSucesso'
    )
    SnackBar(
      :data='snackbarDisciplinaRemovidaErro'
    )
</template>

<script>
import { mapActions, mapGetters } from 'vuex'
import Card from '@/components/shared/Card.vue'
import PesquisaDisciplinas from '@/components/disciplina/PesquisaDisciplinas.vue'
import ListagemDisciplinas from '@/components/disciplina/ListagemDisciplinas.vue'
import CadastraDisciplina from '@/components/disciplina/CadastraDisciplina.vue'
import DetalhesDisciplina from '@/components/disciplina/DetalhesDisciplina.vue'
import AtualizaDisciplina from '@/components/disciplina/AtualizaDisciplina.vue'
import ModalRemoveDisciplina from '@/components/disciplina/ModalRemoveDisciplina.vue'
import SnackBar from '@/components/shared/SnackBar.vue'

export default {
  name: 'Disciplinas',

  components: {
    PesquisaDisciplinas,
    Card,
    ListagemDisciplinas,
    CadastraDisciplina,
    DetalhesDisciplina,
    AtualizaDisciplina,
    ModalRemoveDisciplina,
    SnackBar
  },

  data () {
    return {
      title: 'Disciplinas',
      headers: [
        {
          sortable: true,
          text: 'Tipo',
          value: 'tipo',
          align: 'left'
        },
        {
          sortable: true,
          text: 'Nome',
          value: 'nome'
        },
        {
          sortable: true,
          text: 'Código',
          value: 'codigo'
        },
        {
          sortable: true,
          text: 'Departamento',
          value: 'departamento.sigla',
          align: 'center'
        },
        {
          sortable: false,
          text: 'Ações',
          value: 'actions',
          align: 'center'
        }
      ],
      disciplinaDetalhes: null,
      disciplinaAtualiza: null,
      disciplinaRemove: null,
      showDialogCadastraDisciplina: false,
      showDialogDetalhesDisciplina: false,
      showDialogAtualizaDisciplina: false,
      showDialogCofirmaRemocaoDisciplina: false,
      snackbarCadastraDisciplina: {
        icon: 'mdi-alert-circle-outline',
        message: 'Verifique os campos obrigatórios.',
        value: false,
        color: 'error'
      },
      snackbarDisciplinaCadastradaSucesso: {
        icon: 'mdi-check-outline',
        message: 'Disciplina cadastrada com sucesso.',
        value: false,
        color: 'success'
      },
      snackbarDisciplinaCadastradaErro: {
        icon: 'mdi-alert-circle-outline',
        message: 'Não foi possível cadastrar a disciplina.',
        value: false,
        color: 'error'
      },
      snackbarDisciplinaAtualizadaSucesso: {
        icon: 'mdi-check-outline',
        message: 'Dados do disciplina atualizado com sucesso.',
        value: false,
        color: 'success'
      },
      snackbarDisciplinaAtualizadaErro: {
        icon: 'mdi-alert-circle-outline',
        message: 'Não foi possível atualizar os dados da disciplina.',
        value: false,
        color: 'error'
      },
      snackbarDisciplinaRemovidaSucesso: {
        icon: 'mdi-check-outline',
        message: 'Disciplina removida com sucesso.',
        value: false,
        color: 'success'
      },
      snackbarDisciplinaRemovidaErro: {
        icon: 'mdi-alert-circle-outline',
        message: 'Não foi possível remover a disciplina.',
        value: false,
        color: 'error'
      }
    }
  },

  methods: {
    ...mapActions({
      getDisciplinas: 'disciplina/getDisciplinas',
      updateDisciplina: 'disciplina/updateDisciplina',
      deleteDisciplina: 'disciplina/deleteDisciplina',
      getDepartamentosSelect: 'departamento/getDepartamentosSelect',
      getCursos: 'curso/getCursos'
    }),

    openModalCadastraDisciplina () {
      this.showDialogCadastraDisciplina = true
    },

    closeModalCadastraDisciplina () {
      this.showDialogCadastraDisciplina = false
    },

    openModalDetalhesDisciplina (disciplina) {
      this.disciplinaDetalhes = disciplina
      this.showDialogDetalhesDisciplina = true
    },

    closeModalDetalhesDisciplina () {
      this.showDialogDetalhesDisciplina = false
    },

    openModalAtualizaDisciplina (disciplinaAtualizada) {
      this.disciplinaAtualiza = disciplinaAtualizada
      this.showDialogAtualizaDisciplina = true
    },

    closeModalAtualizaDisciplina () {
      this.showDialogAtualizaDisciplina = false
    },

    openModalConfirmaRemocaoDisciplina (disciplinaRemovida) {
      this.disciplinaRemove = disciplinaRemovida
      this.showDialogCofirmaRemocaoDisciplina = true
    },

    closeModalConfirmacaoRemocaoDisciplina () {
      this.showDialogCofirmaRemocaoDisciplina = false
    },

    getNovaDisciplinaCadastrada () {
      this.showDialogCadastraDisciplina = false
      this.getDisciplinas(this.getUsuarioLogado.id)
    },

    atualizaDisciplina (disciplina) {
      this.updateDisciplina(disciplina).then((response) => {
        this.getDisciplinas(this.getUsuarioLogado.id)
        this.showDialogAtualizaDisciplina = false
        this.snackbarDisciplinaAtualizadaSucesso.value = true
        this.disciplinaAtualiza = null
      }).catch((erro) => {
        this.snackbarDisciplinaAtualizadaErro.value = true
      })
    },

    removeDisciplinaFromDataBase (disciplina) {
      this.deleteDisciplina(disciplina.id).then((response) => {
        this.getDisciplinas(this.getUsuarioLogado.id)
        this.showDialogCofirmaRemocaoDisciplina = false
        this.snackbarDisciplinaRemovidaSucesso.value = true
        this.disciplinaRemove = null
      }).catch((erro) => {
        this.snackbarDisciplinaRemovidaErro.value = true
      })
    },

    removeDisciplinaListagem (disciplina) {
      let index = this.disciplinas.data.disciplinas.indexOf(disciplina)
      this.disciplinas.data.disciplinas.splice(index, 1)
    }
  },

  computed: {
    ...mapGetters({
      usuarioLogado: 'usuario/usuarioLogado',
      disciplinas: 'disciplina/disciplinas',
      disciplinaRemovida: 'disciplina/disciplinaRemovida',
      departamentosSelect: 'departamento/departamentosSelect',
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
    this.getDisciplinas(this.getUsuarioLogado.id)
    this.getDepartamentosSelect()
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
