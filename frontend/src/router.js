import Vue from 'vue'
import Router from 'vue-router'
// import store from './store'

import Alunos from '@/views/Alunos.vue'
import Docentes from '@/views/Docentes.vue'
import Pesquisa from '@/views/Pesquisa.vue'
import Academico from '@/views/Academico.vue'
import Disciplinas from '@/views/Disciplinas.vue'
import Publicacoes from '@/views/Publicacoes.vue'
import Departamento from '@/views/Departamento.vue'
import ProjetosPesquisa from '@/views/ProjetosPesquisa.vue'

import Login from '@/components/shared/Login.vue'
import CadastraUsuario from '@/components/shared/CadastraUsuario.vue'
import DetalhesDocentes from '@/components/docente/DetalhesDocente.vue'

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
    },
    {
      path: '/academico/docente/:id',
      name: 'detalhesDocentes',
      component: DetalhesDocentes,
      title: 'Detalhes do Docentes',
      public: true
    },
    {
      path: '/pesquisa',
      name: 'pesquisa',
      component: Pesquisa,
      title: 'Pesquisa',
      public: true
    },
    {
      path: '/cadastrar-usuario',
      name: 'cadastrarUsuario',
      component: CadastraUsuario,
      title: 'Cadastro de Usuário',
      public: true
    },
    {
      path: '/alunos',
      name: 'alunos',
      component: Alunos,
      title: 'Alunos',
      public: true
    },
    {
      path: '/projetos-pesquisa',
      name: 'pesquisaDocente',
      component: ProjetosPesquisa,
      title: 'Projeto de Pesquisa',
      public: true
    },
    {
      path: '/disciplinas',
      name: 'disciplinas',
      component: Disciplinas,
      title: 'Disciplinas',
      public: true
    },
    {
      path: '/publicacoes',
      name: 'publicacoes',
      component: Publicacoes,
      title: 'Publicações',
      public: true
    }
  ]
})

// router.beforeEach((to, from, next) => {
//   if (to.path !== '/login') {
//     next()
//   } else {
//     store.dispatch('auth/getAuthUser').then(() => {
//       next()
//     }).catch(() => {
//       next('/login')
//     })
//   }
// })

export default router
