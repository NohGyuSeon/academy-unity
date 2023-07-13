package com.daonplace.springbootweb.domain.user.board;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("R")
@Getter
@Setter
public class ReportNotificationBoard extends Board {

    private String city;

//    private Address address;

}
