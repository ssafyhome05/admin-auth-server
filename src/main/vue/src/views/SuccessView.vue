<template>
  <div>
    <h2>로그인 성공!</h2>
    <div v-if="userInfo">
      <p>사용자 정보: {{ userInfo }}</p>
    </div>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  data() {
    return {
      userInfo: null
    }
  },
  
  async created() {
    // 컴포넌트가 생성될 때 사용자 정보를 가져옵니다
    await this.checkLoginStatus()
  },
  
  methods: {
    async checkLoginStatus() {
      try {
        const response = await axios.get('/api/user-info', {
          withCredentials: true // 쿠키 전송을 위해 필수
        })
        this.userInfo = response.data
        console.log('JSESSIONID 쿠키:', document.cookie) // 쿠키 확인
      } catch (error) {
        console.error('로그인 상태 확인 실패:', error)
        // 로그인 페이지로 리다이렉트 등의 처리
      }
    }
  }
}
</script>

