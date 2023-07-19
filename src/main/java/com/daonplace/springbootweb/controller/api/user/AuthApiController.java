package com.daonplace.springbootweb.controller.api.user;

import com.daonplace.springbootweb.domain.user.User;
import com.daonplace.springbootweb.dto.CMRespDto;
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

    @GetMapping("/findEmail")
    public CMRespDto<?> findEmail(@RequestParam String email) {
        log.info("call get /api/auth/find");

        CMRespDto<String> res = new CMRespDto<>(1, "이메일 검색 완료", email);
        log.info("call api " + res);

        return res;
    }

    @GetMapping("/findHint")
    public CMRespDto<?> findHint(@RequestParam String hint) {
        log.info("call get /api/auth/findHint");

        CMRespDto<String> res = new CMRespDto<>(1, "힌트 검색 완료", hint);
        log.info("call api " + res);

        return res;
    }

    @GetMapping("/findAnswer")
    public CMRespDto<?> findAnswer(@RequestParam String answer) {
        log.info("call get /api/auth/findAnswer");

        CMRespDto<String> res = new CMRespDto<>(1, "정답 검색 완료", answer);
        log.info("call api " + res);

        return res;
    }

    @GetMapping("/findPassword/{userId}")
    public CMRespDto<?> findPassword(@PathVariable Long userId, @RequestParam String answer) {
        log.info("call get /api/auth/findPassword/{userId}");

        String password = userService.getPasswordByAnswer(userId, answer);

        CMRespDto<String> res = new CMRespDto<>(1, "비밀번호 찾기 완료", password);
        log.info("call api " + res);

        return res;
    }








}
