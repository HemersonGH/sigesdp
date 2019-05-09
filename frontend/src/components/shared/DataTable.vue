<template lang="pug">
  v-data-table(
    :headers='headers'
    :items='contentTable'
    prev-icon='mdi-menu-left'
    next-icon='mdi-menu-right'
    sort-icon='mdi-menu-down'
  )
    template(
      slot='headerCell'
      slot-scope='{ header }'
    )
      span.subheading.font-weight-bold.text--darken-3(
        v-text='header.text'
      )
    template(
      slot='items'
      slot-scope='{ item }'
    )
      td(
        v-for='(column, i) in columnsTable.column'
        :key='i'
        :class='columnsTable.class[i]'
      ) {{ item[column] }}
      td.text-xs-right(
      )
        v-tooltip(
          top
          content-class='top'
        )
          template(
            v-slot:activator='{ on }'
          )
            v-btn.v-btn--simple.no-margin(
              v-on='on'
              slot='activator'
              icon
              @click.stop='viewDetails(item)'
            )
              v-icon.no-margin(
                :color='colorIcon'
              ) {{ icon }}
          span {{ iconAction }}
</template>

<script>
export default {
  name: 'DataTable',

  props: {
    headers: {
      type: Array,
      required: true
    },

    contentTable: {
      type: Array,
      required: true
    },

    columnsTable: {
      type: Object,
      required: true
    },

    icon: {
      type: String,
      default: 'mdi-eye'
    },

    colorIcon: {
      type: String,
      default: '#707070'
    },

    iconAction: {
      type: String,
      default: 'Visualizar'
    }
  },

  data () {
    return {
    }
  },

  methods: {
    viewDetails (item) {
      this.$emit('openModal', item)
    }
  }
}
</script>

<style scoped>
.no-margin {
  margin-top: 0;
  margin-bottom: 0;
}
</style>
