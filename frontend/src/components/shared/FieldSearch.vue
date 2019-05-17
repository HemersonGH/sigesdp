<template lang="pug">
  v-layout(
    justify-end
    row
  )
    v-flex(
      md4
      sm4
    )
      v-text-field.padding(
        v-model='search'
        @input='valueSearch(search)'
        append-icon='search'
        label='Pesquise'
        single-line
        hide-details
        :color='colorBottomFieldSearch'
      )
</template>

<script>
export default {
  name: 'FieldSearch',

  data () {
    return {
      search: ''
    }
  },

  props: {
    colorBottomFieldSearch: {
      type: String,
      default: ''
    }
  },

  methods: {
    valueSearch (search) {
      this.$emit('valueSearch', search)
    }
  }
}
</script>

<style scoped>
.primary--text {
  caret-color: black !important;
}

.padding {
  padding-bottom: 2%;
}
</style>
