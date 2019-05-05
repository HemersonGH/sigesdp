import Vue from 'vue'
import Router from 'vue-router'
import Academico from '@/views/Academico.vue'

Vue.use(Router)

export default new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'academico',
      component: Academico,
      title: 'Acadêmico'
    },
    {
      path: '/academico',
      name: 'academico',
      component: Academico,
      title: 'Acadêmico'
    }
  ]
})
