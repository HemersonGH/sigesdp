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
          :departamentos='departamentosSelect'
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
            :contentTable='disciplinas.disciplinas'
            @openModalDetalhesDisciplina='openModalDetalhesDisciplina'
            @openModalAtualizaDisciplina='openModalAtualizaDisciplina'
            @openModalConfirmaRemocaoDisciplina='openModalConfirmaRemocaoDisciplina'
          )
    CadastraDisciplina(
      :showDialogCadastraDisciplina='showDialogCadastraDisciplina'
      :idProfessor='getUsuarioLogado.id'
      :departamentos='departamentosSelect'
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
      :disciplina='disciplinaAtualiza'
      :departamentos='departamentosSelect'
      :snackbarValidaAtualizaDisciplina='snackbarValidaAtualizaDisciplina'
      :snackbarDisciplinaAtualizadaSucesso='snackbarDisciplinaAtualizadaSucesso'
      :snackbarDisciplinaAtualizadaErro='snackbarDisciplinaAtualizadaErro'
      @getNovaDisciplinaCadastrada='getNovaDisciplinaCadastrada'
      @closeModalAtualizaDisciplina='closeModalAtualizaDisciplina'
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
      :data='snackbarValidaAtualizaDisciplina'
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
import _ from 'lodash'
import { mapActions, mapGetters } from 'vuex'
import Card from '@/components/shared/Card.vue'
import PesquisaDisciplinas from '@/components/docente/disciplina/PesquisaDisciplinas.vue'
import ListagemDisciplinas from '@/components/docente/disciplina/ListagemDisciplinas.vue'
import CadastraDisciplina from '@/components/docente/disciplina/CadastraDisciplina.vue'
import DetalhesDisciplina from '@/components/docente/disciplina/DetalhesDisciplina.vue'
import AtualizaDisciplina from '@/components/docente/disciplina/AtualizaDisciplina.vue'
import ModalRemoveDisciplina from '@/components/docente/disciplina/ModalRemoveDisciplina.vue'
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
      title: 'Listagem de Disciplinas',
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
      snackbarValidaAtualizaDisciplina: {
        icon: 'mdi-alert-circle-outline',
        message: 'Verifique os campos obrigatórios.',
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
      this.disciplinaDetalhes = _.cloneDeep(disciplina)
      this.showDialogDetalhesDisciplina = true
    },

    closeModalDetalhesDisciplina () {
      this.showDialogDetalhesDisciplina = false
    },

    openModalAtualizaDisciplina (disciplinaAtualizada) {
      this.disciplinaAtualiza = _.cloneDeep(disciplinaAtualizada)
      this.showDialogAtualizaDisciplina = true
    },

    closeModalAtualizaDisciplina () {
      this.showDialogAtualizaDisciplina = false
    },

    openModalConfirmaRemocaoDisciplina (disciplinaRemovida) {
      this.disciplinaRemove = _.cloneDeep(disciplinaRemovida)
      this.showDialogCofirmaRemocaoDisciplina = true
    },

    closeModalConfirmacaoRemocaoDisciplina () {
      this.showDialogCofirmaRemocaoDisciplina = false
    },

    getNovaDisciplinaCadastrada () {
      this.getDisciplinas(this.getUsuarioLogado.id)
      this.showDialogCadastraDisciplina = false
      this.showDialogAtualizaDisciplina = false
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
      let index = this.disciplinas.disciplinas.indexOf(disciplina)
      this.disciplinas.disciplinas.splice(index, 1)
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
