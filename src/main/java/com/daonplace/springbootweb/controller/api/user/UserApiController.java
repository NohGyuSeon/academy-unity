package com.daonplace.springbootweb.controller.api.user;

import com.daonplace.springbootweb.config.auth.PrincipalDetails;
import com.daonplace.springbootweb.domain.user.User;
import com.daonplace.springbootweb.domain.user.board.Board;
import com.daonplace.springbootweb.dto.CMRespDto;
import com.daonplace.springbootweb.dto.user.BoardDto;
import com.daonplace.springbootweb.dto.user.UserDto;
import com.daonplace.springbootweb.service.user.BoardService;
import com.daonplace.springbootweb.service.user.UserService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
@Slf4j
public class UserApiController {

    private final BoardService boardService;
    private final UserService userService;

    /**
     * 사용자 업데이트 POST
     */
    @PostMapping("/updateProfile/{userId}")
    public CMRespDto<?> updateProfile(@PathVariable Long userId,
        @Valid UserDto userDto, @AuthenticationPrincipal PrincipalDetails principalDetails) {
        log.info("call post /api/user/updateProfile/{userId}");

        User userEntity = userService.updateUser(userId, userDto.toEntity());

        principalDetails.setUser(userEntity); // 세션 정보 변경

        CMRespDto<User> res = new CMRespDto<>(1, "프로필 수정 완료", userEntity);
        log.info("call api " + res);

        return res;
        // 응답 시 userEntity의 모든 getter 함수가 호출되고 JSON으로 파싱하여 응답
    }

    /**
     * 사용자 삭제 DELETE
     */
    @DeleteMapping("/deleteUser/{userId}")
    public CMRespDto<?> deleteBoard(@PathVariable Long userId) {
        log.info("call delete /api/user/deleteUser/{userId}");

        // 사용자 삭제 로직 구현
        userService.deleteUser(userId);

        SecurityContextHolder.clearContext(); // 세션 무효화 처리

        CMRespDto<Long> res = new CMRespDto<>(1, "사용자 삭제 완료", userId);
        log.info("call api " + res);

        return res;
    }

    /**
     * 게시글 검색 GET
     */
    @GetMapping("/search")
    public CMRespDto<?> searchBoards(@RequestParam String keyword) {
        log.info("call get /api/user/search");

        CMRespDto<String> res = new CMRespDto<>(1, "게시판 검색 완료", keyword);
        log.info("call api " + res);

        return res;
    }

    /**
     * 게시글 업데이트 POST
     */
    @PostMapping("/updateBoard/{userId}/{boardId}")
    public CMRespDto<?> updateBoard(@PathVariable Long userId, @PathVariable Long boardId,
        @Valid BoardDto boardDto, BindingResult bindingResult,
        @AuthenticationPrincipal PrincipalDetails principalDetails) {
        log.info("call post /api/user/updateBoard/{userId}/{boardId}");

        Board boardEntity = boardService.updateBoard(boardId, boardDto.toEntity());

        return new CMRespDto<>(1, "게시글 수정 완료", boardEntity);
        // 응답 시 boardEntity 모든 getter 함수가 호출되고 JSON으로 파싱하여 응답, 이때 User와의 상호참조로 인한
        // 스택오버플로우가 발생하기 때문에, Board 엔티티의 User 필드에 @JsonIgnore를 추가해야 한다.
    }

    /**
     * 게시글 삭제 DELETE
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
