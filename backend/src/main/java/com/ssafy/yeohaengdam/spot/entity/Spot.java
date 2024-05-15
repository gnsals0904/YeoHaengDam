package com.ssafy.yeohaengdam.spot.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Spot {

    private int contentId;
    private int contentTypeId;
    private String title;
    private String addr1;
    private String addr2;
    private String tel;
    private String zipcode;
    private String img1;
    private String img2;
    private int sidoCode;
    private int gugunCode;
    private double latitude;
    private double longitude;
    private String description;
}
