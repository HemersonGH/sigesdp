import Vue from 'vue'
import Router from 'vue-router'
import store from './store'
import Academico from '@/views/Academico.vue'
import Departamento from '@/views/Departamento.vue'
import Login from '@/components/shared/Login.vue'
import Docentes from '@/views/Docentes.vue'

Vue.use(Router)

const router = new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'home',
      component: Academico,
      title: 'Acadêmico',
      public: true
    },
    {
      path: '/login',
      name: 'login',
      component: Login,
      title: 'Login',
      public: true
    },
    {
      path: '/academico',
      name: 'academico',
      component: Academico,
      title: 'Acadêmico',
      public: true
    },
    {
      path: '/academico/departamentos',
      name: 'departamento',
      component: Departamento,
      title: 'Departamento',
      public: true
    },
    {
      path: '/academico/docentes',
      name: 'docentes',
      component: Docentes,
      title: 'Docentes',
      public: true
    }
  ]
})

router.beforeEach((to, from, next) => {
  if (to.path === '/' || to.path === '/login' || to.path === '/academico' ||
      to.path === '/academico/departamentos' || to.path === '/academico/docentes') {
    next()
  } else {
    store.dispatch('auth/getAuthUser').then(() => {
      next()
    }).catch(() => {
      next('/login')
    })
  }
})

export default router
