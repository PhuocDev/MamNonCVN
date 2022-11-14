package com.example.mamnoncvn.GiaoVienCVN.repository;

import com.example.mamnoncvn.GiaoVienCVN.entity.GiaoVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GiaoVienRepository extends JpaRepository<GiaoVien, Long> {
    GiaoVien findByhoTen(String hoTen);
}
