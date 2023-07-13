package com.daonplace.springbootweb.domain.user.board;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("Q")
@Getter
@Setter
public class QnaBoard extends Board {

    @Enumerated(EnumType.STRING)
    private QnaStatus status;

}
