package com.ssafy.yeohaengdam.comment.mapper;

import com.ssafy.yeohaengdam.comment.dto.CommentData;
import com.ssafy.yeohaengdam.comment.entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.List;

import static com.ssafy.yeohaengdam.comment.dto.CommentData.*;

@Mapper
public interface CommentMapper {

    public void create(Comment comment);

    public void update(Comment comment);

    public List<Detail> findAll(int articleId);

    public void delete(int commentId);
}
