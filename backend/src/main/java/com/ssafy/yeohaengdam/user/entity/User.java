package com.ssafy.yeohaengdam.user.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString
public class User {

    private int userId;

    private String email;

    private String nickname;

    private String password;

    private String profileImage;

    private RoleType roleType;


    public void changePassword(String password) {
        this.password = password;
    }
}
