package com.daonplace.springbootweb.repository.admin;

import com.daonplace.springbootweb.domain.admin.Admin;
import com.daonplace.springbootweb.domain.user.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {

    Optional<Admin> findByEmail(String email);

}
