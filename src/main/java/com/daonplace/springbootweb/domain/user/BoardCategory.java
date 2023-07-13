package com.daonplace.springbootweb.domain.user;

import static javax.persistence.FetchType.LAZY;

import com.daonplace.springbootweb.domain.user.board.Board;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class BoardCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_category_id")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "boardCategory")
    private List<Board> boards = new ArrayList<>();

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "parent_id")
    private BoardCategory parent;

    @OneToMany(mappedBy = "parent")
    private List<BoardCategory> child = new ArrayList<>();

    public void addChildCategory(BoardCategory child) {
        this.child.add(child);
        child.setParent(this);
    }

}
