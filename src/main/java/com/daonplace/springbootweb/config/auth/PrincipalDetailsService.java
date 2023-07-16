package com.daonplace.springbootweb.config.auth;

import com.daonplace.springbootweb.domain.user.User;
import com.daonplace.springbootweb.repository.user.UserRepository;
import com.daonplace.springbootweb.service.user.UserService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PrincipalDetailsService implements UserDetailsService {

    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = userService.getUserByEmail(email); // username 대신 email로 로그인, 이후 커스텀 처리 가능성

        return new PrincipalDetails(user);
    }
}
