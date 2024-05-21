package com.ssafy.yeohaengdam.user.service;

import com.ssafy.yeohaengdam.user.entity.User;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import static com.ssafy.yeohaengdam.user.dto.UserData.*;

public interface UserService {

    public void join(Join join);

    public void updateUser(Update update, @RequestPart MultipartFile image);

    public User findByEmail(UserInfo userInfo);

    public void delete(UserInfo userInfo);

    public boolean checkNickname(String nickname);

    public void updatePassword(Password password);

    public String resetPassword(Password password);
}
