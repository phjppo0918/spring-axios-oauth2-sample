package kr.kro.dokbaro.server.auth.service

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.util.UriComponentsBuilder

@Service
class AuthRedirectedService(
    @Value("\${oauth2.kakao.redirect-uri}") private val kakaoRedirectUri: String,
    @Value("\${oauth2.kakao.authorization-uri}") private val kakaoAuthorizationUri: String,
    @Value("\${oauth2.kakao.client-id}") private val kakaoClientId: String,
    @Value("\${oauth2.kakao.scope[0]}") private val kakaoScope: String,
) {
    fun getRequestAuthUri(provider: String): String =
        UriComponentsBuilder
            .fromUriString(kakaoAuthorizationUri)
            .queryParam("response_type", "code")
            .queryParam("client_id", kakaoClientId)
            .queryParam("redirect_uri", kakaoRedirectUri)
            .queryParam(
                "scope",
                kakaoScope,
            ).toUriString()
}
