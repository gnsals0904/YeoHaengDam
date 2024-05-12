package com.ssafy.yeohaengdam.user.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class User {

    private Long userId;

    private String email;

    private String nickname;

    private String password;

    private String profileImage;
}
