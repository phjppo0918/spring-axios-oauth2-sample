package kr.kro.dokbaro.server.auth.external

import org.springframework.cloud.openfeign.FeignClient

@FeignClient(url = "\${oauth2.kakao.user-info-uri}")
interface KakaoUserInfoClient {
    fun getUserProfiles(token: String) {
    }
}
