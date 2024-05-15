package com.ssafy.yeohaengdam.user.service;

import com.ssafy.yeohaengdam.user.dto.UserData;
import com.ssafy.yeohaengdam.user.entity.User;
import com.ssafy.yeohaengdam.user.request.JoinRequest;

import static com.ssafy.yeohaengdam.user.dto.UserData.*;

public interface UserService {

    public void join(JoinRequest request);

    public void updateUser(Update update);

    public User findByEmail(UserInfo userInfo);

    public void delete(UserInfo userInfo);
}
