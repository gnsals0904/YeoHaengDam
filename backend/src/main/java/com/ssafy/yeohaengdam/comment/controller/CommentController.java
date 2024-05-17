package com.ssafy.yeohaengdam.comment.controller;

import com.ssafy.yeohaengdam.comment.dto.CommentData;
import com.ssafy.yeohaengdam.comment.service.CommentService;
import com.ssafy.yeohaengdam.core.annotation.CurrentUser;
import com.ssafy.yeohaengdam.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.ssafy.yeohaengdam.comment.dto.CommentData.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/comment")
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public ResponseEntity<Void> create(@CurrentUser User user,
                                       @RequestBody Create create){
        commentService.create(user.getUserId(), create);
        return ResponseEntity.ok().build();
    }


}
