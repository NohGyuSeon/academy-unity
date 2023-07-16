package com.daonplace.springbootweb.controller.api.user;

import com.daonplace.springbootweb.config.auth.PrincipalDetails;
import com.daonplace.springbootweb.domain.user.board.Board;
import com.daonplace.springbootweb.dto.CMRespDto;
import com.daonplace.springbootweb.service.user.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
@Slf4j
public class BoardApiController {

    private final BoardService boardService;

//    @PostMapping
//    public ResponseEntity<Long> createBoard(@RequestBody BoardDto boardDto, @AuthenticationPrincipal PrincipalDetails principalDetails) {
//        User user = principalDetails.getUser();
//        Long boardId = boardService.createBoard(boardDto, user);
//        return ResponseEntity.ok(boardId);
//    }

    /**
     * 게시글 삭제 POST
     */
    @DeleteMapping("/deleteBoard/{userId}/{boardId}")
    public ResponseEntity<Void> deleteBoard(@PathVariable Long userId, @PathVariable Long boardId) {
        log.info("call delete /api/user/deleteBoard/{userId}/{boardId}");

        // 게시글 삭제 로직 구현
        log.info("boardId={}", boardId);
        boardService.deleteBoard(boardId);

        return ResponseEntity.ok().build();
    }

}
