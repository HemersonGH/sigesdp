<template lang="pug">
  v-data-table(
    :headers='headers'
    :items='contentTable'
    prev-icon="mdi-menu-left"
    next-icon="mdi-menu-right"
    sort-icon="mdi-menu-down"
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
        v-for='(column, i) in item'
        :key='i'
      ) {{ `${item}.${column}` }}
            td.text-xs-left {{ item.nome }}
      td {{ item.sigla }}
      td {{ item.chefe }}
      td.text-xs-right
        v-tooltip(
          top
          content-class='top'
        )
          v-btn.v-btn--simple(
            slot='activator'
            icon
          )
            v-icon(
              :color='colorIcon'
            ) {{ icon }}
          span {{ iconAction }}
</template>

<script>
export default {
  name: 'DataTable',

  props: {
    headers: {
      type: Array
    },

    contentTable: {
      type: Array
    },

    columnsTable: {
      type: Array
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
    },

    styletitleDataTable: {
      type: String,
      default: 'title'
    }
  }
}
</script>

<style scoped>
</style>
