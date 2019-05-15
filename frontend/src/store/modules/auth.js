import axios from '../../utils/api-axios'
import { SET_AUTH_USER, SET_ALL_USERS } from '../mutation-types'

const state = {
  user: {},
  users: null
}

const getters = {
  user: state => state.user,
  users: state => state.users
}

const mutations = {
  [SET_AUTH_USER] (state, data) {
    state.user = data
  },
  [SET_ALL_USERS] (state, data) {
    state.users = data
  }
}

const actions = {
  authenticate ({ commit }, params) {
    return new Promise((resolve, reject) => {
      axios({
        url: 'login',
        method: 'post',
        withCredentials: true,
        auth: {
          username: params.login,
          password: params.senha
        }
      }).then((response) => {
        if (response.status !== 200) {
          commit(SET_AUTH_USER, null)
          reject(response)
        } else {
          commit(SET_AUTH_USER, response.data)
          resolve(response)
        }
      }).catch((error) => {
        reject(error)
      })
    })
  },

  logout ({ commit }) {
    axios({
      url: 'logout',
      method: 'get'
    }).then(() => {
      commit(SET_AUTH_USER, null)
    }).catch(() => {
      commit(SET_AUTH_USER, null)
    })
  },

  getAuthUser ({ commit }) {
    return new Promise((resolve, reject) => {
      axios({
        url: 'getAuthUser',
        method: 'get'
      }).then((response) => {
        if (response.data) {
          commit(SET_AUTH_USER, response.data)
          resolve()
        } else {
          commit(SET_AUTH_USER, null)
          reject() //eslint-disable-line
        }
      }).catch(() => {
        commit(SET_AUTH_USER, null)
        reject() //eslint-disable-line
      })
    })
  }
}

export default {
  namespaced: true,
  state,
  getters,
  mutations,
  actions
}
