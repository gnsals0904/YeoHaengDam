package com.ssafy.yeohaengdam.spot.controller;

import com.ssafy.yeohaengdam.spot.dto.SpotData;
import com.ssafy.yeohaengdam.spot.service.SpotService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.ssafy.yeohaengdam.spot.dto.SpotData.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/spot")
public class SpotController {

    private final SpotService spotService;

    @GetMapping("/listGugun")
    public ResponseEntity<List<GugunCode>> listgugun(@RequestParam(value = "sidoCode") int sidoCode,
                                                    @RequestParam(value = "sidoName") String sidoName){

        try{
            List<GugunCode> gugunList = spotService.findGugunBySido(sidoCode, sidoName);
            return ResponseEntity.ok(gugunList);
        }catch(Exception e){
            throw new IllegalArgumentException("구군 조회에 실패했습니다.");
        }
    }



}
