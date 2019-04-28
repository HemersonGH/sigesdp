<template lang="pug">
  div
    .component-body
      .nav
        ul.ul
          div(
            v-for='item in itensMenu'
          )
            //- el-tooltip(
            //-   effect='dark',
            //-   :content='item.nome',
            //-   :disabled = 'windowWidth > 1365',
            //-   placement="right"
            //- )
            li.menu-item(
              :class='',
            )
              .menu-group
                i.material-icons {{ item.icon }}
                p.menu-text {{ item.nome }}
</template>

<script>
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
          icon: 'email'
        },
        {
          nome: 'Pesquisa',
          route: '',
          icon: 'email'
        },
        {
          nome: 'Cursos',
          route: '',
          icon: 'email'
        }
      ]
    }
  },

  computed: {},

  methods: {}
}
</script>

<style scoped>
.component-body {
  display: flex;
  position: relative;
  background-color: #3d964d;
  color: #ffffffff;
  font-family: Helvetica, sans-serif;
  width: 10%;
  height: 100%;
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
</style>
