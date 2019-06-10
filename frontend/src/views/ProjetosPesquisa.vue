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
            h2 Gerenciar Projetos de Pesquisa
          div.text-xs-right
            v-btn.white--text.style-button(
              color='#EF154B'
              @click='openModalCadastraProjetoPesquisa()'
            ) Adicionar Projeto de Pesquisa
              v-icon(
                color='white'
                size='25'
                right
              ) mdi-plus
        PesquisaProjetosPesquisa(
          :departamentos='departamentos.data'
        )
        Card(
          color='#EF154B'
          :title='title'
          styleTitleDataTable='title-data-table'
          full-width
          elevation='6'
        )
          ListagemProjetosPesquisa(
            :headers='headers'
            :contentTable='projetosPesquisa.data.projetosPesquisa'
            @openModalDetalhesProjetoPesquisa='openModalDetalhesProjetoPesquisa'
            @openModalAtualizaProjetoPesquisa='openModalAtualizaProjetoPesquisa'
            @openModalConfirmaRemocaoProjetoPesquisa='openModalConfirmaRemocaoProjetoPesquisa'
          )
    CadastraProjetoPesquisa(
      :showDialogCadastraProjetoPesquisa='showDialogCadastraProjetoPesquisa'
      :idProfessor='getUsuarioLogado.id'
      :alunos='alunos.data.alunos'
      :snackbarCadastraProjetoPesquisa='snackbarCadastraProjetoPesquisa'
      :snackbarProjetoPesquisaCadastradoSucesso='snackbarProjetoPesquisaCadastradoSucesso'
      :snackbarProjetoPesquisaCadastradoErro='snackbarProjetoPesquisaCadastradoErro'
      @closeModalCadastraProjetoPesquisa='closeModalCadastraProjetoPesquisa'
      @getNovoProjetoPesquisaCadastrado='getNovoProjetoPesquisaCadastrado'
    )
    DetalhesProjetoPesquisa(
      :showDialogDetalhesProjetoPesquisa='showDialogDetalhesProjetoPesquisa'
      :projetoPesquisaDetalhes='projetoPesquisaDetalhes'
      :docente='docente.data'
      @closeModalDetalhesProjetoPesquisa='closeModalDetalhesProjetoPesquisa'
    )
    AtualizaProjetoPesquisa(
      :showDialogAtualizaProjetoPesquisa='showDialogAtualizaProjetoPesquisa'
      :projetoPesquisaAtualiza='projetoPesquisaAtualiza'
      :curso='cursos.data'
      :modalidadesBolsa='alunos.data'
      @closeModalAtualizaProjetoPesquisa='closeModalAtualizaProjetoPesquisa'
      @atualizaProjetoPesquisa='atualizaProjetoPesquisa'
    )
    ModalRemoveProjetoPesquisa(
      :projetoPesquisaRemove='projetoPesquisaRemove'
      :showDialogCofirmaRemocaoProjetoPesquisa='showDialogCofirmaRemocaoProjetoPesquisa'
      @closeModalConfirmacaoRemocaoProjetoPesquisa='closeModalConfirmacaoRemocaoProjetoPesquisa'
      @removeProjetoPesquisaFromDataBase='removeProjetoPesquisaFromDataBase'
    )
    SnackBar(
      :data='snackbarCadastraProjetoPesquisa'
    )
    SnackBar(
      :data='snackbarProjetoPesquisaCadastradoSucesso'
    )
    SnackBar(
      :data='snackbarProjetoPesquisaCadastradoErro'
    )
    SnackBar(
      :data='snackbarProjetoPesquisaAtualizadoSucesso'
    )
    SnackBar(
      :data='snackbarProjetoPesquisaAtualizadoErro'
    )
    SnackBar(
      :data='snackbarProjetoPesquisaRemovidoSucesso'
    )
    SnackBar(
      :data='snackbarProjetoPesquisaRemovidoErro'
    )
