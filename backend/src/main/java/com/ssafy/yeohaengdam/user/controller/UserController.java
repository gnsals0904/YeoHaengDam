package com.ssafy.yeohaengdam.user.controller;

import com.ssafy.yeohaengdam.user.entity.User;
import com.ssafy.yeohaengdam.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static com.ssafy.yeohaengdam.user.dto.UserData.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@EnableWebSecurity
public class UserController {

    private final UserService userService;

    /**
     * 회원가입
     * @param join
     */
    @PostMapping("/join")
    @ResponseStatus(HttpStatus.OK)
    public void join(@RequestBody Join join){
        userService.join(join);
    }

    /**
     * 닉네임 중복 검증
     */
    @GetMapping("/check_nickname/{nickname}")

    public ResponseEntity<?> checkNickname(@PathVariable(value = "nickname") String nickname){
        boolean isAvailable = userService.checkNickname(nickname);
        if(!isAvailable){
            return ResponseEntity.ok().body(Map.of("available", false, "message", "Nickname is already taken"));
        }
        return ResponseEntity.ok().body(Map.of("available", true, "message", "Nickname is available"));
    }



    /**
     * 회원 정보 업데이트
     * @param update
     * @return
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Void> update(@RequestBody Update update){
        userService.updateUser(update);
        return ResponseEntity.ok().build();
    }
    /**
     * 회원 정보 조회
     */
    @GetMapping("/myInfo")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<User> myPage(@RequestBody UserInfo userInfo){
        User user = userService.findByEmail(userInfo);
        return ResponseEntity.ok(user);
    }

    /**
     * 회원 삭제
     */
    @DeleteMapping("/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Void> delete(@RequestBody UserInfo userInfo){
        userService.delete(userInfo);
        return ResponseEntity.ok().build();
    }
}
