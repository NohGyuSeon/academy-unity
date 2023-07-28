package com.daonplace.springbootweb.dto.user;

import com.daonplace.springbootweb.domain.user.Image;
import com.daonplace.springbootweb.domain.user.User;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class ImageUploadDto {

    private MultipartFile file;

    private String caption;

    public Image toEntity(String postImageUrl, User user) {
        return Image.builder()
            .caption(caption)
            .postImageUrl(postImageUrl)
            .user(user)
            .build();
    }


}
