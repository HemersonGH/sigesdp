import axios from 'axios'
import {
  SET_DEPARTAMENTOS
} from '../mutation-types'

const state = {
  departamentos: []
}

const getters = {
  departamentos: state => state.departamentos
}

const mutations = {
  [SET_DEPARTAMENTOS] (state, departamentos) {
    state.departamentos = departamentos
  }
}

const actions = {
  async getDepartamentos ({ commit }) {
    const result = await axios.get('/departamentos')
    commit('SET_DEPARTAMENTOS', result)
  }
}

export default {
  namespaced: true,
  state,
  mutations,
  actions,
  getters
}
