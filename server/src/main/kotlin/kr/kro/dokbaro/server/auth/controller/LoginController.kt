package kr.kro.dokbaro.server.auth.controller

import kr.kro.dokbaro.server.auth.service.LoginService
import kr.kro.dokbaro.server.auth.service.TokenResponse
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth/login")
class LoginController(
    private val loginService: LoginService,
) {
    @PostMapping("/kakao")
    fun kakaoLogin(
        @RequestParam code: String,
    ): TokenResponse = loginService.loginKakao(code)
}
