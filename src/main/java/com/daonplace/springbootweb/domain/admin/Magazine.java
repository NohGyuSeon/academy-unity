package com.daonplace.springbootweb.domain.admin;

import static javax.persistence.FetchType.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Magazine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "magazine_id")
    private Long id;

    @OneToOne(fetch = LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "publish_id")
    private Publish publish;

    private String title;

    private String content;

    private int count;

    /**
     * 메거진 개수 증가
     */
    //==비즈니스 로직==//
    public void countUp() {
        this.count++;
    }

    /**
     * 메거진 개수 감소
     */
    public void countDown() {
        this.count--;
    }

}
