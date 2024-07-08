<script>
    import { onMount } from 'svelte';
    import { page } from '$app/stores';
    import { goto } from '$app/navigation';
    import { get } from 'axios';
    import { getContext } from 'svelte';

    let location;
    const unsubscribe = page.subscribe(value => {
        location = value;
    });

    const handleOAuthKakao = async (code) => {
        try {
            // 카카오로부터 받아온 code를 서버에 전달하여 카카오로 회원가입 & 로그인한다
            const response = await get(`http://localhost:8080/api/auth/login/kakao?code=${code}`);
            const data = response.data; // 응답 데이터
            alert("로그인 성공: " + data);
            goto("/success");
        } catch (error) {
            goto("/fail");
        }
    };

    onMount(() => {
        const searchParams = new URLSearchParams(location.url.search);
        const code = searchParams.get('code');  // 카카오는 Redirect 시키면서 code를 쿼리 스트링으로 준다.
        if (code) {
            alert("CODE = " + code);
            handleOAuthKakao(code);
        }
    });

    $: unsubscribe();
</script>

<div>
    <div>Processing...</div>
</div>
