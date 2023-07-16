package com.daonplace.springbootweb.controller.user;

import com.daonplace.springbootweb.config.auth.PrincipalDetails;
import com.daonplace.springbootweb.domain.user.User;
import com.daonplace.springbootweb.domain.user.board.BoardType;
import com.daonplace.springbootweb.dto.auth.SignupDto;
import com.daonplace.springbootweb.dto.user.BoardDto;
import com.daonplace.springbootweb.service.user.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MainController {

    private final BoardService boardService;

    @GetMapping({"/", "/user/main"})
    public String mainForm() {
        log.info("call list get user/main");

        return "user/main";
    }

    @GetMapping("/user/addBoard")
    public String addBoardForm() {
        log.info("call get user/addBoard");

        return "user/addBoard";
    }

    @PostMapping("/user/addBoard")
    @ResponseBody // 비동기 요청에 대한 응답으로 데이터를 반환하기 위해 사용
    public String addBoard(@RequestParam("title") String title, @RequestParam("content") String content,
        @RequestParam("boardType") BoardType boardType, @AuthenticationPrincipal PrincipalDetails principalDetails) {
        log.info("call post user/addBoard");

        // 로그인된 사용자 정보 가져오기
        User user = principalDetails.getUser();

        // 게시글 정보 생성
        BoardDto boardDto = new BoardDto();
        boardDto.setTitle(title);
        boardDto.setContent(content);
        boardDto.setBoardType(boardType);

        // 게시글 작성
        boardService.createBoard(boardDto, user);

        return "success"; // 요청 성공을 나타내는 데이터를 반환
    }

    @GetMapping("/user/{userId}/profile")
    public String profileForm(@PathVariable int userId) {
        log.info("call get user/profile");

        return "user/profile";
    }

    @GetMapping("/user/{userId}/update")
    public String updateForm(@PathVariable("userId") Long userId, Model model) {
        log.info("call get user/update");

        //== 구현 로직 ==//

        return "user/profile";
    }

    @PostMapping("/user/{userId}/update")
    public String updateForm(@PathVariable Long userId, @ModelAttribute("dto") SignupDto dto) {
        log.info("call post user/update");

        //== 구현 로직 ==//

        return "user/profile";
    }




}
