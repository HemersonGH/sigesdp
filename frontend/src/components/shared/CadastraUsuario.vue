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
            color='white'
            title='Cadastro de usuário'
            full-width
            elevation='3'
          )
            form(
              @submit.prevent='login()'
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
                      label='Nome * '
                      color='#2196f3'
                      v-model='nome'
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
                    v-select(
                      color='#2196f3'
                      placeholder='Selecione um departamento *'
                      v-model='selectDepartamento'
                      :items='departamentos'
                      item-text='nome'
                      item-value='id'
                      v-validate="'required'"
                      :error-messages="errors.collect('departamento')"
                      no-data-text='Não há dados.'
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
                      label='Email *'
                      color='#2196f3'
                      v-model='email'
                      v-validate="'required|email'"
                      :error-messages="errors.collect('email')"
                      data-vv-name='email'
                      data-vv-as='Email'
                    )
                  v-flex.padding(
                    xs12
                    sm6
                    md6
                  )
                    v-text-field(
                      label='Senha *'
                      color='#2196f3'
                      type='password'
                      v-model='password'
                      v-validate="'required'"
                      :error-messages="errors.collect('password')"
                      data-vv-name='password'
                      data-vv-as='Senha'
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
                    sm6
                    md6
                  )
                    v-text-field(
                      label='Nome * '
                      color='#2196f3'
                      v-model='nome'
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
                    v-select(
                      color='#2196f3'
                      placeholder='Selecione um departamento *'
                      v-model='selectDepartamento'
                      :items='departamentos'
                      item-text='nome'
                      item-value='id'
                      v-validate="'required'"
                      :error-messages="errors.collect('departamento')"
                      no-data-text='Não há dados.'
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
                      label='Email *'
                      color='#2196f3'
                      v-model='email'
                      v-validate="'required|email'"
                      :error-messages="errors.collect('email')"
                      data-vv-name='email'
                      data-vv-as='Email'
                    )
                  v-flex.padding(
                    xs12
                    sm6
                    md6
                  )
                    v-text-field(
                      label='Senha *'
                      color='#2196f3'
                      type='password'
                      v-model='password'
                      v-validate="'required'"
                      :error-messages="errors.collect('password')"
                      data-vv-name='password'
                      data-vv-as='Senha'
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
                      label='Nome * '
                      color='#2196f3'
                      v-model='nome'
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
                    v-select(
                      color='#2196f3'
                      placeholder='Selecione um departamento *'
                      v-model='selectDepartamento'
                      :items='departamentos'
                      item-text='nome'
                      item-value='id'
                      v-validate="'required'"
                      :error-messages="errors.collect('departamento')"
                      no-data-text='Não há dados.'
                      data-vv-name='departamento'
                      data-vv-as='Departamento'
                      clearable
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

</template>

<script>
import Card from '@/components/shared/Card.vue'
import TheCard from '@/components/shared/TheCard.vue'

export default {
  name: 'CadastraUsuario',

  $_veeValidate: {
    validator: 'new'
  },

  components: {
    Card,
    TheCard
  },

  data () {
    return {
      camposFormulario: {
        nome: '',
        selectDepartamento: null,
        email: '',
        password: ''
      }
    }
  },

  methods: {
    cadastrar () {
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

.padding-bottom {
  padding-bottom: 0px !important;
}

.padding-top {
  padding-top: 0px !important;
}

.font-weight {
  font-weight: 500 !important;
}
</style>
