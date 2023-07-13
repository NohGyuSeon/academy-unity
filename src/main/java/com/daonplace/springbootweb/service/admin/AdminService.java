package com.daonplace.springbootweb.service.admin;

import com.daonplace.springbootweb.domain.admin.Admin;
import com.daonplace.springbootweb.exception.DuplicateAdminException;
import com.daonplace.springbootweb.repository.admin.AdminRepository;
import java.util.List;
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
        List<Admin> findAdmins = adminRepository.findByEmail(admin.getEmail());
        if (!findAdmins.isEmpty()) {
            throw new DuplicateAdminException("이미 존재하는 관리자입니다.");
        }
    }

    // 관리자 전체 조회
    public List<Admin> findAdmins() {
        return adminRepository.findAll();
    }

    // 사용자 개별 조회
    public Admin findOne(Long id) {
        return adminRepository.findOne(id);
    }

}
