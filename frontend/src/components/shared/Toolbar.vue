<template lang="pug">
  v-toolbar(
    id='core-toolbar'
    flat
    prominent
  )
    v-toolbar-items
      v-flex(
        layout
        py-2
      )
        v-btn(
          v-if='responsive'
          dark
          icon
          @click.stop='showMenu'
        )
          v-icon mdi-view-list
    v-spacer
    div.v-toolbar-title
      v-toolbar-title.font-weight-bold.white--text
        | {{ title }}
    v-spacer
    div
      v-tooltip(
        bottom
      )
        template(
          v-slot:activator='{ on }'
        )
          v-toolbar-items(
            v-on='on'
          )
            v-flex(
              align-center
              layout
              py-2
            )
              router-link(
                class='toolbar-items'
                to='/login'
              )
                v-btn.style-button(
                  icon
                ) Login
                  v-icon mdi-login
        span Acesse o sistema
</template>

<script>
import { mapGetters } from 'vuex'
import { log } from 'util';

export default {
  name: 'Toolbar',

  data () {
    return {
      title: 'Sistema de Gestão do Docente/Professor',
      responsive: false,
      showedMenu: false
    }
  },

  mounted () {
    this.onResponsiveInverted()
    this.onResponsiveShowedSideMenu()
    window.addEventListener('resize', this.onResponsiveInverted)
    window.addEventListener('resize', this.onResponsiveShowedSideMenu)
  },

  beforeDestroy () {
    window.removeEventListener('resize', this.onResponsiveInverted)
    window.removeEventListener('resize', this.onResponsiveShowedSideMenu)
  },

  methods: {
    showMenu () {
      console.log(this.menu)
      this.showedMenu = true
      this.$store.commit('menu/SET_SIDE_MENU')
    },

    onClick () {
      //
    },

    onResponsiveInverted () {
      if (window.innerWidth < 1264) {
        this.responsive = true
      } else {
        this.showedMenu = false
        this.responsive = false
      }
    },

    onResponsiveShowedSideMenu() {
      if (this.menu && !this.showedMenu) { 
        this.$store.commit('menu/SET_SIDE_MENU')
      }
      //if (window.innerWidth >= 1264 && this.menu && !this.showedMenu) {
        //this.$store.commit('menu/SET_SIDE_MENU')
      //}
    }
  },

  computed: {
    ...mapGetters({
      menu: 'menu/menu'
    })
  }
}
</script>

<style scoped>
  #core-toolbar a {
    text-decoration: none;
  }

  .style-button {
    font-weight: bold !important;
    font-size: inherit;
  }

  .theme--light.v-toolbar {
    background-color: #2196f3;
    color: white;
  }
</style>
