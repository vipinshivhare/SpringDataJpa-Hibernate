package com.vipinshivhare.jpahibernate.repository;

import com.vipinshivhare.jpahibernate.entity.CourseMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseMaterialRepository extends JpaRepository <CourseMaterial, Long> {



}
