package com.daonplace.springbootweb.controller.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class MainController {

    @GetMapping({"/", "users/main"})
    public String mainForm() {
        log.info("get users/main");

        return "users/main";
    }

}
