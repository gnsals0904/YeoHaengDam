package com.ssafy.yeohaengdam.course.controller;

import com.ssafy.yeohaengdam.core.annotation.CurrentUser;
import com.ssafy.yeohaengdam.course.dto.CourseData;
import com.ssafy.yeohaengdam.course.service.CourseService;
import com.ssafy.yeohaengdam.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.ssafy.yeohaengdam.course.dto.CourseData.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/course")
public class CourseController {

    private final CourseService courseService;


    @PostMapping("/save")
    public ResponseEntity<Void> save(@CurrentUser User user,
                                     @RequestBody Save save){
        courseService.save(user.getUserId(), save);
        return ResponseEntity.ok().build();
    }
}
