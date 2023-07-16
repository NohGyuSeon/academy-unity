package com.daonplace.springbootweb.service;

import com.daonplace.springbootweb.domain.user.User;
import com.daonplace.springbootweb.repository.user.UserRepository;
import com.daonplace.springbootweb.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserService userService;
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    public User signup(User user) throws RuntimeException {

        // 비밀번호 암호화 진행
        String rawPassword = user.getPassword();
        String encodePassword = bCryptPasswordEncoder.encode(rawPassword);
        user.setPassword(encodePassword);

        // 이후 관리자 방향성에 따른 구현 -> 사용자의 상태로 넣을 것인지, 다른 엔티티로 볼 것인지?

        // 회원가입 진행
        Long saveId = userService.join(user);
        User findOne = userService.getUserById(saveId);

        return findOne;
    }
}
