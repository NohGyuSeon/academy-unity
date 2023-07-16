package com.daonplace.springbootweb.controller.user;

import com.daonplace.springbootweb.domain.user.User;
import com.daonplace.springbootweb.domain.user.board.Board;
import com.daonplace.springbootweb.dto.auth.SignupDto;
import com.daonplace.springbootweb.service.user.BoardService;
import com.daonplace.springbootweb.service.user.UserService;
import java.awt.print.Book;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
public class BoardController {

    private final UserService userService;
    private final BoardService boardService;

    /**
     * 게시글 상세 폼
     */
    @GetMapping("/user/board/{userId}/{boardId}")
    public String view(@PathVariable("userId") Long userId, @PathVariable("boardId") Long boardId, Model model) {
        log.info("call get /user/board/{userId}/{boardId}");

        User user = userService.getUserById(userId);
        Board board = boardService.getBoard(boardId);
        model.addAttribute("board", board);
        model.addAttribute("user", user);
        return "user/board";
    }

    /**
     * 게시글 업데이트 폼
     */
    @GetMapping("/user/update/{userId}")
    public String updateForm(@PathVariable("userId") Long userId, Model model) {
        log.info("call get /user/update/{userId}");



        return "user/profile";
    }

    /**
     * 게시글 업데이트 POST
     */
    @PostMapping("/user/update/{userId}")
    public String updateForm(@PathVariable Long userId, @ModelAttribute("dto") SignupDto dto) {
        log.info("call post /user/update/{userId}");

        //== 구현 로직 ==//

        return "user/profile";
    }









}
