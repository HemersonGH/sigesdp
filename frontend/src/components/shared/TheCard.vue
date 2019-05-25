<template lang="pug">
  StatsCard.styleMouse(
    :color='colorCard'
    :icon='iconCard'
    :value='titleCard'
    :sub-text='textCard'
    :elevation='elevation'
  )
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
    },

    elevation: {
      type: [Number, String],
      default: 5
    },
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
