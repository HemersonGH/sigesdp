<template lang="pug">
  v-dialog(
    max-width='600px'
    v-model='showDialog'
    :persistent='true'
    :scrollable='true'
  )
    v-card
      v-card-title.center
        span.headline {{ detailsDialog.title }}
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
              v-for='(labels, i) in detailsDialog.labels'
              :key='i'
            )
              h5.font-weight-bold.no-margin-bottom
                | {{ labels[0] }}:
              p {{ detailsDialog.itemDialog[labels[1]] }}
        v-divider.mx-3
        v-card-actions
          v-spacer
          v-btn.white--text.style-button(
            color='blue darken-1'
            @click='close()'
          ) Fechar
</template>

<script>
export default {
  name: 'Dialog',

  props: {
    detailsDialog: {
      type: Object,
      required: true
    },

    showDialog: {
      type: Boolean,
      required: true
    }
  },

  methods: {
    close () {
      this.$emit('close')
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

.style-button{
  font-weight: 450 !important;
}
</style>
