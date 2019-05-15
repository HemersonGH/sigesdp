import axios from 'axios'
import router from '../router'

let instance; // eslint-disable-line

if (process.env.NODE_ENV === 'development') {
  instance = axios.create({
    baseURL: '/api'
  })
} else {
  instance = axios.create()
}

// Definindo o padrão de request como "application/json"
instance.defaults.headers.post['Content-Type'] = 'application/json'

// Criando um interceptor no axios para respostas de erro não ser a padrão do axios e sim a real resposta do servidor (i.e: erro.data)
axios.interceptors.response.use(response => response, (error) => {
  if (error.response.status === 401) {
    router.push('/login')
    return error.response
  }
  return error.response
})

export default instance
