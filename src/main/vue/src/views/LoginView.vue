<template>
  <div class="login">
    <h2>로그인</h2>
    <form @submit.prevent="handleLogin">
      <div class="form-group">
        <label for="username">아이디:</label>
        <input 
          type="text" 
          id="username" 
          v-model="username" 
          required
        >
      </div>
      
      <div class="form-group">
        <label for="password">비밀번호:</label>
        <input 
          type="password" 
          id="password" 
          v-model="password" 
          required
        >
      </div>

      <button type="submit">로그인</button>
    </form>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  name: 'LoginComponent',
  data() {
    return {
      username: '',
      password: ''
    }
  },
  methods: {
    async handleLogin() {
      try {
        const params = new URLSearchParams()
        params.append('username', this.username)
        params.append('password', this.password)

        const response = await axios.post('/api/login', params, {
          headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
          },
          withCredentials: true
        })
        if(response.status == 200) {
          location.href = 'http://localhost:9000/oauth2/authorize?response_type=code&client_id=admin&scope=profile&redirect_uri=http://localhost:8080/login/oauth2/code/admin';
        }
      } catch (error) {
        console.error('로그인 실패:', error)
        alert('로그인에 실패했습니다.')
      }
    }
  }
}
</script>

<style scoped>
.login {
  max-width: 400px;
  margin: 0 auto;
  padding: 20px;
}

.form-group {
  margin-bottom: 15px;
}

label {
  display: block;
  margin-bottom: 5px;
}

input {
  width: 100%;
  padding: 8px;
  margin-bottom: 10px;
}

button {
  width: 100%;
  padding: 10px;
  background-color: #42b983;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

button:hover {
  background-color: #3aa876;
}
</style>
