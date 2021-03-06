import {
  SET_SIDE_MENU
} from '../mutation-types'

const state = {
  menu: true
}

const getters = {
  menu: state => state.menu
}

const mutations = {
  [SET_SIDE_MENU] (state) {
    state.menu = !state.menu
  }
}

export default {
  namespaced: true,
  state,
  mutations,
  getters
}
