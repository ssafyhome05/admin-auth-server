<template>
  <div class="signup">
    <h2>회원가입</h2>
    <form @submit.prevent="handleSignup">
      <div class="form-group">
        <label for="password">비밀번호:</label>
        <input 
          type="password" 
          id="password" 
          v-model="password" 
          required
        >
      </div>

      <div class="form-group">
        <label for="confirmPassword">비밀번호 확인:</label>
        <input 
          type="password" 
          id="confirmPassword" 
          v-model="confirmPassword" 
          required
        >
      </div>

      <div class="form-group">
        <label for="role">권한:</label>
        <select 
          id="role" 
          v-model="role" 
          required
        >
          <option value="">권한을 선택하세요</option>
          <option value="ADMIN">관리자</option>
          <option value="MANAGER">매니저</option>
          <option value="USER">일반 사용자</option>
        </select>
      </div>

      <button type="submit">회원가입</button>
    </form>
  </div>
</template>

<script>
import axios from '../api/axios'

export default {
  name: 'SignupComponent',
  data() {
    return {
      password: '',
      confirmPassword: '',
      role: ''
    }
  },
  methods: {
    async handleSignup() {
      if (this.password !== this.confirmPassword) {
        alert('비밀번호가 일치하지 않습니다.')
        return
      }
      
      try {
        const response = await axios.post('/api/signup', {
          adminPw: this.password,
          adminRole: this.role
        })
        alert('회원가입이 완료되었습니다.')
      } catch (error) {
        console.error('회원가입 중 오류가 발생했습니다:', error)
      }
    }
  }
}
</script>

<style scoped>
.signup {
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
