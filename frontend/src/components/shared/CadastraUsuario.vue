<template lang="pug">
  div
    v-container.padding-top(
      fill
      grid-list-xl
    )
      v-layout(
        align-center
        justify-center
        row
        fill-height
      )
        v-flex.padding-top(
          sm12
          xs12
          md12
          lg12
        )
          Card.text-xs-center(
            color='#2196f3'
            title='Cadastro de Usuário'
            styleTitleDataTable='title-data-table'
            full-width
            elevation='3'
          )
            form(
              @submit.prevent='cadastrar()'
            )
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
                  )
                    h4.font-weight.text-xs-left Dados Pessoais
                    v-divider
                  v-flex.padding(
                    xs12
                    sm6
                    md6
                  )
                    v-text-field(
                      v-model='novoUsuario.nome'
                      label='Nome * '
                      color='#2196f3'
                      v-validate="'required'"
                      :error-messages="errors.collect('nome')"
                      data-vv-name='nome'
                      data-vv-as='Nome'
                    )
                  v-flex.padding(
                    xs12
                    sm6
                    md6
                  )
                    v-select.font-weight-select(
                      v-model='novoUsuario.departamento.id'
                      label='Selecione um departamento *'
                      color='#2196f3'
                      :items='departamentos.data'
                      item-text='nome'
                      item-value='id'
                      no-data-text='Não há dados.'
                      v-validate="'required'"
                      :error-messages="errors.collect('departamento')"
                      data-vv-name='departamento'
                      data-vv-as='Departamento'
                      clearable
                    )
                  v-flex.padding(
                    xs12
                    sm6
                    md6
                  )
                    v-text-field(
                      v-model='novoUsuario.usuario.email'
                      label='Email *'
                      color='#2196f3'
                      v-validate="'required|email'"
                      :error-messages="errors.collect('email')"
                      data-vv-name='email'
                      data-vv-as='Email'
                      ref='email'
                    )
                  v-flex.padding(
                    xs12
                    sm6
                    md6
                  )
                    v-text-field(
                      v-model='confirmEmail'
                      label='Confirmar email *'
                      color='#2196f3'
                      v-validate="'required|confirmed:email'"
                      :error-messages="errors.collect('confirmEmail')"
                      data-vv-name='confirmEmail'
                      data-vv-as='Confirmar email'
                    )
                  v-flex.padding(
                    xs12
                    sm6
                    md6
                  )
                    v-text-field(
                      v-model='novoUsuario.usuario.senha'
                      label='Senha *'
                      color='#2196f3'
                      v-validate="'required|min:6'"
                      :error-messages="errors.collect('password')"
                      data-vv-name='password'
                      data-vv-as='Senha'
                      hint='Pelo menos 6 caracteres.'
                      :append-icon="showPass ? 'visibility' : 'visibility_off'"
                      @click:append='showPass = !showPass'
                      :type="showPass ? 'text' : 'password'"
                      ref='senha'
                    )
                  v-flex.padding(
                    xs12
                    sm6
                    md6
                  )
                    v-text-field(
                      v-model='confirmSenha'
                      label='Confirmar senha *'
                      color='#2196f3'
                      v-validate="'required|confirmed:senha'"
                      :error-messages="errors.collect('confirmSenha')"
                      data-vv-name='confirmSenha'
                      data-vv-as='Confirmar senha'
                      :append-icon="showPassConfirm ? 'visibility' : 'visibility_off'"
                      @click:append='showPassConfirm = !showPassConfirm'
                      :type="showPassConfirm ? 'text' : 'password'"
                    )
                  v-flex(
                    xs12
                    sm12
                    md12
                  )
                    h4.font-weight.text-xs-left Acadêmico
                    v-divider
                  v-flex.padding(
                    xs12
                    sm12
                    md12
                  )
                    v-text-field(
                      v-model='novoUsuario.formacaoAcademica'
                      label='Formação acadêmica/profissional *'
                      color='#2196f3'
                      v-validate="'required'"
                      :error-messages="errors.collect('formacaoAcademica')"
                      data-vv-name='formacaoAcademica'
                      data-vv-as='Formação acadêmica/profissional'
                    )
                  v-flex.padding(
                    xs12
                    sm12
                    md12
                  )
                    v-select(
                      v-model='novoUsuario.areaConhecimento.id'
                      label='Selecione uma área de conhecimento *'
                      color='#2196f3'
                      :items='areasConhecimento.data'
                      item-text='nome'
                      item-value='id'
                      no-data-text='Não há dados.'
                      v-validate="'required'"
                      :error-messages="errors.collect('areaConhecimento')"
                      data-vv-name='areaConhecimento'
                      data-vv-as='Área de Conhecimento'
                      clearable
                    )
                  v-flex.padding(
                    xs12
                    sm12
                    md12
                  )
                    v-text-field(
                      v-model='novoUsuario.curriculoLattes'
                      label='Currículo Lattes *'
                      color='#2196f3'
                      v-validate="'required'"
                      :error-messages="errors.collect('curriculoLattes')"
                      data-vv-name='curriculoLattes'
                      data-vv-as='Currículo Lattes'
                    )
                  v-flex(
                    xs12
                    sm12
                    md12
                  )
                    h4.font-weight.text-xs-left Endereço
                    v-divider
                  v-flex.padding(
                    xs12
                    sm6
                    md6
                  )
                    v-text-field(
                      v-model='novoUsuario.telefone'
                      label='Telefone/Ramal *'
                      color='#2196f3'
                      v-validate="'required'"
                      :error-messages="errors.collect('telefone')"
                      data-vv-name='telefone'
                      data-vv-as='Telefone/Ramal'
                    )
                  v-flex.padding(
                    xs12
                    sm6
                    md6
                  )
                    v-text-field(
                      v-model='novoUsuario.sala'
                      label='Sala *'
                      color='#2196f3'
                      v-validate="'required'"
                      :error-messages="errors.collect('sala')"
                      data-vv-name='sala'
                      data-vv-as='Sala'
                    )
              v-layout(
                align-center
                justify-space-between
                row
                fill-height
              )
                v-btn.style-btn-common.style-button-voltar(
                  color='#2196f3'
                  to='/login'
                )
                  v-icon mdi-arrow-left
                  | &nbsp Voltar
                v-btn.style-btn-common.style-button-cadastrar(
                  color='#2196f3'
                  @click='cadastrar'
                ) Cadastrar &nbsp
                  v-icon mdi-plus
              SnackBar(
                :data='snackbar'
              )

