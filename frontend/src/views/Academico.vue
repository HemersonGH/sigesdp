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
          material-stats-card(
            :color='item.colorCard'
            :icon='item.icon'
            :value='item.title'
            :sub-text='item.text'
            :sub-text-color='item.colorSubText'
            @click='onClick'
          )
        //- v-flex(
        //-   md12
        //-   lg6
        //- )
        //-   material-card(
        //-     color='silver'
        //-     title='Employee Stats'
        //-     text='New employees on 15th September, 2016'
        //-   )
        //- v-flex(
        //-   md12
        //-   lg6
        //- )
        //-   material-card(
        //-     color='blue'
        //-     title='Employee Stats'
        //-     text='New employees on 15th September, 2016'
        //-   )
</template>

<script>
export default {
  name: 'Academico',

  data () {
    return {
      itensCard: [
        {
          title: 'Docentes',
          text: 'Acesse as páginas públicas dos docentes da UFLA.',
          colorCard: '#2CBF36',
          icon: 'mdi-account-multiple',
          colorSubText: 'text-sucess'
        },
        {
          title: 'Departamentos',
          text: 'Conheça os departamentos da UFLA.',
          colorCard: '#3169B3',
          icon: 'mdi-domain',
          colorSubText: 'text-sucess'
        },
        {
          title: 'Publicações',
          text: 'Consulte as publicações dos discentes.',
          colorCard: '#B836B6',
          icon: 'mdi-book-open',
          colorSubText: 'text-sucess'
        }
      ]
    }
  },

  methods: {
    onClick () {
      console.log('Cliquei no card')
    }
  }
}
</script>

<style>
</style>
