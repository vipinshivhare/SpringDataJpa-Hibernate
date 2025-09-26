package com.vipinshivhare.jpahibernate.repository;

import com.vipinshivhare.jpahibernate.entity.Course;
import com.vipinshivhare.jpahibernate.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    Course courseDba = Course.builder()
            .title("DBA")
            .credit(5)
            .build();

    Course courseJava = Course.builder()
            .title("JAVA")
            .credit(8)
            .build();

    @Test
    public void saveTeacher(){
        Teacher teacher =
                Teacher.builder()
                        .firstName("Umesh")
                        .lastName("Gupta")
                       // .courses(List.of(courseDba,courseJava))
                        .build();


        teacherRepository.save(teacher);
    }
}