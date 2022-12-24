package com.example.mamnoncvn.customer.repository;

import com.example.mamnoncvn.customer.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Transactional
    @Modifying
    @Query(value = "select * from customer c where c.id like %?1% " +
            " or c.ten_be like %?1% " +
            " or c.ten_phu_huynh like %?1%  or c.so_dien_thoai like %?1% " +
            "or c.ghi_chu like %?1% or c.email like %?1% or c.dia_chi like %?1% " +
            " order by c.id desc  ", nativeQuery = true)
    List<Customer> findAllByKeyword(String keyword);
}
