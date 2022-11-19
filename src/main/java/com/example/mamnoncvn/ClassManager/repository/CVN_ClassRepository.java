package com.example.mamnoncvn.ClassManager.repository;

import com.example.mamnoncvn.ClassManager.entity.CVN_Class;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface CVN_ClassRepository extends JpaRepository<CVN_Class, Long> {

    @Transactional
    @Modifying
    @Query(value = "select * from class c where c.id like %?1% " +
            " or c.name like %?1% " +
            " or c.ten_giao_vien1 like %?1% or c.ten_giao_vien2 like %?1% " +
            " order by c.id desc  ", nativeQuery = true)
    List<CVN_Class> findAllByKeyword(String keyword);
}
