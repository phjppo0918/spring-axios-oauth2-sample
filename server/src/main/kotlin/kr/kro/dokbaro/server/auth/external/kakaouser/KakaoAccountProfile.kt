package kr.kro.dokbaro.server.auth.external.kakaouser

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class KakaoAccountProfile(
    val nickname: String?,
    val thumbnailImageUrl: String?,
    val profileImageUrl: String?,
    val isDefaultImage: Boolean?,
)
