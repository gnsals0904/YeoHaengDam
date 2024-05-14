package com.ssafy.yeohaengdam.auth.controller;

import com.ssafy.yeohaengdam.auth.dto.JwtToken;
import com.ssafy.yeohaengdam.auth.dto.LoginRequest;
import com.ssafy.yeohaengdam.auth.service.AuthService;
import com.ssafy.yeohaengdam.core.properties.AuthProperties;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {


    private final AuthService authService;
    private final AuthProperties authProperties;

    @PostMapping("/login")
    @ResponseStatus(value = HttpStatus.OK)
    public JwtToken login(
            @RequestBody @Validated LoginRequest request,
            Errors errors,
            HttpServletResponse response
    ){
        System.out.println(request);
        if(errors.hasErrors()){

            throw new IllegalArgumentException();
        }

        JwtToken token = authService.login(request);
        response.addCookie(createCookie(token));
        return token;
    }

    private Cookie createCookie(JwtToken token) {
        Cookie refreshTokenCookie = new Cookie("refreshToken", token.getRefreshToken());
        refreshTokenCookie.setHttpOnly(false);
        refreshTokenCookie.setMaxAge((int) authProperties.getRefreshTokenExpiry() / 1000);
        refreshTokenCookie.setPath("/");
        return refreshTokenCookie;
    }


}
