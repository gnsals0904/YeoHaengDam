package com.ssafy.yeohaengdam.course.service;

import com.ssafy.yeohaengdam.course.dto.CourseData;
import com.ssafy.yeohaengdam.course.entity.Course;

import java.util.List;

import static com.ssafy.yeohaengdam.course.dto.CourseData.*;

public interface CourseService {


    void save(int userId, Save save);

    public void update(int userId, Update update);
}
