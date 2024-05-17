package com.ssafy.yeohaengdam.article.entity;

import lombok.*;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Image {
    private Integer id;
    private String url;
    private Integer articleId;
}
