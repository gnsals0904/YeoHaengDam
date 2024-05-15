package com.ssafy.yeohaengdam.user.service;

import com.ssafy.yeohaengdam.user.entity.User;
import com.ssafy.yeohaengdam.user.mapper.UserMapper;
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
    public void join(Join join) {
        User newUser = User.builder()
                .email(join.getEmail())
                .password(passwordEncoder.encode(join.getPassword()))
                .nickname(join.getNickname())
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

    @Override
    public void delete(UserInfo userInfo){
        User user = userMapper.findByEmail(userInfo.getEmail());
        userMapper.delete(user);
    }

    @Override
    public boolean checkNickname(String nickname) {
        return userMapper.checkNickname(nickname);
    }
}
