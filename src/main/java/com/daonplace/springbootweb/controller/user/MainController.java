package com.daonplace.springbootweb.controller.user;

import com.daonplace.springbootweb.config.auth.PrincipalDetails;
import com.daonplace.springbootweb.domain.user.User;
import com.daonplace.springbootweb.domain.user.board.Board;
import com.daonplace.springbootweb.dto.api.AirPollutionInfo;
import com.daonplace.springbootweb.dto.user.BoardDto;
import com.daonplace.springbootweb.dto.user.UserProfileDto;
import com.daonplace.springbootweb.service.api.RestTemplateService;
import com.daonplace.springbootweb.service.user.BoardService;
import com.daonplace.springbootweb.service.user.UserService;
import java.util.List;
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

@Controller
@RequiredArgsConstructor
@Slf4j
public class MainController {

    private final BoardService boardService;
    private final UserService userService;
    private final RestTemplateService restTemplateService;

    /**
     * 사용자 메인 폼
     */
    @GetMapping({"/", "/user/main"})
    public String mainForm(Model model, @AuthenticationPrincipal PrincipalDetails principalDetails,
        @RequestParam(value = "keyword", required = false) String keyword) {
        log.info("call get /user/main");

        User user = principalDetails.getUser();
        List<Board> boards;

        if (keyword != null) {
            boards = boardService.getBoardsByTitleContaining(keyword);
        } else {
            boards = boardService.getBoards();
        }
        AirPollutionInfo airPollutionInfo = restTemplateService.getAirPollution();

        model.addAttribute("boards", boards);
        model.addAttribute("user", user);
        model.addAttribute("airPollutionInfo", airPollutionInfo);

        boolean isHasRoleAdmin = principalDetails.getAuthorities().stream()
            .anyMatch(authority -> authority.getAuthority().equals("ROLE_ADMIN"));

        if (isHasRoleAdmin) {
            return "admin/manage";
        } else {
            return "user/main";
        }
    }

    /**
     * 게시글 작성 폼
     */
    @GetMapping("/user/addBoard")
    public String addBoardForm() {
        log.info("call get /user/addBoard");

        return "user/addBoard";
    }

    /**
     * 게시글 작성 POST
     */
    @PostMapping("/user/addBoard")
    public String addBoard(@ModelAttribute BoardDto boardDto, @AuthenticationPrincipal PrincipalDetails principalDetails) {
        log.info("call post /user/addBoard");

        // 로그인된 사용자 정보 가져오기
        User user = principalDetails.getUser();

        // 게시글 작성
        boardService.createBoard(boardDto, user);

        return "redirect:/user/main"; // 사용자 메인 페이지로 리다이렉트
    }

    /**
     * 프로필 폼
     */
    @GetMapping("/user/profile/{userId}")
    public String profileForm(@PathVariable Long userId, Model model) {
        log.info("call get /user/profile/{userId}");

//        UserProfileDto userProfileDto = userService.profileDto(userId);
        User userEntity = userService.getUserProfile(userId);

        model.addAttribute("user");


        return "user/profile";
    }

}
