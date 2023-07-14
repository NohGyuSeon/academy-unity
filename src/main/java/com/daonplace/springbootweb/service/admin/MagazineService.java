package com.daonplace.springbootweb.service.admin;

import com.daonplace.springbootweb.domain.admin.Magazine;
import com.daonplace.springbootweb.handler.ex.NotFoundException;
import com.daonplace.springbootweb.repository.admin.MagazineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MagazineService {

    private final MagazineRepository magazineRepository;

    @Transactional
    public void saveMagazine(Magazine magazine) {
        magazineRepository.save(magazine);
    }

    @Transactional
    public Magazine updateMagazine(Long magazineId, String title, String content) {
        Magazine findMagazine = getMagazineById(magazineId);
        findMagazine.setTitle(title);
        findMagazine.setContent(content);
        return findMagazine;
    }

    // 메거진 조회
    protected Magazine getMagazineById(Long magazineId) {
        return magazineRepository.findById(magazineId)
            .orElseThrow(() -> new NotFoundException("존재하지 않는 메거진입니다."));
    }

}
