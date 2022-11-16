package com.example.mamnoncvn.BlogManager.repository;

import com.example.mamnoncvn.BlogManager.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {
}
