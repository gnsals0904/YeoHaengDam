package com.ssafy.yeohaengdam.course.dto;

import com.ssafy.yeohaengdam.course.entity.Schedule;
import com.ssafy.yeohaengdam.spot.entity.Spot;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

public class CourseData {

    @Data
    public static class Detail{
        private int courseId;

        private int userId;
    }

    @Data
    public static class Save{
        private String title;

        private String description;

        private List<Schedule> schedules;
    }

    @Data
    public static class Update{
        private int courseId;

        private String title;

        private String description;

        private List<Schedule> schedules;
    }

    @Data
    public static class Delete{
        private int courseId;
    }
}
