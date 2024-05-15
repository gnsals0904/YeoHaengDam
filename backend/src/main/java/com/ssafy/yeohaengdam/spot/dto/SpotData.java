package com.ssafy.yeohaengdam.spot.dto;

import lombok.Data;

public class SpotData {

    @Data
    public static class GugunCode{
        private int gugunCode;
        private String gugunName;
    }
}
