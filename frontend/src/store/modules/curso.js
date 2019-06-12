import axios from 'axios'
import { SET_CURSOS_LIST } from '../mutation-types'

const state = {
  cursos: []
}

const getters = {
  cursos: state => state.cursos
}

const mutations = {
  [SET_CURSOS_LIST] (state, cursos) {
    state.cursos = cursos
  }
}

const actions = {
  async getCursos ({ commit }) {
    const result = await axios.get(`/cursos`)
    commit('SET_CURSOS_LIST', result.data)
  }
}

export default {
  namespaced: true,
  state,
  mutations,
  actions,
  getters
}
