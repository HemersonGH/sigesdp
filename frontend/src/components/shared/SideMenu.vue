<template lang="pug">
  v-navigation-drawer(
    id='app-drawer'
    app
    v-model='getValueShowMenu'
    persistent
    mobile-break-point='1264'
    width='260'
    dark
  )
    v-layout.fill-height(
      tag='v-list'
      column
    )
      v-list-tile(
        avatar
      )
        v-list-tile-avatar(
          color='white'
        )
          v-img(
            :src='logo'
            height='45'
            contain
          )
        v-list-tile-title.style-title.font-weight-bold SIGESDP
      v-divider
      v-list-tile.v-list-item(
        v-for='(item, i) in itensMenu'
        :key='i'
        :to='item.route'
        active-class='blue'
        avatar
      )
        v-tooltip(
          right
        )
          template(
            v-slot:activator='{ on }'
          )
            v-list-tile-action(
              v-on='on'
            )
              v-icon {{ item.icon }}
            v-list-tile-title.font-weight-bold(
              v-text='item.title'
              v-on='on'
            )
          span(
            v-if="item.title == 'Acadêmico'"
          ) Acesse a área acadêmica
          span(
            v-if="item.title == 'Pesquisa'"
          ) Acesse as pesquisas
          span(
            v-if="item.title == 'Cursos'"
          ) Acesse os cursos
</template>

<script>
import { mapGetters } from 'vuex'

export default {
  name: 'SideMenu',

  data () {
    return {
      logo: '../public/images/icone-ufla.png',
      itensMenu: [
        {
          title: 'Acadêmico',
          route: '/academico',
          icon: 'account_balance'
        },
        {
          title: 'Pesquisa',
          route: '/pesquisa',
          icon: 'find_in_page'
        },
        {
          title: 'Cursos',
          route: '/cursos',
          icon: 'collections_bookmark'
        }
      ]
    }
  },

  computed: {
    ...mapGetters({
      menu: 'menu/menu'
    }),

    getValueShowMenu: {
      get () {
        return this.menu
      },
      set () {
      }
    }
  },

  beforeCreate(){
    this.itemActive = this.$route.name   
  }
}
</script>

<style lang="scss">
#app-drawer {
  .v-list__tile {
    border-radius: 4px;

    &--buy {
      margin-top: auto;
      margin-bottom: 17px;
    }
  }

  .v-image__image--contain {
    top: 9px;
    height: 60%;
  }
}

.style-title {
  margin-left: 25px;
  letter-spacing: 3.5px !important;
}

.v-tooltip__content {
  width: max-content;
}
</style>
