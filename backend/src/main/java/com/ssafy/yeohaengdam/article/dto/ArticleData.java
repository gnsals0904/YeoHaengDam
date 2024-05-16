package com.ssafy.yeohaengdam.article.dto;

import lombok.Data;

public class ArticleData {

    @Data
    public static class ArticleList{
        private int articleNo;
        private String title;
        private String content;
    }
}