</template>

<script>
import { mapActions, mapGetters } from 'vuex'
import Card from '@/components/shared/Card.vue'
import TheCard from '@/components/shared/TheCard.vue'
import SnackBar from '@/components/shared/SnackBar.vue'
import sjcl from 'sjcl'

export default {
  name: 'CadastraUsuario',

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
      novoUsuario: {
        nome: '',
        formacaoAcademica: '',
        usuario: {
          email: '',
          senha: ''
        },
        departamento: {
          id: null
        },
        areaConhecimento: {
          id: null
        },
        curriculoLattes: '',
        telefone: '',
        sala: ''
      },
      showPass: false,
      showPassConfirm: false,
      confirmEmail: '',
      confirmSenha: '',
      snackbar: {
        icon: 'mdi-alert-circle-outline',
        message: 'Verifique os campos obrigatórios.',
        value: false,
        color: 'error'
      }
    }
  },

  methods: {
    cadastrar () {
      this.$validator.validateAll().then(sucess => {
        if (sucess) {
          const myPassEncrypt = sjcl.hash.sha256.hash(this.novoUsuario.usuario.senha)
          const myPassEncryptHash = sjcl.codec.hex.fromBits(myPassEncrypt)
          this.novoUsuario.usuario.senha = myPassEncryptHash
          this.createUsuario(this.novoUsuario)
          this.$router.push({
            name: 'login',
            params: {
              showMessage: true
            }
          })
        } else {
          this.snackbar.value = true
        }
      })
    },

    ...mapActions({
      createUsuario: 'usuario/createUsuario',
      getDepartamentos: 'departamento/getDepartamentos',
      getAreasConhecimento: 'areasConhecimento/getAreasConhecimento'
    })
  },

  computed: {
    ...mapGetters({
      usuario: 'usuario/usuario',
      departamentos: 'departamento/departamentos',
      areasConhecimento: 'areasConhecimento/areaConhecimento'
    })
  },

  created () {
    this.getDepartamentos()
    this.getAreasConhecimento()
  }
}
</script>

<style scoped>
.style-btn-common {
  color: white;
  font-size: 90%;
  font-weight: 550 !important;
}

.style-button-voltar {
  margin-left: 1%;
}

.style-button-cadastrar {
  margin-right: 1%;
}

.padding {
  padding-top: 0px !important;
  padding-bottom: 0px !important;
}

.padding-top {
  padding-top: 0px !important;
}

.font-weight {
  font-weight: 500 !important;
}
</style>
