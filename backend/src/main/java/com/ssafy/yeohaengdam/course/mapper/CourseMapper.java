package com.ssafy.yeohaengdam.course.mapper;

import com.ssafy.yeohaengdam.course.entity.Course;
import com.ssafy.yeohaengdam.course.entity.Schedule;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CourseMapper {

    public int save(Course course);

    public int update(Course course);

    public void saveSchedules(int courseId, List<Schedule> schedules);

    public void deleteSchedules(int courseId);

}
