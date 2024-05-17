package com.ssafy.yeohaengdam.comment.service;

import com.ssafy.yeohaengdam.comment.dto.CommentData;
import com.ssafy.yeohaengdam.comment.entity.Comment;
import com.ssafy.yeohaengdam.comment.mapper.CommentMapper;
import lombok.RequiredArgsConstructor;
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
    public List<Detail> findAll(int articleId) {
        return commentMapper.findAll(articleId);
    }

    @Override
    public void delete(int userId, int commentId) {
        Detail comment = commentMapper.findById(commentId);
        if(comment.getUserId() != userId){
            throw new IllegalArgumentException("댓글 수정 권한이 없는 사용자입니다.");
        }
        commentMapper.delete(commentId);
    }

    @Override
    public void update(int userId, Update update){
        Detail comment = commentMapper.findById(update.getCommentId());
        if(comment.getUserId() != userId){
            throw new IllegalArgumentException("댓글 삭제 권한이 없는 사용자입니다.");
        }
        Comment updatedComment = Comment.builder()
                .commentId(update.getCommentId())
                .content(update.getContent())
                .build();
        commentMapper.update(updatedComment);
    }
}
