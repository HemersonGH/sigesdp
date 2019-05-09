<template lang="pug">
  v-layout(
    row
    justify-center
  )
    v-dialog(
      v-model='dialog'
      max-width='600px'
    )
      template(
        v-slot:activator='{ on }'
      )
        v-btn(
          small
          color='primary'
          dark
          v-on='on'
        ) Open Dialog
      v-card
        v-card-title.center
          span.headline {{ dialog.title }}
        v-divider.mx-3
        v-card-text.no-margin-top
          v-container(
            grid-list-md
          )
            v-layout(
              wrap
            )
              v-flex(
                xs12
                sm12
                md12
                v-for='(labels, i) in dialog.labels'
                :key='i'
              )
                h5.font-weight-bold.no-margin-bottom
                  | {{ labels }}:
                //- p {{ content }}
          v-divider.mx-3
          v-card-actions
            v-spacer
            v-btn.font-weight-bold(
              color='blue darken-1'
              @click='dialog = false'
            ) Fechar
</template>

<script>
export default {
  name: 'Dialog',

  props: {
    dialog: {
      type: Object,
      // required: true
    },

    contentDialog: {
      type: Object,
      // required: true
    }
  },

  data() {
    return {
      dialog: false
    }
  }
}
</script>

<style scoped>
.no-margin-bottom {
  margin-bottom: 0;
}

.no-margin-top{
  padding-top: 0;
}

.center {
  justify-content: center;
}
</style>