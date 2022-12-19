package com.example.mamnoncvn.users.repository;

import com.example.mamnoncvn.users.entity.AdminEmail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminEmailRepository extends JpaRepository<AdminEmail, Long> {
    boolean existsByEmail(String email);
}
