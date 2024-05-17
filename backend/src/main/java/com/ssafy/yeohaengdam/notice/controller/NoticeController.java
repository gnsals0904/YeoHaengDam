package com.ssafy.yeohaengdam.notice.controller;


import com.ssafy.yeohaengdam.core.annotation.CurrentUser;
import com.ssafy.yeohaengdam.notice.dto.NoticeData;
import com.ssafy.yeohaengdam.notice.service.NoticeService;
import com.ssafy.yeohaengdam.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.ssafy.yeohaengdam.notice.dto.NoticeData.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/notice")
public class NoticeController {

    private final NoticeService noticeService;

    @GetMapping("/list")
    public ResponseEntity<List<Detail>> findAll(){
        return ResponseEntity.ok(noticeService.findAll());
    }

    @PostMapping
    public ResponseEntity<Void> create(@CurrentUser User user, @RequestBody Create create){
        noticeService.create(user.getUserId(), create);
        return ResponseEntity.ok().build();
    }

    @GetMapping("{noticeId}")
    public ResponseEntity<Detail> findById(@PathVariable(value = "noticeId") int noticeId){
        return ResponseEntity.ok(noticeService.findById(noticeId));

    }
}