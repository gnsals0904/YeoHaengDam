package com.ssafy.yeohaengdam.article.controller;

import com.ssafy.yeohaengdam.article.dto.ArticleData;
import com.ssafy.yeohaengdam.article.entity.SearchCriteria;
import com.ssafy.yeohaengdam.article.service.ArticleService;
import com.ssafy.yeohaengdam.auth.dto.JwtToken;
import com.ssafy.yeohaengdam.core.annotation.CurrentUser;
import com.ssafy.yeohaengdam.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static com.ssafy.yeohaengdam.article.dto.ArticleData.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/articles")
public class ArticleController {

    private final ArticleService articleService;


    /**
     * 게시글 전체 조회
     */
    @GetMapping("/list")
    public ResponseEntity<List<ArticleInfo>> list(@ModelAttribute SearchCriteria searchCriteria){
        return ResponseEntity.ok(articleService.list(searchCriteria));
    }


    /**
     * 게시글 등록
     */
    @PostMapping
    public ResponseEntity<Void> create(Create create, @CurrentUser User user,
                                       @RequestPart(required = false) List<MultipartFile> images){
        articleService.create(create, user.getUserId(), images);
        return ResponseEntity.ok().build();
    }

    /**
     * 게시글 상세 조회
     */
    @GetMapping("/{articleId}")
    public ResponseEntity<Detail> findById(@PathVariable int articleId){
        Detail findArticle = articleService.findById(articleId);
        System.out.println(findArticle);
        return ResponseEntity.ok(articleService.findById(articleId));
    }

    /**
     * 게시글 수정
     */
    @PatchMapping("/{articleId}")
    public ResponseEntity<Void> update(@PathVariable int articleId,
                                       Create update, @CurrentUser User user,
                                       @RequestPart(required = false) List<MultipartFile> images){

        articleService.update(articleId, update, user, images);
        return ResponseEntity.ok().build();
    }

    /**
     * 게시글 삭제
     */
    @DeleteMapping("/{articleId}")
    public ResponseEntity<Void> delete(@CurrentUser User user,
                                       @PathVariable int articleId) {
        articleService.delete(articleId, user);

        return ResponseEntity.ok().build();
    }

}
