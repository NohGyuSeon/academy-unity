package com.daonplace.springbootweb.controller.user;

import com.daonplace.springbootweb.domain.user.User;
import com.daonplace.springbootweb.dto.auth.SignupDto;
import com.daonplace.springbootweb.handler.ex.CustomValidationException;
import com.daonplace.springbootweb.service.AuthService;
import java.util.HashMap;
import java.util.Map;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
public class AuthController {

    private final AuthService authService;

    @GetMapping("auth/signin")
    public String signinForm() {
        log.info("get auth/signin");

        return "auth/signin";
    }

    @GetMapping("auth/signup")
    public String signupForm() {
        log.info("get auth/signup");

        return "auth/signup";
    }

    @PostMapping("auth/signup")
    public String signup(@Valid SignupDto signupDto, BindingResult bindingResult) {
        log.info("post auth/signup");

        if (bindingResult.hasErrors()) {
            Map<String, String> errorMap = new HashMap<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errorMap.put(error.getField(), error.getDefaultMessage());
                log.info("error message={}", error.getDefaultMessage());
            }

            throw new CustomValidationException("유효성 검사 실패함.", errorMap);
        } else {
            User user = signupDto.toEntity();
            log.info("user info={}", user.toString());

            authService.signup(user);
        }

        return "auth/signin"; // 회원가입 완료 시, 로그인 폼으로 돌아감
    }






}
