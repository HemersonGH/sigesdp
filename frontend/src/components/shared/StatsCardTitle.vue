<template lang="pug">
  Card.v-card--shared-stats(
    v-bind='$attrs'
    v-on='$listeners'
  )
    div.text-xs-center
      h3.title.display-1 {{ title }}
</template>

<script>
import Card from '@/components/shared/Card.vue'

export default {
  name: 'StatsCardTitle',

  inheritAttrs: false,

  components: {
    Card
  },

  props: {
    ...Card.props,

    title: {
      type: String,
      default: undefined
    }
  }
}
</script>

<style lang="scss">
.v-card--shared-stats {
  display: flex;
  flex-wrap: wrap;
  position: relative;

  .v-offset {
    display: inline-block;
    flex: 0 1;
    margin-top: 0;
    margin-left: 0;
    margin-right: auto;
    margin-bottom: 0 !important;
    max-width: auto;
    padding: 0 16px 0;
  }

  .v-card {
    border-radius: 4px;
    flex: 0 1 auto;
  }

  .v-card__text {
    display: inline-block;
    position: absolute;
    top: 0;
    right: 0;
    width: 100%;
  }

  .v-card__actions {
    flex: 1 0 100%;
  }
}
</style>
