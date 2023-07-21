package com.daonplace.springbootweb.util;

import com.daonplace.springbootweb.domain.user.User;
import com.daonplace.springbootweb.domain.user.UserStatus;
import com.daonplace.springbootweb.repository.user.UserRepository;
import com.daonplace.springbootweb.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DummyDataLoader implements CommandLineRunner {

    private final UserRepository userRepository;
    private final AuthService authService;

    @Override
    public void run(String... args) throws Exception {
        // 관리자 더미 데이터 삽입
        User user1 = User.builder()
            .email("admin1234@gmail.com")
            .password(authService.encode("1234"))
            .username("admin1")
            .hint("hint1")
            .answer("answer1")
            .hasRoleAdmin(true)
            .build();
        userRepository.save(user1);

        User user2 = User.builder()
            .email("admin1234@naver.com")
            .password(authService.encode("1234"))
            .username("admin2")
            .hint("hint2")
            .answer("answer2")
            .hasRoleAdmin(true)
            .build();
        userRepository.save(user2);
    }
}
