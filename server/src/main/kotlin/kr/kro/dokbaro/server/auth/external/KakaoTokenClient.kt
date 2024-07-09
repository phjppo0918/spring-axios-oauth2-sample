package kr.kro.dokbaro.server.auth.external

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(
    name = "kakaoTokenClient",
    url = "\${oauth2.kakao.token-uri}",
)
interface KakaoTokenClient {
    @PostMapping(consumes = [MediaType.APPLICATION_FORM_URLENCODED_VALUE])
    fun getAuthorizationToken(
        @RequestParam(name = "grant_type") grantType: String,
        @RequestParam(name = "client_id") clientId: String,
        @RequestParam(name = "redirect_uri") redirectUri: String,
        @RequestParam(name = "code") code: String,
        @RequestParam(name = "client_secret") clientSecret: String,
    ): AuthorizationTokenResponse
}
