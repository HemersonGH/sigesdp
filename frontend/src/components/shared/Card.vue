<template lang="pug">
  v-card(
    v-bind='$attrs'
    :style='styles'
    v-on='$listeners'
  )
    helper-offset(
      v-if='hasOffset'
      :inline='inline'
      :full-width='fullWidth'
      :offset='offset'
    )
      v-card.v-card--shared__header(
        v-if='!$slots.offset'
        :color='color'
        :class='`elevation-${elevation}`'
        dark
      )
        slot(
          v-if='!title && !text'
          name='header'
        )
        span(
          v-else
        )
          v-img.background(
            v-if='logoUfla'
            :src='imgLogoUfla'
            height='150'
            contain
          )
          h4.font-weight-light.mb-2(
            v-text='title'
            :class='styleTitleDataTable'
          )
          p.category(
            v-text='text'
          )
      slot(
        v-else
        name='offset'
      )
    v-card-text
      slot
    v-divider(
      v-if='$slots.actions'
      class='mx-3'
    )
    v-card-actions(
      v-if='$slots.actions'
    )
      slot(
        name='actions'
      )
</template>

<script>
import imgLogoUfla from '@/assets/images/svg_ufla_colorida_chapada.svg'

export default {
  name: 'Card',

  inheritAttrs: false,

  props: {
    color: {
      type: String,
      default: 'secondary'
    },

    elevation: {
      type: [Number, String],
      default: 10
    },

    inline: {
      type: Boolean,
      default: false
    },

    fullWidth: {
      type: Boolean,
      default: false
    },

    offset: {
      type: [Number, String],
      default: 24
    },

    title: {
      type: String,
      default: undefined
    },

    text: {
      type: String,
      default: undefined
    },

    styleTitleDataTable: {
      type: String,
      default: 'title'
    },

    logoUfla: {
      type: Boolean,
      default: false
    }
  },
  data () {
    return {
      imgLogoUfla: imgLogoUfla
    }
  },

  computed: {
    hasOffset () {
      return this.$slots.header ||
        this.$slots.offset ||
        this.title ||
        this.text
    },

    styles () {
      if (!this.hasOffset) {
        return null
      }

      return {
        marginBottom: `${this.offset}px`,
        marginTop: `${this.offset * 2}px`
      }
    }
  }
}
</script>

<style lang="scss">
.v-card--material {
  &__header {
    &.v-card {
      border-radius: 4px;
    }
  }
}

.background {
  background: white;
  border-radius: 30px;
}
</style>
