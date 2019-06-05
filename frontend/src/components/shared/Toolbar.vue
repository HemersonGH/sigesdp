<template lang="pug">
  v-toolbar(
    id='core-toolbar'
    flat
    prominent
  )
    div(v-if='responsive')
      v-toolbar-items
        v-flex(
          layout
          py-2
        )
          v-tooltip(
            bottom
            content-class='bottom'
          )
            template(
              v-slot:activator='{ on }'
            )
              v-btn(
                v-on='on'
                dark
                icon
                @click.stop='showMenu'
              )
                v-icon mdi-view-list
            span {{ menu == true ? 'Esconder menu lateral' : 'Exibir menu lateral' }}
    div(
      v-else
    )
      v-toolbar-items
        v-flex(
          layout
          py-2
        )
          v-btn(
            disabled
            icon
          )
    div.v-toolbar-title
      v-toolbar-title.font-weight-bold.white--text
          | {{ title }}
    div
      v-toolbar-items
        v-flex(
          align-center
          justify-end
          layout
          py-2
        )
          div.toolbar-items(
            v-if='!getValueUsuarioLogadoBool'
          )
            v-tooltip(
              bottom
              content-class='bottom'
            )
              template(
                v-slot:activator='{ on }'
              )
                v-btn.style-button(
                  v-on='on'
                  icon
                  to='/login'
                ) Login
                  v-icon mdi-login
              span Acessar o sistema
          div.toolbar-items(
            v-else
          )
            v-tooltip(
              bottom
              content-class='bottom'
            )
              template(
                v-slot:activator='{ on }'
              )
                v-btn.style-button(
                  v-on='on'
                  icon
                  @click='logout()'
                ) Logout
                  v-icon mdi-logout
              span Sair do sistema
</template>

<script>
import { mapGetters } from 'vuex'

export default {
  name: 'Toolbar',

  data () {
    return {
      title: 'Sistema de Gestão do Docente/Professor',
      responsive: false,
      drawer: false
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
      this.$store.commit('menu/SET_SIDE_MENU')
    },

    logout () {
      this.$store.commit('usuario/SET_USUARIO_BOOLEN_LOGADO')
      this.$router.push({
        name: 'academico'
      })
    },

    onResponsiveInverted () {
      if (window.innerWidth < 1264) {
        this.responsive = true
      } else {
        this.responsive = false
      }
    }
  },

  computed: {
    ...mapGetters({
      menu: 'menu/menu',
      usuarioLogadoBool: 'usuario/usuarioLogadoBool'
    }),

    getValueUsuarioLogadoBool: {
      get () {
        return this.usuarioLogadoBool
      },
      set () {
      }
    }
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
    color: white !important;
  }
</style>
