package com.ssafy.yeohaengdam.user.domain.service;

import com.ssafy.yeohaengdam.user.domain.User;
import com.ssafy.yeohaengdam.user.domain.mapper.UserMapper;
import com.ssafy.yeohaengdam.user.request.JoinRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void join(JoinRequest request) {
        User newUser = User.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .nickname(request.getNickname())
                .build();
        userMapper.join(newUser);
    }
}
