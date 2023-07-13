package com.daonplace.springbootweb.domain.user.board;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("P")
@Getter
@Setter
public class ParentingBoard extends Board {

    private int age;

    private int childAge;

}
