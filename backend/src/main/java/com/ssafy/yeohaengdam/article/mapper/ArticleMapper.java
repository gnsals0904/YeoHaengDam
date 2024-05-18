package com.ssafy.yeohaengdam.article.mapper;

import com.ssafy.yeohaengdam.article.dto.ArticleData;
import com.ssafy.yeohaengdam.article.entity.Article;
import com.ssafy.yeohaengdam.article.entity.Image;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static com.ssafy.yeohaengdam.article.dto.ArticleData.*;

@Mapper
public interface ArticleMapper {
    public List<ArticleInfo> findAll();

    public Detail findById(int articleId);
    public int create(Article article);

    public int update(Article article);

    public int delete(int articleId);

    public void createImage(Image image);

    public void deleteImage(int articleId);

    public void updateHit(int articleId);
}
