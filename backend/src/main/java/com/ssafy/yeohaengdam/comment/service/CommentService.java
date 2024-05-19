package com.ssafy.yeohaengdam.comment.service;

import com.ssafy.yeohaengdam.comment.dto.CommentData;
import com.ssafy.yeohaengdam.user.entity.User;

import java.util.List;

import static com.ssafy.yeohaengdam.comment.dto.CommentData.*;

public interface CommentService {

    public void create(User user, Create create);

    public void update(int userId, Update update);

    public void delete(int userId, int commentId);

    public List<Detail> findByArticleId(int articleId);
}
