package com.daonplace.springbootweb.dto.auth;

import com.daonplace.springbootweb.domain.user.User;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
public class SignupDto {

    @NotBlank
    private String email;
    @NotBlank
    private String password;
    @Size(min = 1, max = 20)
    private String username;
    @Size(min = 1, max = 20)
    private String hint;
    @Size(min = 1, max = 20)
    private String answer;

    public User toEntity() {
        return User.builder()
            .email(email)
            .password(password)
            .username(username)
            .hint(hint)
            .answer(answer)
            .build();
    }
}
