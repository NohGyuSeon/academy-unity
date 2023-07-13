package com.daonplace.springbootweb.domain.user;

import static javax.persistence.FetchType.LAZY;

import com.daonplace.springbootweb.domain.user.board.Board;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "writes")
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Write {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "write_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private LocalDateTime writeDate;

    @OneToOne(mappedBy = "write", fetch = LAZY)
    private Board board;

    @Enumerated(EnumType.STRING)
    private WriteStatus status;

    //==연관관계 메소드==//
    public void setUser(User user) {
        this.user = user;
        user.getWrites().add(this);
    }

    public void setBoard(Board board) {
        this.board = board;
        board.setWrite(this);
    }

    //==생성 메소드==//
    public static Write createWrite(User user, Board board) {
        Write write = new Write();
        write.setUser(user);
        write.setBoard(board);

        write.setStatus(WriteStatus.WRITE);
        write.setWriteDate(LocalDateTime.now());

        board.countUp();

        return write;
    }

    //==비즈니스 로직==//
    /**
     * 게시글 작성 취소
     */
    public void cancel() {
        this.setStatus(WriteStatus.CANCEL);
        getBoard().countDown();
    }

}
