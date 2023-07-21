package com.daonplace.springbootweb.controller.user;

import com.daonplace.springbootweb.config.auth.PrincipalDetails;
import com.daonplace.springbootweb.domain.user.User;
import com.daonplace.springbootweb.domain.user.board.Board;
import com.daonplace.springbootweb.service.user.BoardService;
import com.daonplace.springbootweb.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
@Slf4j
public class BoardController {

    private final BoardService boardService;

    /**
     * 게시글 상세 폼
     */
    @GetMapping("/user/board/{userId}/{boardId}")
    public String detailBoardForm(@PathVariable("userId") Long userId,
        @PathVariable("boardId") Long boardId,
        @AuthenticationPrincipal PrincipalDetails principalDetails, Model model) {
        log.info("call get /user/board/{userId}/{boardId}");

        User user = principalDetails.getUser();
        Board board = boardService.getBoard(boardId);

        model.addAttribute("board", board);
        model.addAttribute("user", user);

        return "user/board";
    }

    /**
     * 게시글 업데이트 폼
     */
    @GetMapping("/user/updateBoard/{userId}/{boardId}")
    public String updateBoardForm(@PathVariable("userId") Long userId,
        @PathVariable("boardId") Long boardId,
        @AuthenticationPrincipal PrincipalDetails principalDetails, Model model) {
        log.info("call get /user/updateBoard/{userId}/{boardId}");

        User user = principalDetails.getUser();
        Board board = boardService.getBoard(boardId);

        model.addAttribute("board", board);
        model.addAttribute("user", user);

        return "user/updateBoard";
    }

}
