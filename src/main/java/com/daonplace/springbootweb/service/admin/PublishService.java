package com.daonplace.springbootweb.service.admin;

import com.daonplace.springbootweb.domain.admin.Admin;
import com.daonplace.springbootweb.domain.admin.Magazine;
import com.daonplace.springbootweb.domain.admin.Publish;
import com.daonplace.springbootweb.repository.admin.AdminRepository;
import com.daonplace.springbootweb.repository.admin.MagazineRepository;
import com.daonplace.springbootweb.repository.admin.PublishRepository;
import com.daonplace.springbootweb.repository.admin.PublishSearch;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PublishService {

    private final PublishRepository publishRepository;
    private final AdminRepository adminRepository;
    private final MagazineRepository magazineRepository;

    /**
     * 메거진 발행
     */
    @Transactional
    public Long publish(Long adminId, Long magazineId) {

        // 엔티티 조회
        Admin admin = adminRepository.findOne(adminId);
        Magazine magazine = magazineRepository.findOne(magazineId);

        // 메거진 발행
        Publish publish = Publish.createPublish(admin, magazine);

        // 메거진 저장
        publishRepository.save(publish);

        return publish.getId();
    }

    /**
     * 메거진 발행 취소
     */
    public void cancelPublish(Long publishId) {
        // 메거진 발행 엔티티 조회
        Publish publish = publishRepository.findOne(publishId);

        // 메거진 발행 취소
        publish.cancel();
    }

//    public List<Publish> findPublishes(PublishSearch publishSearch) {}\

}
