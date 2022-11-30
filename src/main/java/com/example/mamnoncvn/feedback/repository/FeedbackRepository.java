package com.example.mamnoncvn.feedback.repository;

import com.example.mamnoncvn.comment.entity.Comment;
import com.example.mamnoncvn.feedback.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import java.util.List;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
    @Transactional
    @Modifying
    @Query(value = "select * from feedback t where t.id like %?1% " +
            " or t.content like %?1% or t.name like %?1% " +
            " order by t.id asc", nativeQuery = true)
    List<Feedback> findAllByKeyword(String keyword);
}
