import axios from 'axios'
import {
  SET_ALUNOS_LIST,
  SET_CADASTRA_ALUNO,
  SET_ALUNOS_REMOVIDO
} from '../mutation-types'

const state = {
  alunos: [],
  alunoNovo: null,
  alunoRemovido: null
}

const getters = {
  alunos: state => state.alunos,
  alunoRemovido: state => state.alunoRemovido
}

const mutations = {
  [SET_ALUNOS_LIST] (state, alunos) {
    state.alunos = alunos
  },
  [SET_CADASTRA_ALUNO] (state, aluno) {
    state.alunoNovo = aluno
  },
  [SET_ALUNOS_REMOVIDO] (state, aluno) {
    state.alunoRemovido = aluno
  }
}

const actions = {
  async getAlunos ({ commit }, id) {
    const result = await axios.get(`/docente/alunos/${id}`)
    commit('SET_ALUNOS_LIST', result)
  },
  async createAluno ({ commit }, novoAluno) {
    const response = await axios.post('/aluno/novo', novoAluno)
    commit('SET_CADASTRA_ALUNO', response.data)
    return response
  },
  async removeAluno ({ commit }, id) {
    const result = await axios.delete(`/aluno/remove/${id}`)
    commit('SET_ALUNOS_REMOVIDO', result)
    return result.data
  }
}

export default {
  namespaced: true,
  state,
  mutations,
  actions,
  getters
}
