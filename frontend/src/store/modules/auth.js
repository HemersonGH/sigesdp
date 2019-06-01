import axios from 'axios'
import { SET_AUTH_USER } from '../mutation-types'

const state = {
  user: {}
}

const getters = {
  user: state => state.user
}

const mutations = {
  [SET_AUTH_USER] (state, data) {
    state.user = data
  }
}

const actions = {
  async authenticate ({ commit }, user) {
    try {
      const result = await axios.post('/login', user)
      commit('SET_AUTH_USER', result)
    } catch (error) {
      console.log(error)
    }
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
