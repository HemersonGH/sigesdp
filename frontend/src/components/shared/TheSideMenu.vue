<template lang="pug">
  v-layout.ajust(
    row
  )
    v-flex(
      xs2
    )
      v-navigation-drawer.style-side(
        dark
        permanent
      )
        v-list
          v-list-tile(
            v-for="item in itensMenu"
            :key="item.title"
            @click=''
          )
            v-list-tile-action
              v-icon {{ item.icon }}
            v-list-tile-content.bold
              v-list-tile-title {{ item.title }}
    v-flex(
      xs10
    )
      slot(name='router')
</template>

<script>
import { mapActions, mapGetters } from 'vuex'

export default {
  data () {
    return {
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
  .ajust {
    height: calc(100% - 64px);
  }

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
</style>
