package com.ssafy.yeohaengdam.user.controller;

import com.ssafy.yeohaengdam.user.dto.UserData;
import com.ssafy.yeohaengdam.user.service.UserService;
import com.ssafy.yeohaengdam.user.request.JoinRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.bind.annotation.*;

import static com.ssafy.yeohaengdam.user.dto.UserData.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@EnableWebSecurity
public class UserController {

    private final UserService userService;

    @PostMapping("/join")
    @ResponseStatus(HttpStatus.OK)
    public void join(@RequestBody JoinRequest request){
        System.out.println("join");
        System.out.println(request);
        userService.join(request);
    }


    /**
     * 회원 정보 업데이트
     * @param update
     * @return
     */
    @PostMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Void> update(@RequestBody Update update){
        userService.updateUser(update);
        return ResponseEntity.ok().build();
    }
}
