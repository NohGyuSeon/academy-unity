package com.daonplace.springbootweb.domain.user.board;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("F")
@Getter
@Setter
public class FreeBoard extends Board {

    private String nickname;

}
