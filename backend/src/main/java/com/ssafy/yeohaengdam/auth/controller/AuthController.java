package com.ssafy.yeohaengdam.auth.controller;

import com.ssafy.yeohaengdam.auth.dto.JwtToken;
import com.ssafy.yeohaengdam.auth.dto.LoginRequest;
import com.ssafy.yeohaengdam.auth.service.AuthService;
import com.ssafy.yeohaengdam.core.properties.AuthProperties;
import jakarta.servlet.http.HttpServletRequest;
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
        response.setHeader("Authorization", "Bearer " + token.getAccessToken());
        response.setHeader("RefreshToken", "Bearer " + token.getRefreshToken());
        System.out.println();
        return token;
    }

    @PostMapping("/refresh")
    @ResponseStatus(value = HttpStatus.OK)
    public JwtToken refresh(
            HttpServletRequest request,
            HttpServletResponse response
    ){
        String refreshToken = parseRefreshTokenFromHeader(request);
        try {
            JwtToken newToken = authService.refresh(refreshToken);
            response.setHeader("Authorization", "Bearer " + newToken.getAccessToken());
            response.setHeader("RefreshToken", "Bearer " + newToken.getRefreshToken());
            return newToken;
        } catch (Exception e) {
            throw new RuntimeException("accessToken 재발급 도중 오류가 발생하였습니다.");
        }
    }

    private String parseRefreshTokenFromHeader(HttpServletRequest request) {
        String header = request.getHeader("RefreshToken");
        if (header == null || !header.startsWith("Bearer ")) {
            throw new IllegalArgumentException("Invalid RefreshToken header");
        }
        return header.substring(7); // "Bearer " 이후의 토큰 부분만 추출
    }
}