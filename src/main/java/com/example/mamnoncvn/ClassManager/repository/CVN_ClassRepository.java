package com.example.mamnoncvn.ClassManager.repository;

import com.example.mamnoncvn.ClassManager.entity.CVN_Class;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CVN_ClassRepository extends JpaRepository<CVN_Class, Long> {
}
