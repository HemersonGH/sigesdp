import Vue from 'vue'
import Router from 'vue-router'
import Academico from '@/views/Academico.vue'
import Departamento from '@/views/Departamento.vue'
import Login from '@/components/shared/Login.vue'

Vue.use(Router)

export default new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'home',
      component: Academico,
      title: 'Acadêmico'
    },
    {
      path: '/login',
      name: 'login',
      component: Login,
      title: 'Login'
    },
    {
      path: '/academico',
      name: 'academico',
      component: Academico,
      title: 'Acadêmico'
    },
    {
      path: '/academico/departamentos',
      name: 'departamento',
      component: Departamento,
      title: 'Departamento'
    }
  ]
})
