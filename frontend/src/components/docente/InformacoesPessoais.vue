<template lang="pug">
  v-card
    v-card-title.align
      v-icon mdi-account-box
      h4.style-tittle &nbsp Informações Pessoais
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
            h5.font-weight-label Nome:
              span.style-sub-title Fransical carvalho da silva
            h5.font-weight-label Curriculo Lates:
              span.style-sub-title http://www.caps.ufla.br/prof
            h5.font-weight-label Área Interesse:
              span.style-sub-title Inteligência Artificial
            h5.font-weight-label Formação Acadêmica/Profissional:
              span.style-sub-title Faculdade federal de bragança
</template>

<script>
export default {
  name: 'InformacoesPessoais'
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
  font-weight: 300;
  font-size: calc(1.0625rem - 0.0825rem);
}

.align {
  align-items: end;
}
</style>
