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
          Card(
            color='white'
            title=' '
            text=' '
            full-width
            elevation='5'
            :logoUfla='true'
          )
            v-form(
              @submit.prevent='login()'
            )
              div
                v-text-field(
                  label='Email'
                  name="email"
                  color='#2196f3'
                  type='email'
                  autocomplete='off'
                  v-validate="'required|email'"
                  :error-messages="errors.collect('email')"
                  data-vv-name="Email"
                  required
                )
              div
                v-text-field(
                  label='Senha'
                  name='password'
                  color='#2196f3'
                  type='password'
                  autocomplete='off'
                  v-validate="'required'"
                  :error-messages="errors.collect('password')"
                  data-vv-name="Senha"
                  required
                )
              div
                v-btn.style-button(
                  color='#2196f3'
                  type='submit'
                ) Entrar
                  v-icon mdi-login
            div.style-div
              span.align-left Redefinir senha
              span.align-right Criar conta

</template>

<script>
import Card from '@/components/shared/Card.vue'
import TheCard from '@/components/shared/TheCard.vue'

export default {
  name: 'Login',

  $_veeValidate: {
    validator: 'new'
  },

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
  },

  methods: {
    login () {
      this.$validator.validateAll()
    },

    clear () {
      this.name = ''
      this.email = ''
      this.select = null
      this.checkbox = null
      this.$validator.reset()
    }
  }
}
</script>

<style scoped>
.style-button {
  width: 100%;
  font-weight: bold !important;
  font-size: 100%;
  color: white;
}

.style-div {
  padding-top: 15px;
  padding-bottom: 30px;
  color: #2196f3;
  font-weight: 400;
}

.align-left {
  float: left;
}

.align-right {
  float: right;
}

.error {
  color: red;
}
</style>
