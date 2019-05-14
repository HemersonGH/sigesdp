<template lang="pug">
  div
    v-container(
      fill
      grid-list-xl
    )
      v-layout(
        align-center
        justify-center
        row
        fill-height
      )
        v-flex(
          sm6
          xs12
          md6
          lg6
        )
          Card.text-xs-center(
            color='#2196f3'
            title='Login'
            text='Sistema de Gestão do Docente/Professor'
            styleTitleDataTable='title-data-table'
            full-width
            elevation='5'
          )
            div
              v-text-field(
                label='Email'
                color='#2196f3'
                type='email'
              )
              v-text-field(
                label='Senha'
                color='#2196f3'
                type='password'
              )
            div
              v-btn.style-button(
                color='#2196f3'
              ) Entrar
                v-icon mdi-login
            div.padding
              v-layout(
                row
                align-center
                justify-space-between
                fill-height
              )
                p.style-text Redefinir senha
                p.style-text Criar conta

</template>

<script>
import Card from '@/components/shared/Card.vue'
import TheCard from '@/components/shared/TheCard.vue'

export default {
  name: 'Login',

  components: {
    Card,
    TheCard
  },

  data () {
    return {
      item: [
        {
          title: 'Docentes',
          text: 'Acesse as páginas publicas dos docentes da UFLA.',
          colorCard: '#2CBF36',
          icon: 'mdi-account-multiple',
          route: '/academico/docentes'
        }
      ]
    }
  }
}
</script>

<style scoped>
.layout {
  display: flex;
}

.align {
  align-items: center;
  justify-content: center;
  justify-items: center;
  justify-self: center;
}

.color-text{
  color: white;
}

.style-button{
  width: 100%;
}

.padding {
  padding-top: 5%;
}

.style-text {
  color: #2196f3;
  cursor: pointer;
}
</style>
