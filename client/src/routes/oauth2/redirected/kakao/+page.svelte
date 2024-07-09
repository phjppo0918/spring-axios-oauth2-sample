<script>
    import { onMount } from 'svelte';
    import { page } from '$app/stores'

    import axios from "axios";

    axios.defaults.withCredentials = true;
    axios.defaults.baseURL = "http://localhost:8080/api";



    onMount(() => {

        const code = $page.url.searchParams.get('code')

        axios.post("/auth/login/kakao?code="+code).then(res => {
            alert(res.data.accessToken+ " " + res.data.refreshToken)
        })
    });

   // $: unsubscribe();
</script>

<div>
    <div>Processing...</div>
</div>
