package kr.kro.dokbaro.server.auth.controller

import jakarta.servlet.http.HttpServletResponse
import kr.kro.dokbaro.server.auth.service.AuthRedirectedService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth/redirect")
class RedirectedController(
    private val redirectedService: AuthRedirectedService,
) {
    @GetMapping("/kakao")
    @ResponseStatus(HttpStatus.FOUND)
    fun kakao(response: HttpServletResponse) {
        response.sendRedirect(redirectedService.getRequestAuthUri("kakao"))
    }
}
