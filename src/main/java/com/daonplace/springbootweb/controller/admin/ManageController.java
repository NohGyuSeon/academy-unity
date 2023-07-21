package com.daonplace.springbootweb.controller.admin;

import com.daonplace.springbootweb.config.auth.PrincipalDetails;
import com.daonplace.springbootweb.domain.admin.Magazine;
import com.daonplace.springbootweb.domain.user.User;
import com.daonplace.springbootweb.dto.admin.MagazineDto;
import com.daonplace.springbootweb.service.admin.MagazineService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@Slf4j
public class ManageController {

    private final MagazineService magazineService;

    /**
     * 관리자 메인 폼
     */
    @GetMapping("/admin/manage")
    public String manageForm(Model model,
        @AuthenticationPrincipal PrincipalDetails principalDetails,
        @RequestParam(value = "keyword", required = false) String keyword) {
        log.info("call get /admin/manage");

        User user = principalDetails.getUser();
        List<Magazine> magazines;

        if (keyword != null) {
            magazines = magazineService.getMagazineByTitleContaining(keyword);
        } else {
            magazines = magazineService.getMagazines();
        }

        model.addAttribute("magazines", magazines);
        model.addAttribute("user", user); // 관리자 권한을 가진 사용자로 구현

        return "admin/manage";
    }

    /**
     * 메거진 작성 폼
     */
    @GetMapping("/admin/addMagazine")
    public String addMagazineForm() {
        log.info("call get /admin/addMagazine");

        return "admin/addMagazine";
    }
    
    /**
     * 메거진 작성 POST
     */
    @PostMapping("/admin/addMagazine")
    public String addMagazine(@ModelAttribute MagazineDto magazineDto, @AuthenticationPrincipal PrincipalDetails principalDetails) {
        log.info("call post /admin/addMagazine");

        // 로그인된 사용자(관리자) 정보 가져오기
        User user = principalDetails.getUser();

        // 게시글 작성
        magazineService.createMagazine(magazineDto, user);

        return "redirect:/admin/manage"; // 관리자 메인 페이지로 리다이렉트
    }

}
