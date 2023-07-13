package com.daonplace.springbootweb.service.admin;

import com.daonplace.springbootweb.domain.admin.Magazine;
import com.daonplace.springbootweb.repository.admin.MagazineRepository;
import java.util.List;
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
        Magazine findMagazine = magazineRepository.findOne(magazineId);
        findMagazine.setTitle(title);
        findMagazine.setContent(content);
        return findMagazine;
    }

    public List<Magazine> findMagazines() {
        return magazineRepository.findAll();
    }

    public Magazine findOne(Long magazineId) {
        return magazineRepository.findOne(magazineId);
    }

}
