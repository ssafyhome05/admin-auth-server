<script>
export default {
  name: 'ConsentComponent',
  methods: {
    cancelConsent() {
      // 취소 시 이전 페이지로 이동
      window.history.back()
    }
  }
}
</script>

<template>
  <div class="consent-container">
    <div class="header">
      <h1>권한 동의 필요</h1>
    </div>

    <div class="content-section">
      <div class="info-box">
        <p>
          <span class="highlight">관리자에 대한 접근을 요청합니다</span>
        </p>
      </div>

      <div class="description-box">
        <p>
          위 애플리케이션이 다음 권한을 요청합니다.<br />
          검토 후 동의해 주시기 바랍니다.
        </p>
      </div>

      <form name="consent_form" method="post" action="/oauth2/authorize" class="consent-form">
        <input type="hidden" name="client_id" :value="$route.query.client_id" />
        <input type="hidden" name="state" :value="$route.query.state" />
        
        <div class="checkbox-container">
          <input
            type="checkbox"
            name="scope"
            value="profile"
            id="profile"
          />
          <label for="profile">프로필 정보</label>
        </div>

        <div class="button-group">
          <button class="primary-button" type="submit">
            동의하기
          </button>
          <button
            class="secondary-button"
            type="button"
            @click="cancelConsent"
          >
            취소
          </button>
        </div>
      </form>

      <div class="notice-box">
        <p>
          접근 권한에 대한 동의가 필요합니다.<br />
          동의하지 않으시면 취소를 클릭해 주세요. 이 경우 어떠한 정보도 공유되지 않습니다.
        </p>
      </div>
    </div>

    <div class="footer">
      <p>&copy; 2024 OAuth2 Admin. All rights reserved.</p>
    </div>
  </div>
</template>

<style scoped>
.consent-container {
  max-width: 600px;
  margin: 0 auto;
  background-color: #ffffff;
  border-radius: 10px;
  box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
  font-family: 'Pretendard', 'Apple SD Gothic Neo', 'Malgun Gothic', sans-serif;
}

.header {
  text-align: center;
  padding: 25px 40px;
  background: linear-gradient(135deg, #3D5CDB 0%, #2C3E99 100%);
  border-radius: 10px 10px 0 0;
  color: white;
}

.content-section {
  padding: 40px 30px;
}

.info-box, .description-box, .notice-box {
  background-color: #F5F7FF;
  padding: 20px;
  margin: 20px 0;
  border-radius: 8px;
  text-align: center;
}

.highlight {
  color: #4D6FFF;
  font-weight: 600;
}

.checkbox-container {
  display: flex;
  align-items: center;
  justify-content: center;
  gap: 10px;
  margin: 20px 0;
  padding: 15px;
  background-color: #F8F9FA;
  border-radius: 8px;
}

.button-group {
  display: grid;
  gap: 10px;
  margin: 20px 0;
}

.primary-button {
  padding: 12px;
  background: linear-gradient(135deg, #3D5CDB 0%, #2C3E99 100%);
  color: white;
  border: none;
  border-radius: 8px;
  cursor: pointer;
  font-weight: 600;
}

.secondary-button {
  padding: 12px;
  background: transparent;
  color: #666;
  border: 1px solid #ddd;
  border-radius: 8px;
  cursor: pointer;
}

.footer {
  text-align: center;
  padding: 20px;
  background: linear-gradient(135deg, #3D5CDB 0%, #2C3E99 100%);
  border-radius: 0 0 10px 10px;
  color: white;
}
</style>
