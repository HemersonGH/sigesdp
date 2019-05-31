import axios from 'axios'
import {
  SET_CADASTRA_USUARIO
} from '../mutation-types'

const state = {
  usuario: {}
}

const getters = {
  usuario: state => state.usuario
}

const mutations = {
  [SET_CADASTRA_USUARIO] (state, usuario) {
    state.usuario = usuario
  }
}

const actions = {
  async createUsuario ({ commit }, novoUsuario) {
    try {
      const result = await axios.post('/cadastrar-professor', novoUsuario)
      commit('SET_CADASTRA_USUARIO', result)
    } catch (error) {
      console.log(error)
    }
  }
}

export default {
  namespaced: true,
  state,
  mutations,
  actions,
  getters
}
