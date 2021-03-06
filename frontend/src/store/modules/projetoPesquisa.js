import axios from 'axios'
import {
  SET_PROJETO_PESQUISA,
  SET_ALL_PROJETOS_PESQUISA_LIST,
  SET_PROJETOS_PESQUISA_LIST,
  SET_CADASTRA_PROJETO_PESQUISA,
  SET_PROJETO_PESQUISA_ATUALIZADO,
  SET_PROJETO_PESQUISA_REMOVIDO
} from '../mutation-types'

const state = {
  allProjetosPesquisa: [],
  projetosPesquisa: [],
  projetoPesquisa: {},
  projetoPesquisaNovo: null,
  projetoPesquisaAtualizado: null,
  projetoPesquisaRemovido: null
}

const getters = {
  allProjetosPesquisa: state => state.allProjetosPesquisa,
  projetosPesquisa: state => state.projetosPesquisa,
  projetoPesquisa: state => state.projetoPesquisa,
  projetoPesquisaNovo: state => state.projetoPesquisaNovo,
  projetoPesquisaAtualizado: state => state.projetoPesquisaAtualizado,
  projetoPesquisaRemovido: state => state.projetoPesquisaRemovido
}

const mutations = {
  [SET_ALL_PROJETOS_PESQUISA_LIST] (state, allProjetosPesquisa) {
    state.allProjetosPesquisa = allProjetosPesquisa
  },
  [SET_PROJETOS_PESQUISA_LIST] (state, projetosPesquisa) {
    state.projetosPesquisa = projetosPesquisa
  },
  [SET_PROJETO_PESQUISA] (state, projetoPesquisa) {
    state.projetoPesquisa = projetoPesquisa
  },
  [SET_CADASTRA_PROJETO_PESQUISA] (state, projetosPesquisa) {
    state.projetoPesquisaNovo = projetosPesquisa
  },
  [SET_PROJETO_PESQUISA_ATUALIZADO] (state, projetosPesquisa) {
    state.projetoPesquisaAtualizado = projetosPesquisa
  },
  [SET_PROJETO_PESQUISA_REMOVIDO] (state, projetosPesquisa) {
    state.projetoPesquisaRemovido = projetosPesquisa
  }
}

const actions = {
  async getAllProjetosPesquisa ({ commit }, id) {
    const response = await axios.get(`/projetos-pesquisa`)
    commit('SET_ALL_PROJETOS_PESQUISA_LIST', response.data)
    return response.data
  },
  async getProjetosPesquisa ({ commit }, id) {
    const response = await axios.get(`/docentes/projetos-pesquisa/${id}`)
    commit('SET_PROJETOS_PESQUISA_LIST', response.data)
    return response.data
  },
  async getProjetoPesquisa ({ commit }, id) {
    const response = await axios.get(`/projetos-pesquisa/${id}`)
    commit('SET_PROJETO_PESQUISA', response.data)
    return response.data
  },
  async createProjetoPesquisa ({ commit }, novoProjetoPesquisa) {
    const response = await axios.post('/projetos-pesquisa/novo', novoProjetoPesquisa)
    commit('SET_CADASTRA_PROJETO_PESQUISA', response.data)
    return response.data
  },
  async updateProjetoPesquisa ({ commit }, projetoPesquisaAtualizado) {
    const response = await axios.put('/projetos-pesquisa/atualiza', projetoPesquisaAtualizado)
    commit('SET_PROJETO_PESQUISA_ATUALIZADO', response.data)
    return response.data
  },
  async deleteProjetoPesquisa ({ commit }, id) {
    const response = await axios.delete(`/projetos-pesquisa/remove/${id}`)
    commit('SET_PROJETO_PESQUISA_REMOVIDO', response.data)
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
