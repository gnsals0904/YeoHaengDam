package com.ssafy.yeohaengdam.course.dto;

import com.ssafy.yeohaengdam.course.entity.Schedule;
import com.ssafy.yeohaengdam.spot.entity.Spot;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

public class CourseData {

    @Data
    public static class Save{
        private String title;

        private String description;

        private List<Schedule> Schedules;
    }
}
