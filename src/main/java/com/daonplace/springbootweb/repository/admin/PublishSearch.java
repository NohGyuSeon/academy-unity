package com.daonplace.springbootweb.repository.admin;

import com.daonplace.springbootweb.domain.admin.PublishStatus;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PublishSearch {

    private String username; // 사용자 이름
    private PublishStatus publishStatus; // 메거진 발행 상태[publish, cancel]

}
