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
  name: 'Academico',

  components: {
    TheCard
  },

  data () {
    return {
      itensCard: [
        {
          title: 'Docentes',
          text: 'Acesse as páginas publicas dos docentes da UFLA.',
          colorCard: '#11802C',
          icon: 'mdi-account-multiple',
          route: '/academico/docentes'
        },
        {
          title: 'Departamentos',
          text: 'Conheça os departamentos da UFLA.',
          colorCard: '#3169B3',
          icon: 'mdi-domain',
          route: '/academico/departamentos'
        },
        {
          title: 'Publicações',
          text: 'Consulte as publicações dos discentes.',
          colorCard: '#B836B6',
          icon: 'mdi-book-open',
          route: ''
        }
      ]
    }
  }
}
</script>

<style scoped>
</style>
