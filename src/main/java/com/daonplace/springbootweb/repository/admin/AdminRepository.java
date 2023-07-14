package com.daonplace.springbootweb.repository.admin;

import com.daonplace.springbootweb.domain.admin.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {

}
