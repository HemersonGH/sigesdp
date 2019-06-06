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
                  v-model='user.email'
                  v-validate="'required|email'"
                  :error-messages="errors.collect('email')"
                  data-vv-name='email'
                  data-vv-as='Email'
                )
                v-text-field(
                  label='Senha'
                  color='#2196f3'
                  type='password'
                  v-model='user.senha'
                  v-validate="'required'"
                  :error-messages="errors.collect('password')"
                  data-vv-name='password'
                  data-vv-as='Senha'
                )
                v-btn.white--text.style-button(
                  color='#2196f3'
                  @click='login'
                ) Entrar
                  v-icon(
                    right
                  ) mdi-login
            div.style-div
              span.align-left Redefinir senha
              router-link(
                to='/cadastrar-usuario'
              )
                span.align-right Criar conta
      SnackBar(
        :data='snackbarCreateUser'
      )
      SnackBar(
        :data='snackbarLogin'
      )
</template>

<script>
import { mapActions, mapGetters } from 'vuex'
import Card from '@/components/shared/Card.vue'
import TheCard from '@/components/shared/TheCard.vue'
import SnackBar from '@/components/shared/SnackBar.vue'

export default {
  name: 'Login',

  $_veeValidate: {
    validator: 'new'
  },

  components: {
    Card,
    TheCard,
    SnackBar
  },

  data () {
    return {
      user: {
        email: 'hemersonel@gmail.com',
        senha: 'Eueueueueueu'
      },
      snackbarCreateUser: {
        icon: 'mdi-check-outline',
        message: 'Usuário cadastrado com sucesso.',
        value: false,
        color: 'success'
      },
      snackbarLogin: {
        icon: 'mdi-alert-circle-outline',
        message: 'Email e/ou senha inválidos.',
        value: false,
        color: 'error'
      }
    }
  },

  methods: {
    alteraSideMenuUsuario () {
      this.$store.commit('usuario/SET_USUARIO_BOOLEN_LOGADO')
    },

    login () {
      this.$validator.validateAll().then(sucess => {
        if (sucess) {
          // const myPassEncrypt = sjcl.hash.sha256.hash(this.novoUsuario.usuario.senha)
          // const myPassEncryptHash = sjcl.codec.hex.fromBits(myPassEncrypt)
          // this.novoUsuario.usuario.senha = myPassEncryptHash
          // this.auth(this.user)
          this.getUsuario(this.user.email).then((response) => {
            this.$store.commit('usuario/SET_USUARIO_LOGADO', response)
            this.alteraSideMenuUsuario()
            this.$router.push({
              name: 'alunos'
            })
          }).catch((erro) => {
            this.snackbarLogin.value = true
          })
        } else {
          this.snackbarLogin.value = true
        }
      })
    },

    ...mapActions({
      auth: 'auth/authenticate',
      getUsuario: 'usuario/getUsuario'
    })
  },

  computed: {
    ...mapGetters({
      userAuth: 'auth/user'
    })
  },

  created () {
    if (this.$route.params.showMessage) {
      this.snackbarCreateUser.value = this.$route.params.showMessage
    }
  }
}
</script>

<style scoped>
.style-button {
  width: 100%;
  font-weight: bold !important;
  font-size: 100%;
}

.style-div {
  padding-top: 15px;
  padding-bottom: 30px;
  font-weight: 400;
}

.align-left {
  float: left;
  color: #2196f3;
  cursor: pointer;
}

.align-right {
  float: right;
  color: #2196f3;
  cursor: pointer;
}
</style>
