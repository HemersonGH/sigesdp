import axios from 'axios'
import {
  SET_DEPARTAMENTOS,
  SET_DEPARTAMENTOS_SELECT
} from '../mutation-types'

const state = {
  departamentos: [],
  departamentosSelect: []
}

const getters = {
  departamentos: state => state.departamentos,
  departamentosSelect: state => state.departamentosSelect
}

const mutations = {
  [SET_DEPARTAMENTOS] (state, departamentos) {
    state.departamentos = departamentos
  },
  [SET_DEPARTAMENTOS_SELECT] (state, departamentosSelect) {
    state.departamentosSelect = departamentosSelect
  }
}

const actions = {
  async getDepartamentos ({ commit }) {
    const result = await axios.get('/departamentos')
    commit('SET_DEPARTAMENTOS', result)
  },
  async getDepartamentosSelect ({ commit }) {
    const result = await axios.get('/departamentos-select')
    commit('SET_DEPARTAMENTOS_SELECT', result)
  }
}

export default {
  namespaced: true,
  state,
  mutations,
  actions,
  getters
}
