package com.daonplace.springbootweb.controller.api.admin;

import com.daonplace.springbootweb.config.auth.PrincipalDetails;
import com.daonplace.springbootweb.domain.admin.Magazine;
import com.daonplace.springbootweb.domain.user.User;
import com.daonplace.springbootweb.domain.user.board.Board;
import com.daonplace.springbootweb.dto.CMRespDto;
import com.daonplace.springbootweb.dto.admin.MagazineDto;
import com.daonplace.springbootweb.dto.user.BoardDto;
import com.daonplace.springbootweb.dto.user.UserDto;
import com.daonplace.springbootweb.service.admin.MagazineService;
import com.daonplace.springbootweb.service.user.BoardService;
import com.daonplace.springbootweb.service.user.UserService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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
@RequestMapping("/api/admin")
@Slf4j
public class AdminApiController {

    private final MagazineService magazineService;
    private final UserService userService;

    /**
     * 메거진 검색 GET
     */
    @GetMapping("/search")
    public CMRespDto<?> searchMagazines(@RequestParam String keyword) {
        log.info("call get /api/admin/search");

        CMRespDto<String> res = new CMRespDto<>(1, "메거진 검색 완료", keyword);
        log.info("call api " + res);

        return res;
    }

    /**
     * 메거진 업데이트 POST
     */
    @PostMapping("/updateMagazine/{userId}/{magazineId}")
    public CMRespDto<?> updateMagazine(@PathVariable Long userId, @PathVariable Long magazineId,
        @Valid MagazineDto magazineDto, BindingResult bindingResult,
        @AuthenticationPrincipal PrincipalDetails principalDetails) {
        log.info("call post /api/admin/updateMagazine/{userId}/{magazineId}");

        Magazine magazineEntity = magazineService.updateMagazine(magazineId, magazineDto.toEntity());

        return new CMRespDto<>(1, "메거진 수정 완료", magazineEntity);
    }

    /**
     * 메거진 삭제 DELETE
     */
    @DeleteMapping("/deleteMagazine/{userId}/{magazineId}")
    public ResponseEntity<Void> deleteBoard(@PathVariable Long userId, @PathVariable Long magazineId) {
        log.info("call delete /api/admin/deleteMagazine/{userId}/{magazineId}");

        // 게시글 삭제 로직 구현
        log.info("magazineId={}", magazineId);
        magazineService.deleteMagazine(magazineId);

        return ResponseEntity.ok().build();
    }

}
