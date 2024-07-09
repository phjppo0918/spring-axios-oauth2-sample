# 개요
기존에 sering oauth2 client 사용하려고 oauth2 프로세스를 다음과 같이 잡았음.
![image](https://github.com/phjppo0918/spring-axios-oauth2-sample/assets/55674648/388d73a1-db4f-47d9-bee6-de52904f4dcf)

이렇게 하면 장점은 확실히 있음
- client-id, secret key만 입력하면 oauth2 client가 뚝딱 다 해줘
- 프론트에서는 클릭 딸깍으로 다 끝남

근데 단점이 너~무 확실함
- cookie 방식으로 밖에 token 저장 못해
- redirect-uri 백단에서 관리해야해
- 프론트 측에서 XMLHttpRequest 기반 요청 못날려 (axios, fetch 등) - https://devtalk.kakao.com/t/topic/126926
- 즉, 프론트에서 사용하려면 a 태그 등으로 고정해서 링크타고 리다이렉션 쳐야함


그래서 oauth2 client 손절치고 다음 프로세스로 수정
![image](https://github.com/phjppo0918/spring-axios-oauth2-sample/assets/55674648/3f5207e9-2c98-4435-ae57-100b83dd269b)
# 진행 과정
1. 사용자 로그인 버튼 딸깍 -> 일로 이동 (http://localhost:8080/api/auth/redirect/kakao)
2. 서버에게 kakao redirect uri 받기 
3. kakao 로그인 페이지로 redirect (https://kauth.kakao.com/oauth/authorize)
4. kakao 로그인 완료 후 인가코드를 받고, client로 redirect(http://localhost:5173/oauth2/redirected/kakao?code={인가코드})
5. 서버에게 login 요청 보냄  (http://localhost:8080/api/auth/login/kakao)
6. server에서 인가코드로 토큰을 받음 (https://kauth.kakao.com/oauth/token)
7. server에서 토큰으로 사용자 정보 받음 (https://kapi.kakao.com/v2/user/me)
8. 사용자 정보 기반으로 자사 서비스 내에서 사용자 정보 따로 저장하고 자체 인가토큰 만들고 막 해야하는데 귀찮아서 안함.


# KAKAO Application 등록 방법
1. https://developers.kakao.com 들가서 만들어 <br>
<img width="929" alt="image" src="https://github.com/phjppo0918/spring-axios-oauth2-sample/assets/55674648/4d9b4c77-d951-49db-ac52-2753616b2699">
2. 제품설정 -> 카카오 로그인 -> Redirect URI 등록 <br>
<img width="931" alt="image" src="https://github.com/phjppo0918/spring-axios-oauth2-sample/assets/55674648/202b43cd-45dc-4f19-8abf-308d0371254e">
<br>
위 예시에서는 http://localhost:5173/oauth2/redirected/kakao 로 redirect 보냈음
<br>
3.  제품설정 -> 카카오 로그인 -> 동의항목 <br>
<img width="1100" alt="image" src="https://github.com/phjppo0918/spring-axios-oauth2-sample/assets/55674648/fd530b57-7dab-4ee1-a14f-e0ca362b3f9d">

4. 제품설정 -> 카카오 로그인 -> 보안 - > secret key 발급 <br>
<img width="1086" alt="image" src="https://github.com/phjppo0918/spring-axios-oauth2-sample/assets/55674648/59380dc2-925d-4044-9b9f-cf1f167b0e26">
<br>
발급한 이후에 활성화 딸깍
<br>
5. 환경변수 등록 <br>
client-id : 앱설정 -> 앱 키 <br>
client-secret : 보안 -> 발급받은 setret key <br>


# KAKAO 문서
- 인가 코드 받기 : https://developers.kakao.com/docs/latest/ko/kakaologin/rest-api#request-code
- 토큰 받기 : https://developers.kakao.com/docs/latest/ko/kakaologin/rest-api#request-token-info
- 사용자 정보 가져오기 : https://developers.kakao.com/docs/latest/ko/kakaologin/rest-api#req-user-info-info


# 코드 주의사항
- svelte GPT가 만들어줬어용. 되긴 하는데 왜 되는지 모르겠어용. 조심해서 카피뜨세용.
- 백단 코드도 요청 응답값 위주로 보여주려고 최대한 간략하게 짰어요(지금보니까 시큐리티도 필요없네)
- kakao.scope 저거 콤마형식으로 하면 List 형식으로 복수개 받을 수 있음. 귀찮아서 안한거.
- 귀찮아서 카카오만 했는데, 다른거도 다 비슷비슷혀
- 뭔가 잘못된거 같다 싶으면 높은 확률로 선생님 말이 맞아요. 피드백 환영
