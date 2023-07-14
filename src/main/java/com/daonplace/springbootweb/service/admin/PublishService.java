package com.daonplace.springbootweb.service.admin;

import com.daonplace.springbootweb.domain.admin.Admin;
import com.daonplace.springbootweb.domain.admin.Magazine;
import com.daonplace.springbootweb.domain.admin.Publish;
import com.daonplace.springbootweb.handler.ex.NotFoundException;
import com.daonplace.springbootweb.repository.admin.PublishRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PublishService {

    private final PublishRepository publishRepository;
    private final AdminService adminService;
    private final MagazineService magazineService;

    /**
     * 메거진 발행
     */
    @Transactional
    public Long publish(Long adminId, Long magazineId) {

        // 엔티티 조회
        Admin admin = adminService.getAdminById(adminId);

        Magazine magazine = magazineService.getMagazineById(magazineId);

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
        Publish publish = getPublishById(publishId);

        // 메거진 발행 취소
        publish.cancel();
    }

    // 발행 조회
    protected Publish getPublishById(Long publishId) {
        return publishRepository.findById(publishId)
            .orElseThrow(() -> new NotFoundException("존재하지 않는 발행입니다."));
    }

}
