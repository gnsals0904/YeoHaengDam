package com.ssafy.yeohaengdam.user.domain.mapper;

import com.ssafy.yeohaengdam.user.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    // 회원 가입
    public void join(User user);

}
