<template lang="pug">
  v-toolbar(
    id='core-toolbar'
    flat
    prominent
  )
    v-spacer
    div.v-toolbar-title
      v-toolbar-title.font-weight-bold.white--text
        v-btn(
          v-if='responsive'
          dark
          icon
          @click='showMenu'
        )
          v-icon mdi-view-list
          v-spacer
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
                v-ripple
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

export default {
  name: 'Toolbar',

  data () {
    return {
      title: 'Sistema de Gestão do Docente/Professor',
      responsive: false,
      responsiveInput: false
    }
  },

  mounted () {
    this.onResponsiveInverted()
    window.addEventListener('resize', this.onResponsiveInverted)
  },

  beforeDestroy () {
    window.removeEventListener('resize', this.onResponsiveInverted)
  },

  methods: {
    showMenu () {
      this.$store.state.menu = !this.$store.state.menu
    },

    onClick () {
      //
    },

    onResponsiveInverted () {
      if (window.innerWidth < 980) {
        this.responsive = true
        this.responsiveInput = false
      } else {
        this.responsive = false
        this.responsiveInput = true
      }
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
