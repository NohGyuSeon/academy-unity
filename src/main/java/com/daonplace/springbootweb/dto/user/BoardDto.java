package com.daonplace.springbootweb.dto.user;

import com.daonplace.springbootweb.domain.user.board.Board;
import com.daonplace.springbootweb.domain.user.board.BoardType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BoardDto {

    @NotBlank
    private String title;
    @NotBlank
    private String content;
    @NotNull
    private BoardType boardType;

    public Board toEntity() {
        return Board.builder()
            .title(title)
            .content(content)
            .boardType(boardType)
            .build();
    }

}
