package com.ssafy.yeohaengdam.user.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@NoArgsConstructor
@Getter
public class JoinRequest {

    private String email;

    private String nickname;

    private String password;



    @Override
    public String toString() {
        return "JoinRequest{" +
                "email='" + email + '\'' +
                ", nickname='" + nickname + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
