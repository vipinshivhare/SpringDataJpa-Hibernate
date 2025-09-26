package com.vipinshivhare.jpahibernate.repository;

import com.vipinshivhare.jpahibernate.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.annotation.Target;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
