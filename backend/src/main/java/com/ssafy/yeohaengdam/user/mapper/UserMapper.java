package com.ssafy.yeohaengdam.user.mapper;

import com.ssafy.yeohaengdam.user.dto.UserData;
import com.ssafy.yeohaengdam.user.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    // 회원 가입
    public void join(User user);

    public User findByEmail(String email);

    public void update(User user);

    public void delete(User user);

    public boolean checkNickname(String nickname);

    public void updatePassword(User user);
}
