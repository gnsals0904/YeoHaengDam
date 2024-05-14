package com.ssafy.yeohaengdam.auth.controller;

import com.ssafy.yeohaengdam.auth.dto.JwtToken;
import com.ssafy.yeohaengdam.auth.dto.LoginRequest;
import com.ssafy.yeohaengdam.auth.service.AuthService;
import com.ssafy.yeohaengdam.core.properties.AuthProperties;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

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

    @PostMapping("/refresh")
    @ResponseStatus(value = HttpStatus.OK)
    public JwtToken refresh(
            HttpServletRequest request,
            HttpServletResponse response
    ){
        Cookie cookie = parseRefreshCookie(request);
        try{
            JwtToken newToken = authService.refresh(cookie.getValue());
            response.addCookie(createCookie(newToken));
            return newToken;
        }catch(Exception e){
            removeCookie(response,"refreshToken");
            throw new RuntimeException("accessToken 재발급 도중 오류가 발생하였습니다.");
        }

    }

    private void removeCookie(HttpServletResponse response, String key) {
        Cookie cookie = new Cookie(key, null);
        cookie.setHttpOnly(false);
        cookie.setMaxAge(0);
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    private Cookie parseRefreshCookie(HttpServletRequest request){
        return Arrays.stream(request.getCookies())
                .filter(cookie -> cookie.getName().equals("refreshToken"))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("refreshToken이 존재하지 않습니다."));
    }


    private Cookie createCookie(JwtToken token) {
        Cookie refreshTokenCookie = new Cookie("refreshToken", token.getRefreshToken());
        refreshTokenCookie.setHttpOnly(false);
        refreshTokenCookie.setMaxAge((int) authProperties.getRefreshTokenExpiry() / 1000);
        refreshTokenCookie.setPath("/");
        return refreshTokenCookie;
    }


}
