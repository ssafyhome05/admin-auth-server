import { createRouter, createWebHistory } from 'vue-router'
import LoginView from '../views/LoginView.vue'
import SignupView from '../views/SignupView.vue'
import SuccessView from '../views/SuccessView.vue'

const routes = [
  {
    path: '/login',
    name: 'login',
    component: LoginView
  },
  {
    path: '/signup',
    name: 'signup',
    component: SignupView
  },
  {
    path: '/',
    name: 'success',
    component: SuccessView
  }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router
