import axios from 'axios'
import {
  SET_ALUNOS_LIST,
  SET_CADASTRA_ALUNO,
  SET_ALUNO_ATUALIZADO,
  SET_ALUNO_REMOVIDO
} from '../mutation-types'

const state = {
  alunos: [],
  alunoNovo: null,
  alunoAtualizado: null,
  alunoRemovido: null
}

const getters = {
  alunos: state => state.alunos,
  alunoNovo: state => state.alunoNovo,
  alunoAtualizado: state => state.alunoAtualizado,
  alunoRemovido: state => state.alunoRemovido
}

const mutations = {
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
    const result = await axios.get(`/docente/alunos/${id}`)
    commit('SET_ALUNOS_LIST', result)
  },
  async getAluno ({ commit }, id) {
    const result = await axios.get(`/aluno/${id}`)
    commit('SET_ALUNO_ATUALIZADO', result)
    return result.data
  },
  async createAluno ({ commit }, novoAluno) {
    const response = await axios.post('/aluno/novo', novoAluno)
    commit('SET_CADASTRA_ALUNO', response.data)
    return response
  },
  async updateAluno ({ commit }, alunoAtualizado) {
    const response = await axios.put('/aluno/atualiza', alunoAtualizado)
    commit('SET_ALUNO_ATUALIZADO', response.data)
    return response
  },
  async deleteAluno ({ commit }, id) {
    const result = await axios.delete(`/aluno/remove/${id}`)
    commit('SET_ALUNO_REMOVIDO', result)
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
