package com.daonplace.springbootweb.domain.user.board;

import static javax.persistence.FetchType.LAZY;

import com.daonplace.springbootweb.domain.user.BoardCategory;
import com.daonplace.springbootweb.domain.user.Write;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
@Getter
@Setter
public abstract class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Long id;

    @OneToOne(fetch = LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "write_id")
    private Write write;

    private String title;

    private String content;

    private int count;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "board_category_id")
    private BoardCategory boardCategory;

    /**
     * 게시글 개수 증가
     */
    //==비즈니스 로직==//
    public void countUp() {
        this.count++;
    }

    /**
     * 게시글 개수 감소
     */
    public void countDown() {
        this.count--;
    }

}
