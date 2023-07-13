package com.daonplace.springbootweb.repository.user;

import com.daonplace.springbootweb.domain.user.Write;
import javax.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class WriteRepository {

    private final EntityManager em;

    public void save(Write write) {
        em.persist(write);
    }

    public Write findOne(Long id) {
        return em.find(Write.class, id);
    }

//    public List<Write> findAllByString(WriteSearch writeSearch) { }


}
