import axios from 'axios'
import {
  SET_DOCENTES
} from '../mutation-types'

const state = {
  docentes: []
}

const getters = {
  docentes: state => state.docentes
}

const mutations = {
  [SET_DOCENTES] (state, docentes) {
    state.docentes = docentes
  }
}

const actions = {
  async getDocentes ({ commit }) {
    const result = await axios.get('/docentes')
    commit('SET_DOCENTES', result)
  }
}

export default {
  namespaced: true,
  state,
  mutations,
  actions,
  getters
}
