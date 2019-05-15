import Vue from 'vue'
import './plugins/vuetify'
import App from './App.vue'
import router from './router'
import store from './store'
import axios from 'axios'
import VeeValidate, { Validator } from 'vee-validate'
import ptBr from 'vee-validate/dist/locale/pt_BR'
import VueAxios from 'vue-axios'
import i18n from '@/i18n'
import './components'

Vue.config.productionTip = false

Vue.use(VueAxios, axios)

Validator.localize('pt_BR', ptBr)

Vue.use(VeeValidate, {
  locale: 'pt_BR'
})

new Vue({
  i18n,
  router,
  store,
  render: h => h(App)
}).$mount('#app')
