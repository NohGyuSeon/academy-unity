package com.daonplace.springbootweb.repository.user;

import com.daonplace.springbootweb.domain.user.board.Board;
import java.util.List;
import javax.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class BoardRepository {

    private final EntityManager em;

    public void save(Board board) {
        if (board.getId() == null) {
            em.persist(board);
        } else {
            em.merge(board);
        }
    }

    public Board findOne(Long id) {
        return em.find(Board.class, id);
    }

    public List<Board> findAll() {
        return em.createQuery("select board from Board board", Board.class)
            .getResultList();
    }

}
