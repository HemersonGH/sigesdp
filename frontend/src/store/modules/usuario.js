import axios from 'axios'
import {
  SET_CADASTRA_USUARIO,
  SET_USUARIO_BOOLEN_LOGADO,
  SET_PERMISSAO_USUARIO,
  SET_USUARIO_LOGADO
} from '../mutation-types'

const state = {
  usuario: {},
  usuarioLogadoBool: false,
  permissaoUsario: false,
  usuarioLogado: {}
}

const getters = {
  usuario: state => state.usuario,
  usuarioLogadoBool: state => state.usuarioLogadoBool,
  permissaoUsario: state => state.permissaoUsario,
  usuarioLogado: state => state.usuarioLogado
}

const mutations = {
  [SET_CADASTRA_USUARIO] (state, usuario) {
    state.usuario = usuario
  },
  [SET_USUARIO_BOOLEN_LOGADO] (state) {
    state.usuarioLogadoBool = !state.usuarioLogadoBool
  },

  [SET_PERMISSAO_USUARIO] (state) {
    state.permissaoUsario = !state.permissaoUsario
  },

  [SET_USUARIO_LOGADO] (state, usuarioLogado) {
    state.usuarioLogado = usuarioLogado
  }
}

const actions = {
  async createUsuario ({ commit }, novoUsuario) {
    const response = await axios.post('/professor/novo', novoUsuario)
    commit('SET_CADASTRA_USUARIO', response.data)
    return response
  },
  async getUsuario ({ commit }, email) {
    const response = await axios({
      method: 'get',
      url: '/professor/email/',
      params: {
        email
      }
    })
    commit('SET_USUARIO_LOGADO', response.data)
    return response.data
  }
}

export default {
  namespaced: true,
  state,
  mutations,
  actions,
  getters
}
