package com.ssafy.yeohaengdam.comment.service;

import com.ssafy.yeohaengdam.comment.dto.CommentData;

import java.util.List;

import static com.ssafy.yeohaengdam.comment.dto.CommentData.*;

public interface CommentService {

    public void create(int userId, Create create);

    public void update(int userId, Update update);

    public void delete(int userId, int commentId);
}