package kr.kro.dokbaro.server.auth.external

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.PostMapping

@FeignClient(url = "\${oauth2.kakao.token-uri}")
interface KakaoTokenClient {
    @PostMapping
    fun getAuthorizationToken(token: String) {
    }
}
