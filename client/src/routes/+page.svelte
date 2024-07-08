<script>
    import kakaoSignUpButton from '$lib/images/kakao_signup.png';
    import googleSignUpButton from '$lib/images/google_signup.png';
    import kakaoLoginButton from '$lib/images/kakao_login.png';
    import googleLoginButton from '$lib/images/google_login.png';
    import axios from "axios";

    axios.defaults.withCredentials = true;
    axios.defaults.baseURL = "http://localhost:8080/api";


    // 회원가입 -> 회원가입 시 로그인 자동으로 됨
    function kakaologin() {
        window.location.href = 'http://localhost:8080/api/auth/kakao/redirect'
    }

    // 로그인 -> 회원가입 안된 계정이면 error


    // 회원 탈퇴
</script>

<h1>회원가입</h1>
<img src={kakaoSignUpButton}/>
<img src={googleSignUpButton}/>

<h1>로그인</h1>
<img src={kakaoLoginButton} onclick="kakaologin()"/>
<img src={googleLoginButton}/>


<h1>회원 탈퇴</h1>
<button>
    카카오 탈퇴
</button>

<button>
    구글 탈퇴
</button>
