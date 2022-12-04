package com.example.mamnoncvn.accountManager.accountPH.repository;

import com.example.mamnoncvn.accountManager.accountPH.entity.PhuHuynhAccount;
import com.example.mamnoncvn.student.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface PhuHuynhRepository extends JpaRepository<PhuHuynhAccount, Long> {

    @Transactional
    @Modifying
    @Query(value = "select * from phu_huynh_account t where t.id like %?1% " +
            " or t.username like %?1% or t.ten_phu_huynh like %?1% " +
            " or t.dia_chi like %?1% or t.email like %?1% " +
            " or t.so_dien_thoai like %?1% or t.student_id like %?1% " +
            " order by t.id asc ", nativeQuery = true)
    List<PhuHuynhAccount> findAllByKeyword(String keyword);
//
//    @Transactional
//    @Modifying
//    @Query(value = "select * from student t where t.gioi_tinh like %?1% " +
//            " order by t.id asc  ", nativeQuery = true)
//    List<Student> findAllByCategoryGioiTinh(String keyword);
//
//    @Transactional
//    @Modifying
//    @Query(value = "select * from student t where t.class_id like %?1% " +
//            " order by t.id asc  ", nativeQuery = true)
//    List<Student> findAllByCategoryClassId(String keyword);
//
//    @Transactional
//    @Modifying
//    @Query(value = "select * from student t where t.ten_phu_huynh like %?1% " +
//            " order by t.id asc  ", nativeQuery = true)
//    List<Student> findAllByCategoryTenPH(String keyword);
}
