package kr.kro.dokbaro.server.auth.service

import kr.kro.dokbaro.server.auth.external.AuthorizationTokenRequest
import kr.kro.dokbaro.server.auth.external.AuthorizationTokenResponse
import kr.kro.dokbaro.server.auth.external.KakaoTokenClient
import kr.kro.dokbaro.server.auth.external.KakaoUserInfoClient
import kr.kro.dokbaro.server.auth.external.kakaouser.UserInfoResponse
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class LoginService(
    private val kakaoTokenClient: KakaoTokenClient,
    private val kakaoUserInfoClient: KakaoUserInfoClient,
    @Value("\${oauth2.kakao.redirect-uri}") private val kakaoRedirectUri: String,
    @Value("\${oauth2.kakao.client-id}") private val kakaoClientId: String,
    @Value("\${oauth2.kakao.grant-type}") private val kakaoGrantType: String,
    @Value("\${oauth2.kakao.secret-key}") private val kakaoSecretKey: String,
) {
    fun loginKakao(code: String): TokenResponse {
        val request =
            AuthorizationTokenRequest(
                kakaoGrantType,
                kakaoClientId,
                kakaoRedirectUri,
                code,
                kakaoSecretKey,
            )

        println(request)

        val authorizationToken: AuthorizationTokenResponse =
            kakaoTokenClient.getAuthorizationToken(
                kakaoGrantType,
                kakaoClientId,
                kakaoRedirectUri,
                code,
                kakaoSecretKey,
            )

        val userProfiles: UserInfoResponse =
            kakaoUserInfoClient.getUserProfiles(authorizationToken.tokenType + " " + authorizationToken.accessToken)

        println(userProfiles)

        return TokenResponse(userProfiles.id.toString(), "adsfadf")
    }
}
