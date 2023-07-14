package com.daonplace.springbootweb.repository.user;

import com.daonplace.springbootweb.domain.user.WriteStatus;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class WriteSearch {

    private String username; // 사용자 이름
    private WriteStatus writeStatus; // 게시글 작성 상태[write, cancel]

}
