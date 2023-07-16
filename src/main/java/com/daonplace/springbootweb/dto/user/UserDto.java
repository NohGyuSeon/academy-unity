package com.daonplace.springbootweb.dto.user;

import com.daonplace.springbootweb.domain.user.User;
import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserDto {

    @NotBlank
    private String email;

    @NotBlank
    private String password;

    @NotBlank
    private String username;

    public User toEntity() {
        return User.builder()
            .email(email)
            .password(password)
            .username(username)
            .build();
    }

}
