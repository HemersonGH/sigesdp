<template lang="pug">
  div
    v-container(
      fill-height
      fluid
      grid-list-xl
    )
      v-layout(
        wrap
      )
        v-flex(
          sm6
          xs12
          md6
          lg6
          v-for='(item, i) in itensCard'
          :key='i'
        )
          router-link(
            :to='item.route'
          )
            TheCard(
              :colorCard='item.colorCard'
              :iconCard='item.icon'
              :titleCard='item.title'
              :textCard='item.text'
              :elevation='0'
            )
</template>

<script>
import TheCard from '@/components/shared/TheCard.vue'

export default {
  name: 'Pesquisa',

  components: {
    TheCard
  },

  data () {
    return {
      itensCard: [
        {
          title: 'Pesquisadores',
          text: 'Consulte os pesquisadores da UFLA.',
          colorCard: '',
          icon: 'mdi-account-multiple',
          route: '/pesquisa/pesquisadores'
        },
        {
          title: 'Iniciação Científica',
          text: 'Conheça os nossos bolsistas.',
          colorCard: '#00999C',
          icon: 'mdi-file-find',
          route: '/academico/departamentos'
        },
        {
          title: 'Bases de Pesquisas',
          text: 'Consulte as bases de pesquisa atuantes na UFLA.',
          colorCard: '#545969',
          icon: 'mdi-database',
          route: '/academico/publicacoes'
        }
      ]
    }
  }
}
</script>

<style scoped>
</style>
