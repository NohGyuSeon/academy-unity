package com.daonplace.springbootweb.controller.admin;

import com.daonplace.springbootweb.config.auth.PrincipalDetails;
import com.daonplace.springbootweb.domain.admin.Magazine;
import com.daonplace.springbootweb.domain.user.User;
import com.daonplace.springbootweb.domain.user.board.Board;
import com.daonplace.springbootweb.service.admin.MagazineService;
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
public class MagazineController {

    private MagazineService magazineService;

    /**
     * 메거진 상세 폼
     */
    @GetMapping("/admin/magazine/{userId}/{magazineId}")
    public String detailMagazineForm(@PathVariable("userId") Long userId,
        @PathVariable("magazineId") Long magazineId,
        @AuthenticationPrincipal PrincipalDetails principalDetails, Model model) {
        log.info("call get /admin/magazine/{userId}/{magazineId}");

        User user = principalDetails.getUser();
        Magazine magazine = magazineService.getMagazine(magazineId);

        model.addAttribute("magazine", magazine);
        model.addAttribute("user", user);

        return "admin/magazine";
    }
    
    /**
     * 메거진 업데이트 폼
     */
    @GetMapping("/admin/updateMagazine/{userId}/{magazineId}")
    public String updateMagazineForm(@PathVariable("userId") Long userId,
        @PathVariable("magazineId") Long magazineId,
        @AuthenticationPrincipal PrincipalDetails principalDetails, Model model) {
        log.info("call get /admin/updateMagazine/{userId}/{magazineId}");

        User user = principalDetails.getUser();
        Magazine magazine = magazineService.getMagazine(magazineId);

        model.addAttribute("magazine", magazine);
        model.addAttribute("user", user);

        return "admin/updateMagazine";
    }

}
