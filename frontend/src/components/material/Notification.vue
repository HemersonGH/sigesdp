<template lang="pug">
  v-alert.v-alert--notification(
    v-bind='$attrs'
    :class='[`elevation-${elevation}`]'
    :value='value'
    v-on='$listeners'
  )
    slot
</template>

<script>
export default {
  name: 'Notification',

  inheritAttrs: false,

  props: {
    elevation: {
      type: [
        Number,
        String
      ],
      default: 6
    },
    value: {
      type: Boolean,
      default: true
    }
  }
}
</script>

<style>
.v-alert--notification {
  border-radius: 4px !important;
  border-top: none !important;
}
</style>
