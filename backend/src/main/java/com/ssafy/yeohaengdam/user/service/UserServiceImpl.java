package com.ssafy.yeohaengdam.user.service;

import com.ssafy.yeohaengdam.user.dto.UserData;
import com.ssafy.yeohaengdam.user.entity.User;
import com.ssafy.yeohaengdam.user.mapper.UserMapper;
import com.ssafy.yeohaengdam.user.request.JoinRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static com.ssafy.yeohaengdam.user.dto.UserData.*;

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

    @Override
    public void updateUser(Update update) {
        User user = userMapper.findByEmail(update.getEmail());
        if(user == null){
            throw new IllegalArgumentException("사용자를 찾을 수 없습니다.");
        }

        User updatedUser = User.builder()
                .userId(user.getUserId())
                .email(user.getEmail())
                .password(passwordEncoder.encode(update.getPassword()))
                .nickname(update.getNickname())
                .profileImage(update.getProfileImage())
                .roleType(user.getRoleType())
                .build();

        userMapper.update(updatedUser);
    }

    @Override
    public User findByEmail(UserInfo userInfo) {
        return userMapper.findByEmail(userInfo.getEmail());
    }
}
