package com.daonplace.springbootweb.controller.user;

import com.daonplace.springbootweb.service.user.BoardService;
import com.daonplace.springbootweb.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;
    private final BoardService boardService;

    /**
     * 프로필 폼
     */
    @GetMapping("/user/profile/{userId}")
    public String profileForm(@PathVariable int userId) {
        log.info("call get /user/profile/{userId}");

        return "user/profile";
    }





}
