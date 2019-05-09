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
              @click='viewDetailsDepartament(item)'
            )
              v-icon.no-margin(
                :color='colorIcon'
              ) {{ icon }}
          span {{ iconAction }}
      Dialog(
        :dialog='dialog'
        :contentDialog='contentDialog'
      )
</template>

<script>
import Dialog from '@/components/shared/Dialog.vue'

export default {
  name: 'DataTable',

  components: {
    Dialog
  },

  props: {
    headers: {
      type: Array
    },

    contentTable: {
      type: Array
    },

    columnsTable: {
      type: Object
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

    dialog: {
      type: Object,
      required: false
    },

  },

  data () {
    return {
      contentDialog: null
    }
  },

  methods: {
    viewDetailsDepartament (item){
      console.log(item)
      this.contentDialog = item
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
