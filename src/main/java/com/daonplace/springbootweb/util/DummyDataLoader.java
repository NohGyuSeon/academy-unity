package com.daonplace.springbootweb.util;

import com.daonplace.springbootweb.domain.user.User;
import com.daonplace.springbootweb.repository.user.UserRepository;
import com.daonplace.springbootweb.service.AuthService;
import java.util.Optional;
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
        createAdminUser("admin1234@gmail.com", "admin1", "1234", "hint1", "answer1");
        createAdminUser("admin1234@naver.com", "admin2", "1234", "hint2", "answer2");
    }

    private void createAdminUser(String email, String username, String password, String hint, String answer) {
        // 이메일과 사용자명을 사용하여 이미 존재하는 사용자를 찾기
        if (userRepository.findByEmail(email).isPresent() || userRepository.findByUsername(username).isPresent()) {
            return;
        } else {
            // 해당 이메일과 사용자명을 가진 사용자가 존재하지 않는 경우, 새로운 User 객체를 생성하여 저장
            User adminUser = User.builder()
                .email(email)
                .password(authService.encode(password))
                .username(username)
                .hint(hint)
                .answer(answer)
                .hasRoleAdmin(true)
                .build();
            userRepository.save(adminUser);
        }
    }
}
