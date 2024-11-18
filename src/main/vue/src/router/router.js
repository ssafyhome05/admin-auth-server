import { createRouter, createWebHistory } from 'vue-router'
import LoginView from '../views/LoginView.vue'
import SignupView from '../views/SignupView.vue'
import ConsentView from '../views/ConsentView.vue'

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
    path: '/oauth2/consent',
    name: 'consent',
    component: ConsentView
  }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router
