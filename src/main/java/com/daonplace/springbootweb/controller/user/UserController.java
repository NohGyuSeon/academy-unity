package com.daonplace.springbootweb.controller.user;

import com.daonplace.springbootweb.config.auth.PrincipalDetails;
import com.daonplace.springbootweb.domain.user.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
@Slf4j
public class UserController {

    /**
     * 사용자 업데이트 폼
     */
    @GetMapping("/user/updateProfile/{userId}")
    public String updateProfile(@PathVariable Long userId,
        @AuthenticationPrincipal PrincipalDetails principalDetails, Model model) {
        log.info("call get /user/profile/update/{userId}");

        User user = principalDetails.getUser();

        model.addAttribute("user", user);

        return "user/updateProfile";
    }






}
