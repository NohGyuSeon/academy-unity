package com.daonplace.springbootweb.service.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import com.daonplace.springbootweb.domain.user.User;
import com.daonplace.springbootweb.exception.DuplicateUserException;
import com.daonplace.springbootweb.repository.user.UserRepository;
import javax.persistence.EntityManager;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class UserServiceTest {

    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    EntityManager em;

    @Test
    public void 사용자_회원가입() throws Exception {
        //given
        User user = new User();
        user.setEmail("kusun1020@gmail.com");

        //when
        Long saveId = userService.join(user);

        //then
        em.flush();
        assertEquals(user, userRepository.findOne(saveId));
    }

    @Test(expected = DuplicateUserException.class)
    public void 중복_사용자_예외() throws Exception {
        //given
        User user1 = new User();
        user1.setEmail("daon1@gmail.com");

        User user2 = new User();
        user2.setEmail("daon1@gmail.com");

        //when
        userService.join(user1);
        userService.join(user2);

        //then
        fail("사용자 중복 예외가 발생해야 한다.");
    }

}
