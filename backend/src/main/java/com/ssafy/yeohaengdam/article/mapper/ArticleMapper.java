package com.ssafy.yeohaengdam.article.mapper;

import com.ssafy.yeohaengdam.article.dto.ArticleData;
import com.ssafy.yeohaengdam.article.entity.Article;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static com.ssafy.yeohaengdam.article.dto.ArticleData.*;

@Mapper
public interface ArticleMapper {
    public List<ArticleInfo> findAll();

    public void create(Article article);
}
