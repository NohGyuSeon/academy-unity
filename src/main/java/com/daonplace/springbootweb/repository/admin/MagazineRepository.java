package com.daonplace.springbootweb.repository.admin;

import com.daonplace.springbootweb.domain.admin.Magazine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MagazineRepository extends JpaRepository<Magazine, Long> {

}
