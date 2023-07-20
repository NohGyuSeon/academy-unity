package com.daonplace.springbootweb.repository.admin;

import com.daonplace.springbootweb.domain.admin.Magazine;
import com.daonplace.springbootweb.domain.user.board.Board;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MagazineRepository extends JpaRepository<Magazine, Long> {

    List<Magazine> findByTitleContaining(String keyword);

}
