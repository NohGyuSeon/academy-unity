package com.daonplace.springbootweb.service;

import com.daonplace.springbootweb.domain.user.User;
import com.daonplace.springbootweb.repository.user.UserRepository;
import com.daonplace.springbootweb.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
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

        // 회원가입 진행
        Long saveId = userService.join(user);
        User findOne = userService.getUserById(saveId);

        return findOne;
    }

    @Transactional
    public User getUpdateUser(User user, String rawPassword) {
        user.setPassword(encode(rawPassword));
        return user;
    }

    @Transactional
    public String encode(String rawPassword) {
        String encodePassword = bCryptPasswordEncoder.encode(rawPassword);
        return encodePassword;
    }

}
