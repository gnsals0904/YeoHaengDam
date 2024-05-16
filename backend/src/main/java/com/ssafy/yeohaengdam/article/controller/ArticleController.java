package com.ssafy.yeohaengdam.article.controller;

import com.ssafy.yeohaengdam.article.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/articles")
public class ArticleController {

    private final ArticleService articleService;


    /**
     * 게시글 전체 조회
     */
//    @GetMapping("/{articleId}")
//    public ResponseEntity<>


    /**
     * 게시글 등록
     */

    /**
     * 게시글 상세 조회
     */

    /**
     * 게시글 수정
     */

    /**
     * 게시글 삭제
     */
}
