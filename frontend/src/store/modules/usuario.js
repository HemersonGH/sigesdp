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
  async novoUsuario ({ commit }, usuario) {
    const result = await axios.post('/cadastrar-professor')
    commit('SET_CADASTRA_USUARIO', result)
  }
}

export default {
  namespaced: true,
  state,
  mutations,
  actions,
  getters
}
