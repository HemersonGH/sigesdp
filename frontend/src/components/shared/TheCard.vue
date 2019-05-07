<template lang="pug">
  StatsCard.styleMouse(
    :color='colorCard'
    :icon='iconCard'
    :value='titleCard'
    :sub-text='textCard'
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
import StatsCard from '@/components/shared/StatsCard.vue'

export default {
  name: 'TheCard',

  components: {
    StatsCard
  },

  props: {
    colorCard: {
      type: String,
      required: true
    },
    iconCard: {
      type: String,
      required: true
    },
    titleCard: {
      type: String,
      required: true
    },
    textCard: {
      type: String,
      required: true
    }
  }
}
</script>

<style scoped>
.styleMouse{
  cursor: pointer;
}

.v-card--shared-stats.v-card .v-card__actions .caption {
    color: #000;
}

</style>
