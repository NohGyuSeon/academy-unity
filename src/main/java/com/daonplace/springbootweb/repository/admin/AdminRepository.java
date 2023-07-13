package com.daonplace.springbootweb.repository.admin;

import com.daonplace.springbootweb.domain.admin.Admin;
import java.util.List;
import javax.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class AdminRepository {

    private final EntityManager em;

    public void save(Admin admin) {
        em.persist(admin);
    }

    public Admin findOne(Long id) {
        return em.find(Admin.class, id);
    }

    public List<Admin> findAll() {
        return em.createQuery("select admin from Admin admin", Admin.class)
            .getResultList();
    }
    
    public List<Admin> findByEmail(String email) {
        return em.createQuery("select admin from Admin admin where admin.email = :email",
                Admin.class)
            .setParameter("email", email)
            .getResultList();
    }

}
