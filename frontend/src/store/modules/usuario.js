import axios from 'axios'
import {
  SET_CADASTRA_USUARIO,
  SET_USUARIO_LOGADO
} from '../mutation-types'

const state = {
  usuario: {},
  usuarioLogado: false
}

const getters = {
  usuario: state => state.usuario,
  usuarioLogado: state => state.usuarioLogado
}

const mutations = {
  [SET_CADASTRA_USUARIO] (state, usuario) {
    state.usuario = usuario
  },
  [SET_USUARIO_LOGADO] (state) {
    state.usuarioLogado = !state.usuarioLogado
  }
}

const actions = {
  async createUsuario ({ commit }, novoUsuario) {
    const response = await axios.post('/professor/novo', novoUsuario)
    commit('SET_CADASTRA_USUARIO', response.data)
    return response
  }
}

export default {
  namespaced: true,
  state,
  mutations,
  actions,
  getters
}
