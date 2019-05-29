import axios from 'axios'
import {
  SET_AREA_CONHECIMENTO_LIST
} from '../mutation-types'

const state = {
  areaConhecimento: []
}

const getters = {
  areaConhecimento: state => state.areaConhecimento
}

const mutations = {
  [SET_AREA_CONHECIMENTO_LIST] (state, areaConhecimento) {
    state.areaConhecimento = areaConhecimento
  }
}

const actions = {
  async getAreasConhecimento ({ commit }) {
    const result = await axios.get('/areas-conhecimento')
    commit('SET_AREA_CONHECIMENTO_LIST', result)
  }
}

export default {
  namespaced: true,
  state,
  mutations,
  actions,
  getters
}
