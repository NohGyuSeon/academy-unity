package com.daonplace.springbootweb.domain.admin;

import static javax.persistence.FetchType.LAZY;

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
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Publish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "publish_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "admin_id")
    private Admin admin;

    private LocalDateTime publishDate;

    @OneToOne(mappedBy = "publish", fetch = LAZY)
    private Magazine magazine;

    @Enumerated(EnumType.STRING)
    private PublishStatus status;

    //==연관관계 메소드==//
    public void setAdmin(Admin admin) {
        this.admin = admin;
        admin.getPublishes().add(this);
    }

    public void setMagazine(Magazine magazine) {
        this.magazine = magazine;
        magazine.setPublish(this);
    }

    //==생성 메소드==//
    public static Publish createPublish(Admin admin, Magazine magazine) {
        Publish publish = new Publish();
        publish.setAdmin(admin);
        publish.setMagazine(magazine);

        publish.setStatus(PublishStatus.PUBLISH);
        publish.setPublishDate(LocalDateTime.now());

        magazine.countUp();

        return publish;
    }

    //==비즈니스 로직==//
    /**
     * 메거진 작성 취소
     */
    public void cancel() {
        this.setStatus(PublishStatus.CANCEL);
        getMagazine().countDown();
    }

}
