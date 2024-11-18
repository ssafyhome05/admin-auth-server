<template>
  <div class="signup-container">
    <div class="header">
      <h1>관리자 권한 신청</h1>
    </div>

    <div class="content-section">
      <form @submit.prevent="handleSignup" class="signup-form">
        <div class="form-group">
          <label for="password">비밀번호</label>
          <input 
            type="password" 
            id="password" 
            v-model="password" 
            required
            placeholder="비밀번호를 입력하세요"
          >
        </div>

        <div class="form-group">
          <label for="confirmPassword">비밀번호 확인</label>
          <input 
            type="password" 
            id="confirmPassword" 
            v-model="confirmPassword" 
            required
            placeholder="비밀번호를 다시 입력하세요"
          >
        </div>

        <div class="form-group">
          <label for="role">권한</label>
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

        <button type="submit" class="primary-button">관리자 권한 신청</button>
      </form>

      <div class="notice-box">
        <p>⚠️ 모든 필드를 정확히 입력해주세요.</p>
        <p>비밀번호는 안전하게 암호화되어 저장됩니다.</p>
      </div>
    </div>

    <div class="footer">
      <p>&copy; 2024 OAuth2 Admin. All rights reserved.</p>
    </div>
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
/* 회원가입 페이지 고유 스타일만 남김 */
</style>
