package com.daonplace.springbootweb.repository.user;

import com.daonplace.springbootweb.domain.user.User;
import com.daonplace.springbootweb.domain.user.UserStatus;
import java.util.List;
import javax.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final EntityManager em;

    public void save(User user) {
        user.setStatus(UserStatus.REGISTERED);
        em.persist(user);
    }

    public User findOne(Long id) {
        return em.find(User.class, id);
    }

    public List<User> findAll() {
        return em.createQuery("select user from User user", User.class)
            .getResultList();
    }

    public List<User> findByEmail(String email) {
        return em.createQuery("select user from User user where user.email = :email", User.class)
            .setParameter("email", email)
            .getResultList();
    }

}
