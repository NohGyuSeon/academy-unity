package com.daonplace.springbootweb.repository.admin;

import com.daonplace.springbootweb.domain.admin.Magazine;
import com.daonplace.springbootweb.domain.user.board.Board;
import java.util.List;
import javax.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MagazineRepository {

    private final EntityManager em;

    public void save(Magazine magazine) {
        if (magazine.getId() == null) {
            em.persist(magazine);
        } else {
            em.merge(magazine);
        }
    }

    public Magazine findOne(Long id) {
        return em.find(Magazine.class, id);
    }

    public List<Magazine> findAll() {
        return em.createQuery("select magazine from Magazine magazine", Magazine.class)
            .getResultList();
    }

}
