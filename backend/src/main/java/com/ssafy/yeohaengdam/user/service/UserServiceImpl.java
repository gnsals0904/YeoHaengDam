package com.ssafy.yeohaengdam.user.service;

import com.ssafy.yeohaengdam.user.entity.User;
import com.ssafy.yeohaengdam.user.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.function.Function;

import static com.ssafy.yeohaengdam.user.dto.UserData.*;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final PasswordService passwordService;

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

    @Bean
    public Function<UserDetails, User> fetchUser() {
        return userDetails -> userMapper.findByEmail(userDetails.getUsername());
    }

    @Override
    public boolean checkNickname(String nickname) {
        return userMapper.checkNickname(nickname);
    }

    @Override
    public void updatePassword(Password password) {
        User user = userMapper.findByEmail(password.getEmail());
        user.changePassword(passwordEncoder.encode(password.getPassword()));
        userMapper.updatePassword(user);
    }

    @Override
    public String resetPassword(Password password) {
        User user = userMapper.findByEmail(password.getEmail());
        if (user == null) {
            throw new IllegalArgumentException("해당 이메일을 사용하는 사용자가 없습니다.");
        }

        String newPassword = passwordService.generateRandomPassword();
        user.changePassword(passwordEncoder.encode(newPassword));
        userMapper.updatePassword(user);
        return newPassword;
    }
}
