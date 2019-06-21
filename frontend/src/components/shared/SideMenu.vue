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
        v-if='!getValueusuarioLogadoBool'
        v-for='(item, i) in itensMenuPublico'
        :key='i'
        :to='item.route'
        active-class='blue'
        avatar
      )
        v-tooltip(
          right
          content-class='right'
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
          span {{ item.textTooltip }}
      v-list-tile.v-list-item(
        v-if='getValueusuarioLogadoBool'
        v-for='(item, i) in itensMenuDocente'
        :key='i'
        :to='item.route'
        active-class='blue'
        avatar
      )
        v-tooltip(
          right
          content-class='right'
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
          span {{ item.textTooltip }}
</template>

<script>
import { mapGetters } from 'vuex'
import logo from '@/assets/images/icone-ufla.png'

export default {
  name: 'SideMenu',

  data () {
    return {
      logo: logo,
      itensMenuPublico: [
        {
          title: 'Acadêmico',
          route: '/academico',
          icon: 'account_balance',
          textTooltip: 'Acesse a área acadêmica'
        },
        {
          title: 'Pesquisa',
          route: '/pesquisa',
          icon: 'find_in_page',
          textTooltip: 'Acesse as pesquisas'
        },
        {
          title: 'Cursos',
          route: '',
          icon: 'collections_bookmark',
          textTooltip: 'Acesse os cursos'
        }
      ],
      itensMenuDocente: [
        {
          title: 'Alunos',
          route: '/alunos',
          icon: 'mdi-account-multiple',
          textTooltip: 'Gerenciar alunos'
        },
        {
          title: 'Projetos de Pesquisa',
          route: '/projetos-pesquisa',
          icon: 'find_in_page',
          textTooltip: 'Gerenciar projetos de pesquisa'
        },
        {
          title: 'Disciplinas',
          route: '/disciplinas',
          icon: 'mdi-book-multiple-variant',
          textTooltip: 'Gerenciar disciplinas'
        },
        {
          title: 'Publicações',
          route: '',
          icon: 'mdi-file-powerpoint',
          textTooltip: 'Gerenciar publicações'
        }
      ]
    }
  },

  computed: {
    ...mapGetters({
      menu: 'menu/menu',
      usuarioLogadoBool: 'usuario/usuarioLogadoBool'
    }),

    getValueShowMenu: {
      get () {
        return this.menu
      },
      set () {
      }
    },

    getValueusuarioLogadoBool: {
      get () {
        return this.usuarioLogadoBool
      },
      set () {
      }
    }
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
