package com.daonplace.springbootweb.domain.user.board;

import static javax.persistence.FetchType.LAZY;

import com.daonplace.springbootweb.domain.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "board")
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Long id;

    @JsonIgnore
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private String title;

    private String content;

    @Enumerated(EnumType.STRING)
    @Column(name = "board_type")
    private BoardType boardType;

    @Enumerated(EnumType.STRING)
    @Column(name = "board_status")
    private BoardStatus boardStatus;

    private int count;
    
    //==비즈니스 로직==//
    public void countUp() {
        this.count++;
    }

    public void countDown() {
        this.count--;
    }

}
