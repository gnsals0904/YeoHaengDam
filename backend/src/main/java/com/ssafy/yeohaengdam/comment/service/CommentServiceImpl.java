package com.ssafy.yeohaengdam.comment.service;

import com.ssafy.yeohaengdam.comment.dto.CommentData;
import com.ssafy.yeohaengdam.comment.entity.Comment;
import com.ssafy.yeohaengdam.comment.mapper.CommentMapper;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.ssafy.yeohaengdam.comment.dto.CommentData.*;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService{

    private final CommentMapper commentMapper;
    @Override
    public void create(int userId, Create create) {
        Comment newComment = Comment.builder()
                .userId(userId)
                .articleId(create.getArticleId())
                .content(create.getContent())
                .build();
        commentMapper.create(newComment);
    }

    @Override
    public void update(Update update) {

    }

    @Override
    public List<Detail> findAll(int articleId) {
        return commentMapper.findAll(articleId);
    }

    @Override
    public void delete(int commentId) {

    }
}
