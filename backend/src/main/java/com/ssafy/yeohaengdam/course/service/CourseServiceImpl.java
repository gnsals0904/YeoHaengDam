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

    @Override
    public void update(int userId, Update update){
        Detail findCourse = courseMapper.findById(update.getCourseId());
        if(findCourse.getUserId() != userId){
            throw new IllegalArgumentException("수정할 권한이 없습니다.");
        }
        Course updatedCourse = Course.builder()
                .userId(userId)
                .courseId(update.getCourseId())
                .title(update.getTitle())
                .description(update.getDescription())
                .build();

        courseMapper.update(updatedCourse);
        courseMapper.deleteSchedules(update.getCourseId());
        List<Schedule> scheduleList = update.getSchedules();
        courseMapper.saveSchedules(update.getCourseId(), scheduleList);
    }

    @Override
    public void delete(int userId, Delete delete) {
        Detail findCourse = courseMapper.findById(delete.getCourseId());
        if(findCourse.getUserId() != userId){
            throw new IllegalArgumentException("삭제할 권한이 없습니다.");
        }
        courseMapper.delete(delete.getCourseId());
    }
}