</template>

<script>
import { mapActions, mapGetters } from 'vuex'
import Card from '@/components/shared/Card.vue'
import CadastraProjetoPesquisa from '@/components/projeto-pesquisa/CadastraProjetoPesquisa.vue'
import PesquisaProjetosPesquisa from '@/components/projeto-pesquisa/PesquisaProjetosPesquisa.vue'
import ListagemProjetosPesquisa from '@/components/projeto-pesquisa/ListagemProjetosPesquisa.vue'
import DetalhesProjetoPesquisa from '@/components/projeto-pesquisa/DetalhesProjetoPesquisa.vue'
import AtualizaProjetoPesquisa from '@/components/projeto-pesquisa/AtualizaProjetoPesquisa.vue'
import ModalRemoveProjetoPesquisa from '@/components/projeto-pesquisa/ModalRemoveProjetoPesquisa.vue'
import SnackBar from '@/components/shared/SnackBar.vue'

export default {
  name: 'ProjetosPesquisa',

  components: {
    Card,
    CadastraProjetoPesquisa,
    PesquisaProjetosPesquisa,
    ListagemProjetosPesquisa,
    DetalhesProjetoPesquisa,
    AtualizaProjetoPesquisa,
    ModalRemoveProjetoPesquisa,
    SnackBar
  },

  data () {
    return {
      title: 'Projetos de Pesquisa',
      headers: [
        {
          sortable: true,
          text: 'Código',
          value: 'codigo',
          align: 'left'
        },
        {
          sortable: true,
          text: 'Título',
          value: 'titulo'
        },
        {
          sortable: true,
          text: 'Discente',
          value: 'projetosPesquisa.aluno.nome'
        },
        {
          sortable: false,
          text: 'Ações',
          value: 'actions',
          align: 'center'
        }
      ],
      projetoPesquisaDetalhes: null,
      projetoPesquisaAtualiza: null,
      projetoPesquisaRemove: null,
      showDialogCadastraProjetoPesquisa: false,
      showDialogDetalhesProjetoPesquisa: false,
      showDialogAtualizaProjetoPesquisa: false,
      showDialogCofirmaRemocaoProjetoPesquisa: false,
      snackbarCadastraProjetoPesquisa: {
        icon: 'mdi-alert-circle-outline',
        message: 'Verifique os campos obrigatórios.',
        value: false,
        color: 'error'
      },
      snackbarProjetoPesquisaCadastradoSucesso: {
        icon: 'mdi-check-outline',
        message: 'Projeto de pesquisa cadastrado com sucesso.',
        value: false,
        color: 'success'
      },
      snackbarProjetoPesquisaCadastradoErro: {
        icon: 'mdi-alert-circle-outline',
        message: 'Não foi possível cadastrar o projeto de pesquisa.',
        value: false,
        color: 'error'
      },
      snackbarProjetoPesquisaAtualizadoSucesso: {
        icon: 'mdi-check-outline',
        message: 'Dados do projeto de pesquisa atualizado com sucesso.',
        value: false,
        color: 'success'
      },
      snackbarProjetoPesquisaAtualizadoErro: {
        icon: 'mdi-alert-circle-outline',
        message: 'Não foi possível atualizar os dados do projeto de pesquisa.',
        value: false,
        color: 'error'
      },
      snackbarProjetoPesquisaRemovidoSucesso: {
        icon: 'mdi-check-outline',
        message: 'Projeto de pesquisa removido com sucesso.',
        value: false,
        color: 'success'
      },
      snackbarProjetoPesquisaRemovidoErro: {
        icon: 'mdi-alert-circle-outline',
        message: 'Não foi possível remover o projeto de pesquisa.',
        value: false,
        color: 'error'
      }
    }
  },

  methods: {
    ...mapActions({
      getDocente: 'docente/getDocente',
      getDepartamentos: 'departamento/getDepartamentos',
      getAlunos: 'aluno/getAlunos',
      getProjetosPesquisa: 'projetoPesquisa/getProjetosPesquisa',
      updateProjetoPesquisa: 'projetoPesquisa/updateProjetoPesquisa',
      deleteProjetoPesquisa: 'projetoPesquisa/deleteProjetoPesquisa',
      getModalidadesBolsa: 'modalidadesBolsa/getModalidadesBolsa',
      getCursos: 'curso/getCursos'
    }),

    openModalCadastraProjetoPesquisa () {
      this.showDialogCadastraProjetoPesquisa = true
    },

    closeModalCadastraProjetoPesquisa () {
      this.showDialogCadastraProjetoPesquisa = false
    },

    openModalDetalhesProjetoPesquisa (projetoPesquisa) {
      this.projetoPesquisaDetalhes = projetoPesquisa
      this.showDialogDetalhesProjetoPesquisa = true
    },

    closeModalDetalhesProjetoPesquisa () {
      this.showDialogDetalhesProjetoPesquisa = false
    },

    openModalAtualizaProjetoPesquisa (projetoPesquisaAtualizado) {
      this.projetoPesquisaAtualiza = projetoPesquisaAtualizado
      this.showDialogAtualizaProjetoPesquisa = true
    },

    closeModalAtualizaProjetoPesquisa () {
      this.showDialogAtualizaProjetoPesquisa = false
    },

    openModalConfirmaRemocaoProjetoPesquisa (projetoPesquisaDeletado) {
      this.projetoPesquisaRemove = projetoPesquisaDeletado
      this.showDialogCofirmaRemocaoProjetoPesquisa = true
    },

    closeModalConfirmacaoRemocaoProjetoPesquisa () {
      this.showDialogCofirmaRemocaoProjetoPesquisa = false
    },

    getNovoProjetoPesquisaCadastrado () {
      this.showDialogCadastraProjetoPesquisa = false
      this.getProjetosPesquisa(this.getUsuarioLogado.id)
    },

    atualizaProjetoPesquisa (projetoPesquisa) {
      this.updateProjetoPesquisa(projetoPesquisa).then((response) => {
        this.getProjetosPesquisa(this.getUsuarioLogado.id)
        this.showDialogAtualizaProjetoPesquisa = false
        this.snackbarProjetoPesquisaAtualizadoSucesso.value = true
      }).catch((erro) => {
        this.snackbarProjetoPesquisaAtualizadoErro.value = true
      })
    },

    removeProjetoPesquisaFromDataBase (projetoPesquisa) {
      this.deleteProjetoPesquisa(projetoPesquisa.id).then((response) => {
        this.getProjetosPesquisa(this.getUsuarioLogado.id)
        this.showDialogCofirmaRemocaoProjetoPesquisa = false
        this.snackbarProjetoPesquisaRemovidoSucesso.value = true
        this.projetoPesquisaRemove = null
      }).catch((erro) => {
        this.snackbarProjetoPesquisaRemovidoErro.value = true
      })
    },

    removeProjetoPesquisaListagem (projetoPesquisa) {
      let index = this.projetosPesquisa.data.projetosPesquisa.indexOf(projetoPesquisa)
      this.projetosPesquisa.data.projetosPesquisa.splice(index, 1)
    }
  },

  computed: {
    ...mapGetters({
      usuarioLogado: 'usuario/usuarioLogado',
      departamentos: 'departamento/departamentos',
      docente: 'docente/docente',
      alunos: 'aluno/alunos',
      projetosPesquisa: 'projetoPesquisa/projetosPesquisa',
      projetoPesquisaRemovido: 'projetoPesquisa/projetoPesquisaRemovido',
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
    this.getDepartamentos()
    this.getDocente(this.getUsuarioLogado.id)
    this.getProjetosPesquisa(this.getUsuarioLogado.id)
    this.getAlunos(this.getUsuarioLogado.id)
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
