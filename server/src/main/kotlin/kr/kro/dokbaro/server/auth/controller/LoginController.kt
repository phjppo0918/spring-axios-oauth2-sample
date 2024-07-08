package kr.kro.dokbaro.server.auth.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth/login")
class LoginController {
    @PostMapping("/kakao")
    fun kakaoLogin(
        @RequestParam code: String,
    ) {
    }
}
