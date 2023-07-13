package com.daonplace.springbootweb.service.user;

import com.daonplace.springbootweb.domain.user.User;
import com.daonplace.springbootweb.domain.user.UserStatus;
import com.daonplace.springbootweb.exception.DuplicateUserException;
import com.daonplace.springbootweb.repository.user.UserRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    /**
     * 사용자 회원 가입
     */
    @Transactional
    public Long join(User user) {
        validationDuplicateUser(user); // 중복 사용자 검증
        validationUserStatus(user); // 탈퇴, 휴먼상태 사용자 검증
        userRepository.save(user);
        return user.getId();
    }

    private void validationDuplicateUser(User user) {
        List<User> findUsers = userRepository.findByEmail(user.getEmail());
        if (!findUsers.isEmpty()) {
            throw new DuplicateUserException("이미 존재하는 사용자입니다.");
        }
    }

    private void validationUserStatus(User user) {
        if (user.getStatus() == UserStatus.WITHDRAWN) {
            throw new DuplicateUserException("탈퇴한 사용자입니다.");
        } else if (user.getStatus() == UserStatus.DORMANT) {
            throw new DuplicateUserException("휴먼상태 사용자입니다.");
        }
    }

    // 사용자 전체 조회
    public List<User> findUsers() {
        return userRepository.findAll();
    }

    // 사용자 개별 조회
    public User findOne(Long id) {
        return userRepository.findOne(id);
    }

}
