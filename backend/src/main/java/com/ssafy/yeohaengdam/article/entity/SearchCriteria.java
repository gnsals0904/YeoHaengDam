package com.ssafy.yeohaengdam.article.entity;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter // 세터가 없으면 keyword값이 들어가지 않음.
public class SearchCriteria {

    private String keyword;

    private String SortBy;
}
