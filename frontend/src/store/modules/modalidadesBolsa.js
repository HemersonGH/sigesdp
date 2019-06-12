import axios from 'axios'
import { SET_MODALIDADE_BOLSA } from '../mutation-types'

const state = {
  modalidadesBolsa: []
}

const getters = {
  modalidadesBolsa: state => state.modalidadesBolsa
}

const mutations = {
  [SET_MODALIDADE_BOLSA] (state, modalidadesBolsa) {
    state.modalidadesBolsa = modalidadesBolsa
  }
}

const actions = {
  async getModalidadesBolsa ({ commit }) {
    const result = await axios.get('/modalidades-bolsa')
    commit('SET_MODALIDADE_BOLSA', result.data)
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
