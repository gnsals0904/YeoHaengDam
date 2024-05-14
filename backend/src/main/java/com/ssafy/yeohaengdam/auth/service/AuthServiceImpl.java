package com.ssafy.yeohaengdam.auth.service;

import com.ssafy.yeohaengdam.auth.dto.JwtToken;
import com.ssafy.yeohaengdam.auth.dto.LoginRequest;
import com.ssafy.yeohaengdam.user.entity.User;
import com.ssafy.yeohaengdam.user.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{

    private final JwtTokenService jwtTokenService;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    @Override
    public JwtToken login(LoginRequest loginRequest) {
        System.out.println(loginRequest);
        User user = userMapper.findByEmail(loginRequest.getEmail());
        System.out.println(user);

        if(!passwordEncoder.matches(loginRequest.getPassword(),user.getPassword())){
            throw new IllegalArgumentException();
        }

        return jwtTokenService.generateToken(user);
    }
}
