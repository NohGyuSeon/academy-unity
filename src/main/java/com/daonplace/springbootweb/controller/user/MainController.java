package com.daonplace.springbootweb.controller.user;

import com.daonplace.springbootweb.dto.auth.SignupDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class MainController {

    @GetMapping({"/", "user/main"})
    public String mainForm() {
        log.info("get user/main");

        return "user/main";
    }

    @GetMapping("user/profile")
    public String profileForm() {
        log.info("get user/profile");

        return "user/profile";
    }



    @GetMapping("users/{userId}/update")
    public String updateForm(@PathVariable("userId") Long userId, Model model) {
        log.info("user/update");

        //== 구현 로직 ==//

        return "user/profile";
    }

    @PostMapping("users/{userId}/update")
    public String updateForm(@PathVariable Long userId, @ModelAttribute("dto") SignupDto dto) {
        log.info("user/update");

        //== 구현 로직 ==//

        return "user/profile";
    }






}
