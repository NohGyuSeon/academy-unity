package com.daonplace.springbootweb.repository.admin;

import com.daonplace.springbootweb.domain.admin.Publish;
import javax.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PublishRepository {

    private final EntityManager em;

    public void save(Publish publish) {
        em.persist(publish);
    }

    public Publish findOne(Long id) {
        return em.find(Publish.class, id);
    }

//    public List<Publish> findAllByString(PublishSearch publishSearch) {}

}
