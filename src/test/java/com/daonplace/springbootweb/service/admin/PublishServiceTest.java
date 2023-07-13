package com.daonplace.springbootweb.service.admin;

import static org.junit.jupiter.api.Assertions.*;

import com.daonplace.springbootweb.domain.admin.Admin;
import com.daonplace.springbootweb.domain.admin.Magazine;
import com.daonplace.springbootweb.domain.admin.Publish;
import com.daonplace.springbootweb.domain.admin.PublishStatus;
import com.daonplace.springbootweb.repository.admin.PublishRepository;
import javax.persistence.EntityManager;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class PublishServiceTest {

    @Autowired
    EntityManager em;

    @Autowired
    PublishService publishService;

    @Autowired
    PublishRepository publishRepository;

    @Test(timeout = 1000)
    public void 메거진_작성() throws Exception {
        //given
        Admin admin = createAdmin();
        Magazine magazine = createMagazine("오늘의 빛깔", "안녕! 빛깔 에디터로 활동하게 된 냠냠박사라고해!");

        //when
        Long publishId = publishService.publish(admin.getId(), magazine.getId());

        //then
        Publish getPublish = publishRepository.findOne(publishId);

        assertEquals(PublishStatus.PUBLISH, getPublish.getStatus(), "메거진 발행시 상태는 PUBLISH");
        assertEquals(1, getPublish.getMagazine().getCount(), "메거진 발행시 개수는 1개");
        assertNotNull(magazine);
    }

    @Test(timeout = 1000)
    public void 메거진_취소() throws Exception {
        //given
        Admin admin = createAdmin();
        Magazine magazine = createMagazine("오늘의 빛깔", "안녕! 빛깔 에디터로 활동하게 된 냠냠박사라고해!");

        Long publishId = publishService.publish(admin.getId(), magazine.getId());

        //when
        publishService.cancelPublish(publishId);

        //then
        Publish getPublish = publishRepository.findOne(publishId);

        assertEquals(PublishStatus.CANCEL, getPublish.getStatus(), "메거진 취소시 상태는 CANCEL 이다.");
        assertEquals(0, getPublish.getMagazine().getCount(), "메거진 취소시 개수는 0개");
    }

    private Admin createAdmin() {
        Admin admin = new Admin();
        admin.setEmail("admin1@daonplace.com");
        admin.setPassword("1234");
        em.persist(admin);
        return admin;
    }

    private Magazine createMagazine(String title, String content) {
        Magazine magazine = new Magazine();
        magazine.setTitle(title);
        magazine.setContent(content);
        em.persist(magazine);
        return magazine;
    }

}
