import axios from 'axios'
import {
  SET_DOCENTES,
  SET_DOCENTE
} from '../mutation-types'

const state = {
  docentes: [],
  docente: {}
}

const getters = {
  docentes: state => state.docentes,
  docente: state => state.docente
}

const mutations = {
  [SET_DOCENTES] (state, docentes) {
    state.docentes = docentes
  },
  [SET_DOCENTE] (state, docente) {
    state.docente = docente
  }
}

const actions = {
  async getDocentes ({ commit }) {
    const result = await axios.get('/docentes')
    commit('SET_DOCENTES', result.data)
  },
  async getDocente ({ commit }, id) {
    const result = await axios.get(`/docentes/${id}`)
    commit('SET_DOCENTE', result.data)
  }
}

export default {
  namespaced: true,
  state,
  mutations,
  actions,
  getters
}
