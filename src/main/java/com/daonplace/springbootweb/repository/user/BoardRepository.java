package com.daonplace.springbootweb.repository.user;

import com.daonplace.springbootweb.domain.user.board.Board;
import com.daonplace.springbootweb.domain.user.board.BoardType;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {

    List<Board> findByBoardType(BoardType boardType);

    List<Board> findAllByBoardType(BoardType boardType);

    List<Board> findByTitleContaining(String keyword);

}
