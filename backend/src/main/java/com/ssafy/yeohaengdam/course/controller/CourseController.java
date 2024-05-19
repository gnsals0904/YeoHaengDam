package com.ssafy.yeohaengdam.course.controller;

import com.ssafy.yeohaengdam.core.annotation.CurrentUser;
import com.ssafy.yeohaengdam.course.dto.CourseData;
import com.ssafy.yeohaengdam.course.service.CourseService;
import com.ssafy.yeohaengdam.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PatchMapping("update")
    public ResponseEntity<Void> update(@CurrentUser User user,
                                       @RequestBody Update update){
        courseService.update(user.getUserId(), update);
        return ResponseEntity.ok().build();
    }
}
