package com.ssafy.yeohaengdam.user.service;

import com.ssafy.yeohaengdam.user.dto.UserData;
import com.ssafy.yeohaengdam.user.entity.User;
import static com.ssafy.yeohaengdam.user.dto.UserData.*;

public interface UserService {

    public void join(Join join);

    public void updateUser(Update update);

    public User findByEmail(UserInfo userInfo);

    public void delete(UserInfo userInfo);

    public boolean checkNickname(String nickname);

    public void updatePassword(Password password);

    public String resetPassword(Password password);
}
