package com.daonplace.springbootweb.domain.user;

import static javax.persistence.FetchType.LAZY;

import com.daonplace.springbootweb.domain.user.board.Board;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Write {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "write_id")
    private Long id;

    @JsonIgnoreProperties("{writes}")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    private LocalDateTime writeDate;

    @OneToOne(mappedBy = "write", fetch = LAZY)
    private Board board;

    @Enumerated(EnumType.STRING)
    @Column(name = "write_status")
    private WriteStatus status;

    //==연관관계 메소드==//
    public void setUser(User user) {
        this.user = user;
        if (user != null) {
            user.getWrites().add(this);
        }
    }

    public void setBoard(Board board) {
        this.board = board;
        if (board != null) {
            board.setWrite(this);
        }
    }

    //==생성 메소드==//
    public static Write createWrite(User user, Board board) {
        Write write = new Write();
        write.setUser(user);
        write.setBoard(board);

        write.setStatus(WriteStatus.write);
        write.setWriteDate(LocalDateTime.now());

        if (board != null) {
            board.countUp();
        }

        return write;
    }

    //==비즈니스 로직==//
    /**
     * 게시글 작성 취소
     */
    public void cancel() {
        this.setStatus(WriteStatus.cancel);
        if (getBoard() != null) {
            getBoard().countDown();
        }
    }

    @Override
    public String toString() {
        return "Write{" +
            "id=" + id +
            ", writeDate=" + writeDate +
            ", status=" + status +
            '}';
    }

}
