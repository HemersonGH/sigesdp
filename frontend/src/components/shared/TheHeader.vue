<template lang="pug">
  v-toolbar.style-toolbar(
    id='core-toolbar'
    flat
    prominent
  )
    v-spacer
    div(
      class='v-toolbar-title'
    )
      v-toolbar-title(
        class='tertiary--text font-weight-bold'
      )
        v-btn(
          v-if='responsive'
          class='default v-btn--simple'
          dark
          icon
          @click.stop='onClickBtn'
        )
          v-icon mdi-view-list
        | {{ title }}
    v-spacer
    v-toolbar-items
      v-flex(
        align-center
        layout
        py-2
      )
        router-link(
          v-ripple
          class='toolbar-items'
          to=''
        )
          v-btn(
            dark
            icon
            
          ) Login &nbsp
            v-icon(
              color='tertiary'
            ) mdi-login

    //- v-toolbar.style-toolbar(flat)
    //-   v-toolbar-items
    //-     img.logo(
    //-       src='@/assets/images/logo.png'
    //-     )
    //-   v-spacer
    //-   v-toolbar-title.style-title Sistema de Gestão do Docente/Professor
    //-   v-spacer
    //-   v-toolbar-items
    //-     ButtonTheHeader(
    //-       labelBtn='Login'
    //-     )
</template>

<script>
import ButtonTheHeader from '@/components/shared/ButtonTheHeader.vue'
import {
  mapMutations
} from 'vuex'

export default {
  name: 'TheHeader',

  components: {
    ButtonTheHeader
  },

  data () {
    return {
      title: 'Sistema de Gestão do Docente/Professor',
      responsive: false
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
    ...mapMutations('app', ['setDrawer', 'toggleDrawer']),

    onClickBtn () {
      this.setDrawer(!this.$store.state.app.drawer)
    },

    onClick () {
      //
    },

    onResponsiveInverted () {
      if (window.innerWidth < 980) {
        this.responsive = true
      } else {
        this.responsive = false
      }
    }

  }
}
</script>

<style scoped>
  .logo {
    margin-top: 2.5px;
    margin-bottom: 1.5px;
    height: 90%;
    width: 90%;
  }

  .style-toolbar {
    background-color: #2881aa;
    color: #ffffff;
  }

  .style-title {
    font-size: 3.4vh;
    color: #ffffff;
  }

  #core-toolbar a {
    text-decoration: none;
  }
</style>
