<template lang="pug">
  v-card.ajust-top
    v-card(
      color='#BC2121'
      :class='`elevation-4`'
    )
      v-card-title
        span.white--text.font-weight
          v-icon(
            left
            color='white'
          ) mdi-filter
          | Filtrar projetos de pesquisa
    v-divider.mx-3
    v-card-text.padding
      v-container.padding-container(
        grid-list-md
      )
        v-layout(
          justify-start
          wrap
          align-center
        )
          v-flex.padding-bottom(
            xs4
            sm2
            md2
          )
            h5.padding.font-weight Código:
          v-flex.padding(
            xs8
            sm10
            md10
          )
            v-text-field.padding-bottom(
              v-model='pesquisaProjetoPesquisa.codigo'
              placeholder='Informe o código da disciplina'
              color='#BC2121'
              clearable
            )
          v-flex(
            xs4
            sm2
            md2
          )
            h5.font-weight Nome:
          v-flex.padding(
            xs8
            sm10
            md10
          )
            v-text-field.padding(
              v-model='pesquisaProjetoPesquisa.nome'
              placeholder='Informe o nome da disciplina'
              color='#BC2121'
              clearable
            )
          v-flex.padding(
            xs4
            sm2
            md2
          )
            h5.font-weight Departamento:
          v-flex.padding(
            xs8
            sm10
            md10
          )
            v-select.padding(
              placeholder='Selecione um departamento'
              v-model='pesquisaProjetoPesquisa.idDepartamento'
              color='#BC2121'
              :items='departamentos'
              item-text='nome'
              item-value='id'
              no-data-text='Não há dados.'
              clearable
            )
          v-flex.padding(
            xs4
            sm2
            md2
          )
            h5.font-weight Tipo:
          v-flex.padding(
            xs8
            sm10
            md10
          )
            v-select(
              placeholder='Selecione o tipo da disciplina'
              v-model='pesquisaProjetoPesquisa.idTipo'
              color='#BC2121'
              :items='tipos'
              item-text='nome'
              item-value='id'
              no-data-text='Não há dados.'
              clearable
            )
      v-divider.mx-3
      v-card-actions
        v-btn.white--text.style-button(
          color='#707070'
          @click='limparFiltroProjetoPesquisa()'
        )
          v-icon(
            left
          ) mdi-eraser
          | Limpar
        v-spacer
        v-btn.white--text.style-button(
          color='#BC2121'
          @click='pesquisarProjetoPesquisa()'
        ) Pesquisar
          v-icon(
            right
          ) mdi-magnify
</template>

<script>
import Card from '@/components/shared/Card.vue'

export default {
  name: 'PesquisaProjetosPesquisa',

  components: {
    Card
  },

  props: {
    departamentos: {
      type: [Object, Array]
    }
  },

  data () {
    return {
      tipos: [
        {
          id: 0,
          nome: 'Graduação'
        },
        {
          id: 1,
          nome: 'Pós-Graduação'
        }
      ],
      pesquisaProjetoPesquisa: {
        nome: '',
        codigo: '',
        idDepartamento: null,
        idTipo: null
      }
    }
  },

  methods: {
    reset () {
      this.pesquisaProjetoPesquisa.nome = null
      this.pesquisaProjetoPesquisa.codigo = null
      this.pesquisaProjetoPesquisa.idDepartamento = null
      this.pesquisaProjetoPesquisa.idTipo = null
      // this.$validator.reset()
    },

    pesquisarProjetoPesquisa () {
      // this.filtraAluno(this.pesquisaProjetoPesquisa.nome, this.pesquisaProjetoPesquisa.idModalidade).then((response) => {
      // this.getAlunos(this.idProfessor)
      // }).catch((erro) => {
      // })
    },

    limparFiltroProjetoPesquisa () {
      this.reset()
    }
  }
}
</script>

<style scoped>
.padding-container {
  padding-top: 10px !important;
  padding-bottom: 5px !important;
  margin-top: 10px !important;
  margin-bottom: 5px !important;
  margin-left: 5px !important;
  margin-right: 5px !important;
}

.padding {
  padding-top: 0px !important;
  padding-bottom: 0px !important;
  margin-bottom: 0px !important;
  margin-top: 0px !important;
}

.padding-bottom {
  padding-bottom: 0px !important;
  margin-bottom: 0px !important;
}

.padding-top {
  padding-top: 0px !important;
  margin-top: 0px !important;
}

.font-weight {
  font-weight: 400 !important;
}

.style-button{
  font-size: 14px;
  font-weight: 500 !important;
}

.ajust-top {
  margin-top: 28px;
}
</style>
