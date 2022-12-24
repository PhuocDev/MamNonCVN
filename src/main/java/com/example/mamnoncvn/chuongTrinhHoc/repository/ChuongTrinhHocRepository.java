package com.example.mamnoncvn.chuongTrinhHoc.repository;

import com.example.mamnoncvn.chuongTrinhHoc.entity.ChuongTrinhHoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ChuongTrinhHocRepository extends JpaRepository<ChuongTrinhHoc, Long> {
    @Transactional
    @Modifying
    @Query(value = "select * from chuong_trinh_hoc t where t.id like %?1% " +
            " or t.ten_cth like %?1% " +
            " or t.description like %?1% or t.ma_lop like %?1% " +
            " or t.noi_dung like %?1% " +
            " order by t.id asc  ", nativeQuery = true)
    List<ChuongTrinhHoc> findAllByKeyword(String keyword);
}
