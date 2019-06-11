import axios from 'axios'
import {
  SET_DISCIPLINA,
  SET_DISCIPLINAS_LIST,
  SET_CADASTRA_DISCIPLINA,
  SET_DISCIPLINA_ATUALIZADA,
  SET_DISCIPLINA_REMOVIDA
} from '../mutation-types'

const state = {
  disciplina: {},
  disciplinas: [],
  disciplinaNova: null,
  disciplinaAtualizada: null,
  disciplinaRemovida: null
}

const getters = {
  disciplina: state => state.disciplina,
  disciplinas: state => state.disciplinas,
  disciplinaNova: state => state.disciplinaNova,
  disciplinaAtualizada: state => state.disciplinaAtualizada,
  disciplinaRemovida: state => state.disciplinaRemovida
}

const mutations = {
  [SET_DISCIPLINA] (state, disciplina) {
    state.disciplina = disciplina
  },
  [SET_DISCIPLINAS_LIST] (state, disciplinas) {
    state.disciplinas = disciplinas
  },
  [SET_CADASTRA_DISCIPLINA] (state, disciplina) {
    state.disciplinaNova = disciplina
  },
  [SET_DISCIPLINA_ATUALIZADA] (state, disciplina) {
    state.disciplinaAtualizada = disciplina
  },
  [SET_DISCIPLINA_REMOVIDA] (state, disciplina) {
    state.disciplinaRemovida = disciplina
  }
}

const actions = {
  async getDisciplinas ({ commit }, id) {
    const response = await axios.get(`/docentes/disciplinas/${id}`)
    commit('SET_DISCIPLINAS_LIST', response)
  },
  async getDisciplina ({ commit }, id) {
    const response = await axios.get(`/disciplinas/${id}`)
    commit('SET_DISCIPLINA', response)
    return response.data
  },
  async createDisciplina ({ commit }, novoDisciplina) {
    const response = await axios.post('/disciplinas/nova', novoDisciplina)
    commit('SET_CADASTRA_DISCIPLINA', response.data)
    return response
  },
  async updateDisciplina ({ commit }, disciplinaAtualizada) {
    const response = await axios.put('/disciplinas/atualiza', disciplinaAtualizada)
    commit('SET_DISCIPLINA_ATUALIZADA', response.data)
    return response
  },
  async deleteDisciplina ({ commit }, id) {
    const response = await axios.delete(`/disciplinas/remove/${id}`)
    commit('SET_DISCIPLINA_REMOVIDA', response)
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
