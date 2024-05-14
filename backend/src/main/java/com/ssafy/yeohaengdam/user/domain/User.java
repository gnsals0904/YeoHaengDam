package com.ssafy.yeohaengdam.user.domain;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString
public class User {

    private Long userId;

    private String email;

    private String nickname;

    private String password;

    private String profileImage;

    private RoleType roleType;
}
