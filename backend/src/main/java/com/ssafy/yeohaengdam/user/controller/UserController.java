package com.ssafy.yeohaengdam.user.controller;

import com.ssafy.yeohaengdam.user.domain.service.UserService;
import com.ssafy.yeohaengdam.user.request.JoinRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
