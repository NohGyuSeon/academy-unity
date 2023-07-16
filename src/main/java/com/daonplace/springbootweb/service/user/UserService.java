package com.daonplace.springbootweb.service.user;

import com.daonplace.springbootweb.domain.user.User;
import com.daonplace.springbootweb.domain.user.UserStatus;
import com.daonplace.springbootweb.dto.user.UserDto;
import com.daonplace.springbootweb.handler.ex.DuplicateUserException;
import com.daonplace.springbootweb.handler.ex.NotFoundException;
import com.daonplace.springbootweb.repository.user.UserRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    /**
     * 사용자 회원가입
     */
    @Transactional
    public Long join(User user) {
        validationDuplicateUser(user);
        userRepository.save(user);
        return user.getId();
    }

    /**
     * 사용자 수정
     */
    @Transactional
    public User update(Long userId, User user) {
        User userEntity = getUserById(userId);

        userEntity.setEmail(user.getEmail());
        userEntity.setUsername(user.getUsername());

        String rawPassword = user.getPassword();
        String encodePassword = bCryptPasswordEncoder.encode(rawPassword);

        userEntity.setPassword(encodePassword);

        return userEntity;
    }

    /**
     * 중복 사용자 검증
     */
    private void validationDuplicateUser(User user) {
        userRepository.findByEmail(user.getEmail())
            .ifPresent(existingUser -> {
                throw new DuplicateUserException("이미 존재하는 사용자입니다.");
            });
    }

    /**
     * 탈퇴, 휴면 사용자 검증
     */
    private void validationUserStatus(User user) {
        if (user.getStatus() == UserStatus.withdrawn) {
            throw new DuplicateUserException("탈퇴한 사용자입니다.");
        } else if (user.getStatus() == UserStatus.dormant) {
            throw new DuplicateUserException("휴먼상태 사용자입니다.");
        }
    }

    /**
     * 사용자 삭제 예정
     */
    @Transactional
    public void withDrawnUser(Long userId) {
        User user = getUserById(userId);

        user.setStatus(UserStatus.withdrawn);
    }

    /**
     * 사용자 휴먼 전환
     */
    @Transactional
    public void dormantUser(Long userId) {
        User user = getUserById(userId);

        user.setStatus(UserStatus.dormant);
    }

    /**
     * 사용자 복구
     */
    @Transactional
    public void rollbackUser(Long userId) {
        User user = getUserById(userId);

        user.setStatus(UserStatus.registered);
    }

    /**
     * 사용자 삭제
     */
    @Transactional
    public Long deleteUser(Long userId) {
        userRepository.deleteById(userId);

        return userId;
    }

    /**
     * 사용자 전체 가져오기
     */
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    /**
     * 사용자 가져오기 (id)
     */
    public User getUserById(Long userId) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new NotFoundException("존재하지 않는 사용자입니다."));
        return user;
    }

    /**
     * 사용자 가져오기 (email)
     */
    public User getUserByEmail(String email) {
        User user = userRepository.findByEmail(email)
            .orElseThrow(() -> new NotFoundException("존재하지 않는 사용자입니다."));
        return user;
    }

}
