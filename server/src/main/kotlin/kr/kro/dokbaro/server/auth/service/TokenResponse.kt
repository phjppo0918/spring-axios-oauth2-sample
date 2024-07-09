package kr.kro.dokbaro.server.auth.service

data class TokenResponse(
    val accessToken: String,
    val refreshToken: String,
)
