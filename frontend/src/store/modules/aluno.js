import axios from 'axios'
import {
  SET_ALUNOS_LIST,
  SET_ALUNOS_REMOVIDO
} from '../mutation-types'

const state = {
  alunos: [],
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
  [SET_ALUNOS_REMOVIDO] (state, aluno) {
    state.alunoRemovido = aluno
  }
}

const actions = {
  async getAlunos ({ commit }, id) {
    const result = await axios.get(`/docente/alunos/${id}`)
    commit('SET_ALUNOS_LIST', result)
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
