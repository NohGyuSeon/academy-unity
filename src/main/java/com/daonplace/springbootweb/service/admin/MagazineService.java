package com.daonplace.springbootweb.service.admin;

import com.daonplace.springbootweb.domain.admin.Magazine;
import com.daonplace.springbootweb.domain.user.User;
import com.daonplace.springbootweb.dto.admin.MagazineDto;
import com.daonplace.springbootweb.handler.ex.CustomApiException;
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

    /**
     * 메거진 작성
     */
    @Transactional
    public Long createMagazine(MagazineDto magazineDto, User user) {
        Magazine magazine = new Magazine();
        magazine.setTitle(magazineDto.getTitle());
        magazine.setContent(magazineDto.getContent());
        magazine.setMagazineStatus(magazineDto.getMagazineStatus());
        magazine.setUser(user);

        return magazineRepository.save(magazine).getId();
    }

    /**
     * 메거진 수정
     */
    @Transactional
    public Magazine updateMagazine(Long magazineId, Magazine magazine) {
        Magazine magazineEntity = getMagazine(magazineId);

        magazineEntity.setTitle(magazine.getTitle());
        magazineEntity.setContent(magazine.getContent());
        magazineEntity.setMagazineStatus(magazine.getMagazineStatus());

        return magazineEntity;
    }

    /**
     * 메거진 삭제
     */
    @Transactional
    public void deleteMagazine(Long magazineId) {
        getMagazine(magazineId); // 먼저 게시글을 조회하여 존재하는지 확인

        magazineRepository.deleteById(magazineId);
    }

    /**
     * 메거진 전체 가져오기
     */
    @Transactional
    public List<Magazine> getMagazines() {
        return magazineRepository.findAll();
    }

    /**
     * 메거진 가져오기
     */
    @Transactional
    public Magazine getMagazine(Long magazineId) {
        Magazine magazine = magazineRepository.findById(magazineId)
            .orElseThrow(() -> new CustomApiException("찾을 수 없는 메거진입니다."));
        return magazine;
    }

    /**
     * 메거진 제목으로 검색 가져오기
     */
    @Transactional
    public List<Magazine> getMagazineByTitleContaining(String keyword) {
        return magazineRepository.findByTitleContaining(keyword);
    }

}
