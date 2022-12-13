package com.example.mamnoncvn.BlogManager.repository;

import com.example.mamnoncvn.BlogManager.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {
    Blog findByTitle(String title);

    @Transactional
    @Modifying
    @Query(value = "select * from blog b where b.id like %?1% or b.title like %?1% " +
            " or b.description like %?1% or b.content like %?1% " +
            " or b.category like %?1% or b.author like %?1% " +
            " order by b.id desc  ", nativeQuery = true)
    List<Blog> findAllByKeyword(String keyword);

    @Transactional
    @Modifying
    @Query(value = "select * from blog b where " +
            " b.category like %?1% " +
            " order by b.id desc  ", nativeQuery = true)
    List<Blog> findAllByCategory(String keyword);

    @Query(value = "select * from blog b where b.category like %?2% and (b.title like %?1% or b.content like %?1%) " +
            " order by b.id desc ", nativeQuery = true)
    List<Blog> findAllInOneCategory( String keyword, String category);
}
