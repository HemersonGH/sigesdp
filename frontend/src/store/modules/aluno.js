import axios from 'axios'
import {
  SET_ALUNO,
  SET_ALUNOS_LIST,
  SET_CADASTRA_ALUNO,
  SET_ALUNO_ATUALIZADO,
  SET_ALUNO_REMOVIDO
} from '../mutation-types'

const state = {
  aluno: {},
  alunos: [],
  alunoNovo: null,
  alunoAtualizado: null,
  alunoRemovido: null
}

const getters = {
  aluno: state => state.aluno,
  alunos: state => state.alunos,
  alunoNovo: state => state.alunoNovo,
  alunoAtualizado: state => state.alunoAtualizado,
  alunoRemovido: state => state.alunoRemovido
}

const mutations = {
  [SET_ALUNO] (state, aluno) {
    state.aluno = aluno
  },
  [SET_ALUNOS_LIST] (state, alunos) {
    state.alunos = alunos
  },
  [SET_CADASTRA_ALUNO] (state, aluno) {
    state.alunoNovo = aluno
  },
  [SET_ALUNO_ATUALIZADO] (state, aluno) {
    state.alunoRemovido = aluno
  },
  [SET_ALUNO_REMOVIDO] (state, aluno) {
    state.alunoRemovido = aluno
  }
}

const actions = {
  async getAlunos ({ commit }, id) {
    const result = await axios.get(`/docentes/alunos/${id}`)
    commit('SET_ALUNOS_LIST', result.data)
  },
  async getAluno ({ commit }, id) {
    const result = await axios.get(`/alunos/${id}`)
    commit('SET_ALUNO', result.data)
    return result.data
  },
  async createAluno ({ commit }, novoAluno) {
    const response = await axios.post('/alunos/novo', novoAluno)
    commit('SET_CADASTRA_ALUNO', response.data)
    return response.data
  },
  async updateAluno ({ commit }, alunoAtualizado) {
    const response = await axios.put('/alunos/atualiza', alunoAtualizado)
    commit('SET_ALUNO_ATUALIZADO', response.data)
    return response.data
  },
  async deleteAluno ({ commit }, id) {
    const result = await axios.delete(`/alunos/remove/${id}`)
    commit('SET_ALUNO_REMOVIDO', result.data)
    return result.data
  },
  async filtraAluno ({ commit }, nome, idModalidade) {
    const response = await axios({
      method: 'get',
      url: '/aluno/filtro/',
      params: {
        nome,
        idModalidade
      }
    })
    commit('SET_ALUNO_FILTRO', response.data)
    return response.data
  }
}

export default {
  namespaced: true,
  state,
  mutations,
  actions,
  getters
}
