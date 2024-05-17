package com.ssafy.yeohaengdam.comment.service;

import com.ssafy.yeohaengdam.comment.dto.CommentData;
import org.apache.ibatis.annotations.Update;

import java.util.List;

import static com.ssafy.yeohaengdam.comment.dto.CommentData.*;

public interface CommentService {

    public void create(int userId, Create create);

    public void update(Update update);

    public List<Detail> findAll();

    public void delete(int commentId);
}
