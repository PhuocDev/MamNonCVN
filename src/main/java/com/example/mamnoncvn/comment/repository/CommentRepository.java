package com.example.mamnoncvn.comment.repository;

import com.example.mamnoncvn.chuongTrinhHoc.entity.ChuongTrinhHoc;
import com.example.mamnoncvn.comment.Models.mapper.CommentMapper;
import com.example.mamnoncvn.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Transactional
    @Modifying
    @Query(value = "select * from comment t where t.id like %?1% " +
            " or t.content like %?1% or t.name like %?1% " +
            " order by t.id asc", nativeQuery = true)
    List<Comment> findAllByKeyword(String keyword);
}
