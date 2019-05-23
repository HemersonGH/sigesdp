<template lang="pug">
  v-card.padding-top
    v-card-title
      v-icon mdi-file-document-box
      h4.style-tittle &nbsp Contato
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
              span.style-sub-title 201 - 1º Andar
            h5.font-weight-label Telefone/Ramal:
              span.style-sub-title 1957
            h5.font-weight-label Email:
              span.style-sub-title fransciso@gmail.com
</template>

<script>
export default {
  name: 'Contato'
}
</script>

<style scoped>
.style-tittle {
  margin: 0px !important;
  font-weight: 700 !important;
  color: #6b6b6b;
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
  margin-top: 0px !important;
  font-weight: 300;
}

.padding-top {
  margin-top: 15px;
}
</style>
