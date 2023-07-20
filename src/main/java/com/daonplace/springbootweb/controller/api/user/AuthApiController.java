package com.daonplace.springbootweb.controller.api.user;

import com.daonplace.springbootweb.config.auth.PrincipalDetailsService;
import com.daonplace.springbootweb.domain.user.User;
import com.daonplace.springbootweb.dto.CMRespDto;
import com.daonplace.springbootweb.service.AuthService;
import com.daonplace.springbootweb.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
@Slf4j
public class AuthApiController {

    private final UserService userService;
    private final AuthService authService;
    private final PrincipalDetailsService principalDetailsService;

    @GetMapping("/findEmail")
    public CMRespDto<?> findEmail(@RequestParam String email) {
        log.info("call get /api/auth/find");

        User user = userService.getUserByEmail(email);

        CMRespDto<Long> res = new CMRespDto<>(1, "이메일 검색 완료", user.getId());
        log.info("call api " + res);

        return res;
    }

    @GetMapping("/findAnswer/{userId}")
    public CMRespDto<?> findAnswer(@PathVariable Long userId, @RequestParam String answer) {
        log.info("call get /api/auth/findAnswer");

        CMRespDto<String> res;

        if (userService.getUserByAnswer(userId, answer)) {
            res = new CMRespDto<>(1, "정답 검색 완료", answer);
        } else {
            res = new CMRespDto<>(0, "정답 검색 실패", answer);
        }
        log.info("call api " + res);

        return res;
    }

    @GetMapping("/updatePassword/{userId}")
    public CMRespDto<?> updatePassword(@PathVariable Long userId, @RequestParam String password) {
        log.info("call get /api/auth/updatePassword/{userId}");

        User user = userService.getUserById(userId); log.info("call raw:" + password);

        User updateUser = authService.getUpdateUser(user, password);

        CMRespDto<User> res = new CMRespDto<>(1, "비밀번호 수정 완료", updateUser);
        log.info("call api " + res);

        return res;
    }

}
