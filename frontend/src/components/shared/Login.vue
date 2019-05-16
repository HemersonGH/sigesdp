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
            form(
              @submit.prevent='login()'
            )
              div
                v-text-field(
                  label='Email'
                  color='#2196f3'
                  v-model='email'
                  v-validate="'required|email'"
                  :error-messages="errors.collect('email')"
                  data-vv-name='email'
                  data-vv-as='Email'
                )
                v-text-field(
                  label='Senha'
                  color='#2196f3'
                  type='password'
                  v-model='password'
                  v-validate="'required'"
                  :error-messages="errors.collect('password')"
                  data-vv-name='password'
                  data-vv-as='Senha'
                )
                v-btn.style-button(
                  color='#2196f3'
                  @click='login'
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
      email: '',
      password: ''
    }
  },

  methods: {
    login () {
      this.$validator.validateAll().then(sucess => {
        if (sucess) {
          console.log('Validator OK')
        }
      })
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
</style>
