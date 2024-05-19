package com.ssafy.yeohaengdam.course.service;

import com.ssafy.yeohaengdam.course.dto.CourseData;
import com.ssafy.yeohaengdam.course.entity.Course;
import com.ssafy.yeohaengdam.course.entity.Schedule;
import com.ssafy.yeohaengdam.course.mapper.CourseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.ssafy.yeohaengdam.course.dto.CourseData.*;
import static java.time.LocalDateTime.now;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService{

    private final CourseMapper courseMapper;

    @Override
    public void save(int userId, Save save) {
        Course newCourse = Course.builder()
                .userId(userId)
                .title(save.getTitle())
                .description(save.getDescription())
                .createdAt(now())
                .build();
        int courseId = courseMapper.save(newCourse);
        List<Schedule> scheduleList = save.getSchedules();
        courseMapper.saveSchedules(courseId, scheduleList);

    }
}
