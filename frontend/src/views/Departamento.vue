<template lang="pug">
  v-container(
    fill-height
    fluid
    grid-list-xl
  )
    v-layout(
      justify-center
      wrap
    )
      v-flex(
        md12
      )
        Card(
          color='#3169B3'
          :title='title'
          :text='text'
          full-width
        )
          v-data-table(
            :headers='headers'
            :items='departamentos'
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
              td.text-xs-left {{ item.name }}
              td {{ item.sigla }}
              td {{ item.city }}
              td.text-xs-right
                v-tooltip(
                  top
                  content-class='top'
                )
                  v-btn(
                    slot='activator'
                    class='v-btn--simple'
                    color=''
                    icon
                  )
                    v-icon(
                      color='primary'
                    ) mdi-eye
                  span Edit
</template>

<script>
import Card from '@/components/shared/Card.vue'
import { mapActions, mapGetters } from 'vuex'

export default {
  name: 'Departamento',

  components: {
    Card
  },

  data () {
    return {
      title: 'Departamentos',
      text: 'Pesquise os departamentos da UFLA',
      headers: [
        {
          sortable: true,
          text: 'Nome',
          value: 'name',
          align: 'left'
        },
        {
          sortable: true,
          text: 'Sigla',
          value: 'sigla'
        },
        {
          sortable: true,
          text: 'City',
          value: 'city'
        },
        {
          sortable: false,
          text: 'Ações',
          value: 'salary',
          align: 'right'
        }
      ],
      departamentos: [
        {
          name: 'Dakota Rice',
          sigla: 'Niger',
          city: 'Oud-Tunrhout'
        },
        {
          name: 'Minerva Hooper',
          sigla: 'Curaçao',
          city: 'Sinaai-Waas'
        },
        {
          name: 'Sage Rodriguez',
          sigla: 'Netherlands',
          city: 'Overland Park'
        },
        {
          name: 'Philip Chanley',
          sigla: 'Korea, South',
          city: 'Gloucester'
        },
        {
          name: 'Doris Greene',
          sigla: 'Malawi',
          city: 'Feldkirchen in Kārnten'
        },
        {
          name: 'Mason Porter',
          sigla: 'Chile',
          city: 'Gloucester'
        },
        {
          name: 'Dakota Rice',
          sigla: 'Niger',
          city: 'Oud-Tunrhout'
        },
        {
          name: 'Minerva Hooper',
          sigla: 'Curaçao',
          city: 'Sinaai-Waas'
        },
        {
          name: 'Sage Rodriguez',
          sigla: 'Netherlands',
          city: 'Overland Park'
        },
        {
          name: 'Philip Chanley',
          sigla: 'Korea, South',
          city: 'Gloucester'
        },
        {
          name: 'Doris Greene',
          sigla: 'Malawi',
          city: 'Feldkirchen in Kārnten'
        },
        {
          name: 'Mason Porter',
          sigla: 'Chile',
          city: 'Gloucester'
        }
      ]
    }
  },

  methods: {
    //...mapActions({
    //  getDepartamentos: 'departamento/getDepartamentos'
    //})
  },

  computed: {
    //...mapGetters({
      //departamentos: 'departamento/departamentos'
    //})
  },

  created () {
    //this.getDepartamentos()
  }
}
</script>

<style scoped>
</style>
