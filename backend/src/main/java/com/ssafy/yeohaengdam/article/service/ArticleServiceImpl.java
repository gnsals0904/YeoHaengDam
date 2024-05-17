package com.ssafy.yeohaengdam.article.service;
import com.ssafy.yeohaengdam.article.entity.Article;
import com.ssafy.yeohaengdam.article.entity.Image;
import com.ssafy.yeohaengdam.article.mapper.ArticleMapper;
import com.ssafy.yeohaengdam.utils.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.ssafy.yeohaengdam.article.dto.ArticleData.*;
import static java.time.LocalDateTime.now;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {

    private final ArticleMapper articleMapper;
    private final FileService fileService;

    @Override
    public List<ArticleInfo> findAll() {
        return articleMapper.findAll();
    }

    @Override
    public ArticleInfo findById(int articleId){
        return articleMapper.findById(articleId);
    }

    @Override
    public void create(Create create, int userId, List<MultipartFile> images) {
        List<Image> imageList = new ArrayList<>();

        try {
            if (images != null) {
                for (MultipartFile image : images) {
                    String imagePath = fileService.saveFile(image);
                    imageList.add(new Image(null, imagePath, null)); // articleId는 나중에 설정
                }
            }

            Article newArticle = Article.builder()
                    .userId(userId)
                    .title(create.getTitle())
                    .content(create.getContent())
                    .hit(0)
                    .createdAt(now())
                    .build();
            int articleId = articleMapper.create(newArticle); // 생성된 Article의 ID를 설정

            if (images != null) {
                for (Image image : imageList) {
                    image.setArticleId(articleId);
                    articleMapper.createImage(image);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("이미지 저장 도중 오류가 발생했습니다.", e);
        } catch (Exception e) {
            throw new RuntimeException("게시글 생성 도중 오류가 발생했습니다.", e);
        }
    }

    @Override
    public void update(int articleId, Create update, int userId, List<MultipartFile> images) {
        List<Image> imageList = new ArrayList<>();

        try {
            if (images != null) {
                for (MultipartFile image : images) {
                    String imagePath = fileService.saveFile(image);
                    imageList.add(new Image(null, imagePath, null)); // articleId는 나중에 설정
                }
            }

            articleMapper.deleteImage(articleId);
            Article updatedArticle = Article.builder()
                    .articleId(articleId)
                    .title(update.getTitle())
                    .content(update.getContent())
                    .build();
            articleMapper.update(updatedArticle);


            if (images != null) {
                for (Image image : imageList) {
                    image.setArticleId(articleId);
                    articleMapper.createImage(image);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("게시글 수정 도중 오류가 발생했습니다.", e);
        }
    }

    @Override
    public void delete(int articleId) {
        articleMapper.delete(articleId);
    }
}
