package com.daonplace.springbootweb.dto.admin;

import com.daonplace.springbootweb.domain.admin.Magazine;
import com.daonplace.springbootweb.domain.admin.MagazineStatus;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MagazineDto {

    @NotBlank
    private String title;

    @NotBlank
    private String content;

    @NotNull
    private MagazineStatus magazineStatus;

//    private Image image;

    public Magazine toEntity() {
        return Magazine.builder()
            .title(title)
            .content(content)
            .magazineStatus(magazineStatus)
            .build();
    }

}
