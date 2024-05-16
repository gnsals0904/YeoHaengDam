package com.ssafy.yeohaengdam.article.service;
import com.ssafy.yeohaengdam.article.entity.Article;
import com.ssafy.yeohaengdam.article.mapper.ArticleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

import static com.ssafy.yeohaengdam.article.dto.ArticleData.*;
import static java.time.LocalDateTime.now;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements  ArticleService{

    private final ArticleMapper articleMapper;

    @Override
    public List<ArticleInfo> findAll() {
        return articleMapper.findAll();
    }

    @Override
    public void create(Create create, int userId ,List<MultipartFile> images) {
        Article newArticle = Article.builder()
                .userId(userId)
                .title(create.getTitle())
                .content(create.getContent())
                .hit(0)
                .createdAt(now())
                .build();
        articleMapper.create(newArticle);
    }
}
