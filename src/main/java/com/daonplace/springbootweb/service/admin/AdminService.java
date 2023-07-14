package com.daonplace.springbootweb.service.admin;

import com.daonplace.springbootweb.domain.admin.Admin;
import com.daonplace.springbootweb.handler.ex.DuplicateAdminException;
import com.daonplace.springbootweb.handler.ex.NotFoundException;
import com.daonplace.springbootweb.repository.admin.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AdminService {

    private final AdminRepository adminRepository;

    /**
     * 관리자 회원 가입
     */
    @Transactional
    public Long join(Admin admin) {
        validationDuplicateAdmin(admin); // 중복 관리자 검증
        adminRepository.save(admin);
        return admin.getId();
    }

    private void validationDuplicateAdmin(Admin admin) {
        Admin findAdmin = getAdminById(admin.getId());

        if (findAdmin != null) {
            throw new DuplicateAdminException("이미 존재하는 관리자입니다.");
        }
    }

    // 관리자 조회
    protected Admin getAdminById(Long adminId) {
        return adminRepository.findById(adminId)
            .orElseThrow(() -> new NotFoundException("존재하지 않는 관리자입니다."));
    }

}
