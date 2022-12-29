package com.example.mamnoncvn.dashboard.report;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {


    @Query(value = " select count(*) from student ", nativeQuery = true)
    int getTotalStudent();

//    @Transactional
//    @Modifying
    @Query(value = "select count(*) from giaovien t ", nativeQuery = true)
    int getTotalTeacher();
//
//    @Transactional
//    @Modifying
    @Query(value = "select count(*) from student t where MONTH(t.ngay_nhap_hoc) = MONTH(curdate()) ", nativeQuery = true)
    int getTotalStudentThisMonth();
//
//    @Transactional
//    @Modifying
    @Query(value = "select count(*) from feedback t where MONTH(t.date_created) = MONTH(curdate()) ", nativeQuery = true)
    int getTotalSupportRequestThisMonth();
//
//    @Transactional
//    @Modifying
    @Query(value = "select count(*) from customer t", nativeQuery = true)
    int getTotalPotentialCustomer();
//
//    @Transactional
//    @Modifying
        @Query(value = "select count(*) from blog t ", nativeQuery = true)
        int getTotalBlogs();
//    @Transactional
//    @Modifying
    //@Query(value = "select count(*) from blog t ", nativeQuery = true)
    @Query(value = //"SET sql_mode = '' " +
            "select sum(total) from ( " +
            "select b.name, (b.tuition *count(a.ten_hoc_sinh)) as total " +
            "from student a inner join class b " +
            "on a.class_id = b.id " +
            "group by b.name " +
            ") total "
            , nativeQuery = true)
    Long getTotalIncomeThisMonth();


}
