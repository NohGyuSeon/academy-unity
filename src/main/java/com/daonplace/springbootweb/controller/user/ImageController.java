package com.daonplace.springbootweb.controller.user;

import com.daonplace.springbootweb.config.auth.PrincipalDetails;
import com.daonplace.springbootweb.dto.user.ImageUploadDto;
import com.daonplace.springbootweb.handler.ex.CustomValidationException;
import com.daonplace.springbootweb.service.user.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class ImageController {

    private final ImageService imageService;

    @GetMapping("/user/image")
    public String imageUpload() {
        return "/user/image";
    }

    @PostMapping("/user/image")
    public String imageUpload(ImageUploadDto imageUploadDto,
        @AuthenticationPrincipal PrincipalDetails principalDetails) {

        imageService.upload(imageUploadDto, principalDetails);

        if (imageUploadDto.getFile().isEmpty()) {
            throw new CustomValidationException("이미지가 첨부되지 않았습니다.", null);
        }

        return "redirect:/user/profile/" + principalDetails.getUser().getId();
    }





}
