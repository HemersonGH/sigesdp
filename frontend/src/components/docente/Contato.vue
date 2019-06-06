<template lang="pug">
  v-card.padding-top
    v-card-title.align
      v-icon(
        color='#2b2b2b'
        left
      ) mdi-file-document-box
      h4.style-tittle Contato
    v-divider.mx-3
    v-card-text
      v-container.padding(
        grid-list-md
        fluid
      )
        v-layout(
          align-start
          justify-start
          row
          wrap
          fill-height
        )
          v-flex.padding(
            xs12
            sm12
            md12
          )
            h5.font-weight-label Sala:
              span.style-sub-title {{ data.sala }}
            h5.font-weight-label Telefone/Ramal:
              span.style-sub-title {{ data.telefone }}
            h5.font-weight-label Email:
              span.style-sub-title {{ data.usuario.email }}
</template>

<script>
export default {
  name: 'Contato',

  props: {
    data: {
      type: [Object, Array],
      required: true
    }
  }
}
</script>

<style scoped>
.style-tittle {
  margin: 0px !important;
  font-weight: 700 !important;
  color: #2b2b2b;
}

.font-weight-label {
  font-weight: 500 !important;
}

.padding {
  padding-top: 0px !important;
  padding-bottom: 0px !important;
}

.style-sub-title {
  padding-left: 10px;
  font-weight: 300;
  font-size: calc(1.0625rem - 0.0825rem);
}

.padding-top {
  margin-top: 15px;
}

.align {
  align-items: end;
}
</style>
