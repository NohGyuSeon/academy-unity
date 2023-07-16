package com.daonplace.springbootweb.controller.api;

import com.daonplace.springbootweb.config.auth.PrincipalDetails;
import com.daonplace.springbootweb.domain.user.User;
import com.daonplace.springbootweb.dto.CMRespDto;
import com.daonplace.springbootweb.dto.user.UserDto;
import com.daonplace.springbootweb.service.user.UserService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserApiController {

    private final UserService userService;

    @PutMapping("/api/user/{userId}")
    public CMRespDto<?> update(@PathVariable Long userId, @Valid UserDto userDto,
        BindingResult bindingResult,
        @AuthenticationPrincipal PrincipalDetails principalDetails) {

        User userEntity = userService.update(userId, userDto.toEntity());

        principalDetails.setUser(userEntity); // 세션 정보 변경

        return new CMRespDto<>(1, "회원수정완료",
            userEntity); // 응답 시 userEntity의 모든 getter 함수가 호출되고 JSON으로 파싱하여 응답
    }

}
