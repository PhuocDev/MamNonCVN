package com.example.mamnoncvn.thoikhoabieu.repository;

import com.example.mamnoncvn.thoikhoabieu.entity.ThoiKhoaBieu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ThoiKhoaBieuRepository extends JpaRepository<ThoiKhoaBieu, Long> {
    @Transactional
    @Modifying
    @Query(value = "select * from thoi_khoa_bieu t where t.id like %?1% " +
            " or t.tentkb like %?1% " +
            " or t.description like %?1% or t.ma_lop like %?1% " +
            " or t.noi_dung like %?1% " +
            " order by t.id desc  ", nativeQuery = true) List<ThoiKhoaBieu> findAllByKeyword(String keyword);
}
