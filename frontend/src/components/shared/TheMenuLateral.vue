<template lang="pug">
  .component-body
    .nav
      ul.ul
        div(
          v-for='item in itensMenu'
        )
          v-tooltip(
            :right='true'
          )
            template(
              v-slot:activator='{ on }'
            )
              li.menu-item(
                :class='',
                v-on='on'
              )
                .menu-group
                  i.material-icons {{ item.icon }}
                  p.menu-text {{ item.nome }} &nbsp
            span(
                v-if='item.nome == "Acadêmico"'
            ) Acessar a área acadêmica
            span(
                v-if='item.nome == "Pesquisa"'
            ) Acessar as pesquisas
            span(
                v-if='item.nome == "Cursos"'
            ) Acessar os cursos
</template>

<script>
import { mapActions, mapGetters } from 'vuex'
import BotaoTheHeader from '@/components/shared/BotaoTheHeader.vue'

export default {
  name: 'TheMenuLateral',

  components: {
    BotaoTheHeader
  },

  data () {
    return {
      itensMenu: [
        {
          nome: 'Acadêmico',
          route: '',
          icon: 'account_balance'
        },
        {
          nome: 'Pesquisa',
          route: '',
          icon: 'search'
        },
        {
          nome: 'Cursos',
          route: '',
          icon: 'collections_bookmark'
        }
      ]
    }
  },

  methods: {
    ...mapActions({
      getDepartamentos: 'departamento/getDepartamentos'
    })
  },

  computed: {
    ...mapGetters({
      departamentos: 'departamento/departamentos'
    })
  },

  created () {
    this.getDepartamentos()
  }
}
</script>

<style scoped>
  .component-body {
    display: flex;
    position: relative;
    background-color: #35a349;
    color: #ffffffff;
    font-family: Helvetica, sans-serif;
    width: 10%;
    height: calc(100% - 65px);
  }

  .nav {
    width: 100%;
  }

  .ul {
    padding: 0;
    margin: 0;
  }

  .menu-item {
    padding: 5px;
    padding-bottom: 5px;
    display: flex;
    height: 6vw;
    align-items: center;
    transition: hover 1s;
  }

  .menu-group {
    width: 100%;
    display: flex;
    flex-direction: column;
    text-align: center;
  }

  .menu-item:hover {
    cursor: pointer;
    background-color: rgb(49, 80, 49);
    -webkit-transition: background-color 0.2s ease-out;
    -moz-transition: background-color 0.2s ease-out;
    -o-transition: background-color 0.2s ease-out;
    transition: background-color 0.2s ease-out;
  }

  .menu-text {
    font-weight: bold;
    margin-top: 5%;
    /* font-size: 0.8vw; */
  }

  .active {
    color: #009f61;
    background: linear-gradient(-45deg, #009f61 0%, #009f61 7%, white 0%);
  }

  @media (max-width: 1365px) {
    .menu-text {
      font-size: 0.8vw;
    }

    .menu-text {
      display: none;
    }

    .material-icons {
      font-size: 25px;
    }
  }

  .v-tooltip__content {
    width: max-content;
  }
</style>
