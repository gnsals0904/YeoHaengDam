package com.ssafy.yeohaengdam.comment.controller;

import com.ssafy.yeohaengdam.comment.dto.CommentData;
import com.ssafy.yeohaengdam.comment.service.CommentService;
import com.ssafy.yeohaengdam.core.annotation.CurrentUser;
import com.ssafy.yeohaengdam.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/{articleId}")
    public ResponseEntity<List<Detail>> findAll(@PathVariable(value = "articleId") int articleId){
        return ResponseEntity.ok(commentService.findAll(articleId));
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<Void> create(@CurrentUser User user,
                                       @PathVariable(value = "commentId") int commentId) {
        commentService.delete(user.getUserId(), commentId);
        return ResponseEntity.ok().build();
    }
}
