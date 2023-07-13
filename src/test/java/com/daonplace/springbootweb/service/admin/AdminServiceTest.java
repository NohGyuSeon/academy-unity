package com.daonplace.springbootweb.service.admin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import com.daonplace.springbootweb.domain.admin.Admin;
import com.daonplace.springbootweb.exception.DuplicateAdminException;
import com.daonplace.springbootweb.repository.admin.AdminRepository;
import javax.persistence.EntityManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class AdminServiceTest {

    @Autowired
    AdminService adminService;
    @Autowired
    AdminRepository adminRepository;
    @Autowired
    EntityManager em;

    @Test(timeout = 1000)
    public void 관리자_회원가입() throws Exception {
        //given
        Admin admin = new Admin();
        admin.setEmail("admin@gamil.com");

        //when
        Long saveId = adminService.join(admin);

        //then
        em.flush();
        assertEquals(admin, adminRepository.findOne(saveId));
    }

    @Test(timeout = 1000, expected = DuplicateAdminException.class)
    public void 중복_관리자_예외() throws Exception {
        //given
        Admin admin1 = new Admin();
        admin1.setEmail("daon1@gmail.com");

        Admin admin2 = new Admin();
        admin2.setEmail("daon1@gmail.com");

        //when
        adminService.join(admin1);
        adminService.join(admin2);

        //then
        fail("관리자 중복 예외가 발생해야 한다.");
    }

}
