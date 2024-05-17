package com.ssafy.yeohaengdam.notice.controller;


import com.ssafy.yeohaengdam.notice.dto.NoticeData;
import com.ssafy.yeohaengdam.notice.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
