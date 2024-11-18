<template>
  <div class="login-container">
    <div class="header">
      <h1>ZIPCHACK 관리자 로그인</h1>
    </div>

    <div class="content-section">
      <form action="/login" method="post" class="login-form">
        <div class="form-group">
          <label for="username">아이디</label>
          <input 
            type="text" 
            id="username" 
            name="username" 
            required
            placeholder="아이디를 입력하세요"
          >
        </div>
        
        <div class="form-group">
          <label for="password">비밀번호</label>
          <input 
            type="password" 
            id="password" 
            name="password" 
            required
            placeholder="비밀번호를 입력하세요"
          >
        </div>

        <button type="submit" class="primary-button">로그인</button>
      </form>

      <div class="notice-box">
        <p>⚠️ 계정이 없으신가요? <a href="/signup" class="signup-link">관리자 권한 신청</a>하러 가기</p>
        <p>로그인에 문제가 있다면 관리자에게 문의하세요.</p>
      </div>
    </div>

    <div class="footer">
      <p>&copy; 2024 OAuth2 Admin. All rights reserved.</p>
    </div>
  </div>
</template>

<script>
export default {
  name: 'LoginComponent',
  data() {
    return {
      username: '',
      password: ''
    }
  },
}
</script>

<style scoped>
.signup-link {
  color: #3D5CDB;
  text-decoration: none;
  font-weight: 600;
}

.signup-link:hover {
  text-decoration: underline;
}

input:focus {
  outline: none;
  border-color: #3D5CDB;
  box-shadow: 0 0 0 2px rgba(61, 92, 219, 0.1);
}

.primary-button:hover {
  background: linear-gradient(135deg, #4D6FFF 0%, #3D5CDB 100%);
}

.notice-box {
  text-align: center;
}
</style>
