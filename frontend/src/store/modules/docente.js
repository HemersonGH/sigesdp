import axios from 'axios'
import {
  SET_DOCENTES,
  SET_DOCENTE,
  SET_ALUNOS_DOCENTE
} from '../mutation-types'

const state = {
  docentes: [],
  docente: {},
  alunos: []
}

const getters = {
  docentes: state => state.docentes,
  docente: state => state.docente,
  alunos: state => state.alunos
}

const mutations = {
  [SET_DOCENTES] (state, docentes) {
    state.docentes = docentes
  },
  [SET_DOCENTE] (state, docente) {
    state.docente = docente
  },
  [SET_ALUNOS_DOCENTE] (state, alunos) {
    state.alunos = alunos
  }
}

const actions = {
  async getDocentes ({ commit }) {
    const result = await axios.get('/docentes')
    commit('SET_DOCENTES', result)
  },
  async getDocenteById ({ commit }, id) {
    const result = await axios.get(`/professor/${id}`)
    commit('SET_DOCENTE', result)
  },
  async getAlunos ({ commit }, id) {
    const result = await axios.get(`/professor/alunos/${id}`)
    commit('SET_ALUNOS_DOCENTE', result)
  }
}

export default {
  namespaced: true,
  state,
  mutations,
  actions,
  getters
}
