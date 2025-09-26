package com.vipinshivhare.jpahibernate.repository;

import com.vipinshivhare.jpahibernate.entity.Course;
import com.vipinshivhare.jpahibernate.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;


import java.util.List;


// Ideally when u r fetching the courses u should get the courseMaterial as well
@SpringBootTest
class CourseRepositoryTest {
    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourses(){
        List<Course> courses =
                courseRepository.findAll();

        System.out.println("Courses is : " + courses);
    }

    @Test
    public void saveCourseWithTeacher(){
        Teacher teacher = Teacher.builder()
                .firstName("Bhanu")
                .lastName("Pandey")
                .build();

        Course course =
                Course.builder()
                        .title("Python")
                        .credit(6)
                        .teacher(teacher)
                        .build();

        courseRepository.save(course);

    }


    // Pagination
    @Test
    public void findAllPagination(){
        Pageable firstPagewithThreeRecords =
                PageRequest.of(0,3);
        Pageable secondPagewithThreeRecords =
                PageRequest.of(1,2);

    List<Course> courses = 
            courseRepository.findAll(firstPagewithThreeRecords).getContent();

        System.out.println("Courses = : "+ courses);

    }



}