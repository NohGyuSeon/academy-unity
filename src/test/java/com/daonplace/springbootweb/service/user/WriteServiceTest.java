//package com.daonplace.springbootweb.service.user;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import com.daonplace.springbootweb.domain.user.User;
//import com.daonplace.springbootweb.domain.user.UserStatus;
//import com.daonplace.springbootweb.domain.user.Write;
//import com.daonplace.springbootweb.domain.user.WriteStatus;
//import com.daonplace.springbootweb.domain.user.board.ParentingBoard;
//import com.daonplace.springbootweb.repository.user.WriteRepository;
//import javax.persistence.EntityManager;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.transaction.annotation.Transactional;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@Transactional
//public class WriteServiceTest {
//
//    @Autowired
//    EntityManager em;
//
//    @Autowired
//    WriteService writeService;
//
//    @Autowired
//    WriteRepository writeRepository;
//
//    @Test(timeout = 1000)
//    public void 게시글_작성() throws Exception {
//        //given
//        User user = createUser();
//        ParentingBoard parentingBoard = createParentingBoard("다둥이 엄마의 아침",
//            "오늘도 다둥이들과 함께 신나는 하루~~ *^^*");
//
//        //when
//        Long writeId = writeService.write(user.getId(), parentingBoard.getId());
//
//        //then
//        Write getWrite = writeRepository.findOne(writeId);
//
//        assertEquals(WriteStatus.write, getWrite.getStatus(), "게시글 작성시 상태는 WRITE");
//        assertEquals(1, getWrite.getBoard().getCount(), "게시글 작성시 개수는 1개");
//        assertNotNull(parentingBoard);
//    }
//
//    @Test(timeout = 1000)
//    public void 게시글_취소() throws Exception {
//        //given
//        User user = createUser();
//        ParentingBoard parentingBoard = createParentingBoard("다둥이 엄마의 아침",
//            "오늘도 다둥이들과 함께 신나는 하루~~ *^^*");
//
//        Long writeId = writeService.write(user.getId(), parentingBoard.getId());
//
//        //when
//        writeService.cancelWrite(writeId);
//
//        //then
//        Write getWrite = writeRepository.findOne(writeId);
//
//        assertEquals(WriteStatus.cancel, getWrite.getStatus(), "게시글 취소시 상태는 CANCEL 이다.");
//        assertEquals(0, getWrite.getBoard().getCount(), "게시글 취소시 개수는 0개");
//    }
//
//    private User createUser() {
//        User user = new User();
//        user.setEmail("user1@daonplace.com");
//        user.setPassword("1234");
//        user.setUsername("빛깔");
//        user.setStatus(UserStatus.registered);
//        em.persist(user);
//        return user;
//    }
//
//    private ParentingBoard createParentingBoard(String title, String Content) {
//        ParentingBoard parentingBoard = new ParentingBoard();
//        parentingBoard.setTitle(title);
//        parentingBoard.setContent(Content);
//        em.persist(parentingBoard);
//        return parentingBoard;
//    }
//
//}
