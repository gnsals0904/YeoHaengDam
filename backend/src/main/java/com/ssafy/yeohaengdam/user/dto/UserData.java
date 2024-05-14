package com.ssafy.yeohaengdam.user.dto;

import lombok.Data;

public class UserData {

    @Data
    public static class Update{
        private String email;
        private String password;
        private String profileImage;
        private String nickname;
    }
}
