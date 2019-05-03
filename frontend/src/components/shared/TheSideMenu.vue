<template lang="pug">
  v-navigation-drawer(
    id='app-drawer'
    v-model='inputValue'
    app
    dark
    floating
    persistent
    modibel-break-point='980'
    width='260'
  )
    v-layout(
      class='fill-height'
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
            height='35'
            contain
          )
        v-list-tile-title(
          class='title'
        ) UFLA
      v-divider
      v-list-tile(
        v-for='(item, i) in itensMenu'
        :key='i'
        :to='item.route'
        active-class='red'
        avatar
        class='v-list-item'
      )
        v-list-tile-action
          v-icon {{ item.icon }}
        v-list-tile-title(
          v-text='item.title'
        )
  //- v-layout.ajust(
  //-   row
  //- )
  //-   v-flex(
  //-     xs2
  //-   )
  //-     v-navigation-drawer.style-side(
  //-       dark
  //-       permanent
  //-     )
  //-       v-list
  //-         v-list-tile(
  //-           v-for="item in itensMenu"
  //-           :key="item.title"
  //-           @click=''
  //-         )
  //-           v-list-tile-action
  //-             v-icon {{ item.icon }}
  //-           v-list-tile-content.bold
  //-             v-list-tile-title {{ item.title }}
  //-   v-flex(
  //-     xs10
  //-   )
  //-     slot(name='router')
</template>

<script>
import { mapActions, mapGetters } from 'vuex'

export default {
  data () {
    return {
      logo: 'logo.png',
      responsive: false,
      itensMenu: [
        {
          title: 'Acadêmico',
          route: '',
          icon: 'account_balance'
        },
        {
          title: 'Pesquisa',
          route: '',
          icon: 'find_in_page'
        },
        {
          title: 'Cursos',
          route: '',
          icon: 'collections_bookmark'
        }
      ]
    }
  },

  methods: {
    ...mapActions({
      getDepartamentos: 'departamento/getDepartamentos'
    }),

    onResponsiveInverted () {
      if (window.innerWidth < 980) {
        this.responsive = true
      } else {
        this.responsive = false
      }
    }

  },

  computed: {
    ...mapGetters({
      departamentos: 'departamento/departamentos'
    }),

    inputValue: {
      get () {
        // return this.$store.state.app.drawer
      },

      set (val) {
        // this.setDrawer(val)
      }
    },

    items () {
      return this.$t('Layout.View.items')
    }
  },

  created () {
    this.getDepartamentos()
  },

  mounted () {
    this.onResponsiveInverted()
    window.addEventListener('resize', this.onResponsiveInverted)
  },

  beforeDestroy () {
    window.removeEventListener('resize', this.onResponsiveInverted)
  }
}
</script>

<style lang="scss" scoped>
  /* .ajust {
      height: calc(100% - 64px);
    } */

  .bold {
    font-weight: bold;
  }

  .style-side {
    background-color: #35a349;
    color: #ffffffff;
    height: 100%;
  }

  .v-tooltip__content {
    width: max-content;
  }

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

    .search-input {
      margin-bottom: 30px !important;
      padding-left: 15px;
      padding-right: 15px;
    }
  }
</style>
