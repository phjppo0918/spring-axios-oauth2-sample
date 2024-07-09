<script>
    import kakaoLoginButton from '$lib/images/kakao_login.png';

    function kakaologin() {
        window.location.href = 'http://localhost:8080/api/auth/redirect/kakao'
    }
</script>

<h1>로그인</h1>
<img on:click={kakaologin} src={kakaoLoginButton}/>
