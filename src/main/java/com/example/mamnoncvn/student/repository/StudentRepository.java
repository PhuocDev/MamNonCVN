package com.example.mamnoncvn.student.repository;

import com.example.mamnoncvn.student.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Transactional
    @Modifying
    @Query(value = "select * from student t where t.id like %?1% " +
            " or t.ten_hoc_sinh like %?1% or t.ten_phu_huynh like %?1% " +
            " or t.dia_chi like %?1% or t.class_id like %?1% " +
            " or t.so_dien_thoai like %?1% " +
            " order by t.id asc  ", nativeQuery = true)
    List<Student> findAllByKeyword(String keyword);
}
