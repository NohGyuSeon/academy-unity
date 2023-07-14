package com.daonplace.springbootweb.config.auth;

import com.daonplace.springbootweb.domain.user.User;
import com.daonplace.springbootweb.repository.user.UserRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PrincipalDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        List<User> users = userRepository.findByEmail(email);// username 대신 email로 로그인, 이후 커스텀 처리 가능성

        if (users.isEmpty()) {
            throw new UsernameNotFoundException("User not found with email: " + email);
        } else {
            User user = users.get(0);
            
            return new PrincipalDetails(user);
        }
    }
}
