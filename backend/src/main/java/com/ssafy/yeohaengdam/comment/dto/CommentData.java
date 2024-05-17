package com.ssafy.yeohaengdam.comment.dto;

import lombok.Data;

import java.time.LocalDateTime;

public class CommentData {

    @Data
    public static class Detail{
        private int commentId;
        private int articleId;
        private int userId;
        private String content;
        private LocalDateTime createAt;
        private LocalDateTime updatedAt;
    }

    @Data
    public static class Create{
        private int articleId;
        private String content;
    }
}
