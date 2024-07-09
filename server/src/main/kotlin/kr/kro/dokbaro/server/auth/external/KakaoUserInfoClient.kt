package kr.kro.dokbaro.server.auth.external

import kr.kro.dokbaro.server.auth.external.kakaouser.UserInfoResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader

@FeignClient(name = "kakaoUserInfoClient", url = "\${oauth2.kakao.user-info-uri}")
interface KakaoUserInfoClient {
    @GetMapping(consumes = [MediaType.APPLICATION_FORM_URLENCODED_VALUE])
    fun getUserProfiles(
        @RequestHeader(name = "Authorization") token: String,
    ): UserInfoResponse
}
