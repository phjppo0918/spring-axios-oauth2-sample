package kr.kro.dokbaro.server.auth.external

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class AuthorizationTokenRequest(
    val grantType: String,
    val clientId: String,
    val redirectUri: String,
    val code: String,
    val clientSecret: String,
)
