<template lang="pug">
  Card.v-card--shared-stats(
    v-bind='$attrs'
    v-on='$listeners'
  )
    v-card.pa-4(
      slot='offset'
      :class='`elevation-${elevation}`'
      :color='color'
      dark
    )
      v-icon(
        size='40'
      ) {{ icon }}
    div.text-xs-right
      p.category.grey--text.font-weight-light(
        v-text='title'
      )
      h3.title.display-1 {{ value }}
        small {{ smallValue }}
    template(
      slot='actions'
    )
      v-icon.mr-2(
        :color='subIconColor'
        size='20'
      )  {{ subIcon }}
      span.caption(
        :class='subTextColor'
        v-text='subText'
      )
</template>

<script>
import Card from '@/components/shared/Card.vue'

export default {
  name: 'StatsCard',

  inheritAttrs: false,

  components: {
    Card
  },

  props: {
    ...Card.props,

    icon: {
      type: String,
      required: true
    },

    subIcon: {
      type: String,
      default: undefined
    },

    subIconColor: {
      type: String,
      default: undefined
    },

    subTextColor: {
      type: String,
      default: undefined
    },

    subText: {
      type: String,
      default: undefined
    },

    title: {
      type: String,
      default: undefined
    },

    value: {
      type: String,
      default: undefined
    },

    smallValue: {
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
