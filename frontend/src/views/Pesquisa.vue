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
          colorCard: '#BC2121',
          icon: 'mdi-account-multiple',
          route: '/pesquisa/pesquisadores'
        },
        {
          title: 'Iniciação Científica',
          text: 'Conheça os nossos bolsistas.',
          colorCard: '#009194',
          icon: 'mdi-file-find',
          route: '/pesquisa/iniciacao-cientifica'
        },
        {
          title: 'Bases de Pesquisas',
          text: 'Consulte as bases de pesquisa atuantes na UFLA.',
          colorCard: '#F5DE31',
          icon: 'mdi-database',
          route: ''
        }
      ]
    }
  }
}
</script>

<style scoped>
</style>
