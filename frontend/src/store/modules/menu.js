import {
  SET_MENU_SIDE
} from '../mutation-types'

const state = {
  menu: false
}

const getters = {
  menu: state => state.menu
}

const mutations = {
  [SET_MENU_SIDE] (state) {
    state.menu = !state.menu
  }
}

export default {
  namespaced: true,
  state,
  mutations,
  getters
}
