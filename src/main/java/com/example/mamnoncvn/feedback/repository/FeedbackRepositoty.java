package com.example.mamnoncvn.feedback.repository;

import com.example.mamnoncvn.feedback.entity.Feedback;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepositoty extends JpaRepository<Feedback, Long> {

    Page<Feedback> findByTenNguoiGuiContaining(String name, Pageable pageable);
}
