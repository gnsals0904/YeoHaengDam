package com.ssafy.yeohaengdam.user.domain.service;

import com.ssafy.yeohaengdam.user.domain.User;
import com.ssafy.yeohaengdam.user.request.JoinRequest;

public interface UserService {

    public void join(JoinRequest request);
}
