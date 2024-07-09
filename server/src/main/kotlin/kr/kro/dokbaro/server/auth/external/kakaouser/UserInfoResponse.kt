package kr.kro.dokbaro.server.auth.external.kakaouser

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming
import java.time.LocalDateTime

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class UserInfoResponse(
    val id: Long,
    val hasSignedUp: Boolean,
    val connectedAt: LocalDateTime,
    val kakaoAccount: KakaoAccountAttribute,
)
