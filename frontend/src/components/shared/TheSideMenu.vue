<template lang="pug">
  div
</template>

<script>
import { mapActions, mapGetters } from 'vuex'

export default {
  methods: {
    ...mapActions({
      getDepartamentos: 'departamento/getDepartamentos'
    })
  },

  computed: {
    ...mapGetters({
      departamentos: 'departamento/departamentos'
    })
  },

  created () {
    this.getDepartamentos()
  }
}
</script>

<style lang="scss" scoped>
</style>
