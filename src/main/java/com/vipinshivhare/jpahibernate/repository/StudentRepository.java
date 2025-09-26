package com.vipinshivhare.jpahibernate.repository;

import com.vipinshivhare.jpahibernate.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

//public interface JpaRepository<T, ID> extends ListCrudRepository<T, ID>, ListPagingAndSortingRepository<T, ID>, QueryByExampleExecutor<T>
// ye yha <T, ID> ka matlab --->
//  Ye ek generic interface hai jo Type Parameters ka use karta hai:
// T → Entity CLASS (jo table ko represent karta hai)
// ID → Entity ka primary key (id type)
//Yahan: T = Student → Hamari entity class || ID = Long → studentId ka Primary key type

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByfirstName(String firstName); // you should give same name with findBy__
// you only just need to define you dont need to implement

    List<Student> findByFirstNameContaining(String name);

    List<Student> findByLastNameNotNull();

    List<Student> findByGuardianName(String guardianName);

    List<Student> findByGuardianEmailNull();

    // JPQL query : is defined based on the CLASSES that u had defined not based on
    // the TABLE NAME and TABLE ATTRIBUTE or TABLE NAMES
    @Query("select s from Student s where s.emailId = ?1 ")
    Student getStudentByEmailAddress(String emailId);


    @Query("select s.firstName from Student s where s.emailId = ?1 ")
    String getStudentByFirstName(String emailId);

    // Native Query
    @Query(
           value = "SELECT * from tbl_student s where s.email_address = ?1",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNative(String emailId);


    // Named Parameter Native Query
    @Query(
            value = "SELECT * from tbl_student s where s.email_address = :emailId",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNativeNamedParam(@Param("emailId") String emailId);


    // Modifying query
    @Modifying
    @Transactional
    @Query(
            value = "update tbl_student set first_name = ?1 where email_address = ?2",
            nativeQuery = true
    )
    int updateStudentNameByEmailId(String firstName, String emailId);




}



// TEST class
//
//package com.vipinshivhare.jpahibernate.repository;
//
//import com.vipinshivhare.jpahibernate.entity.Guardian;
//import com.vipinshivhare.jpahibernate.entity.Student;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//class StudentRepositoryTest {
//
//    @Autowired
//    private StudentRepository studentRepository;
//
//    @Test
//    public void saveStudent(){
//        Student student = Student.builder()
//                .emailId("vipinshivhare@gmail.com")
//                .firstName("Vipin")
//                .lastName("Shivhare")
//                // .guardianName("Bharat")
//                // .guardianEmail("shivharevipin@gmail.com")
//                // .guardianMobile("6261932157")
//                .build();
//
//        studentRepository.save(student);
//    }
//
//    @Test
//    public void saveStudentWithGuardian(){
//        Guardian guardian = Guardian.builder()
//                .name("ramanFather")
//                .email("ramanfather@gmail.com")
//                .mobile("123456789")
//                .build();
//
//        Student student = Student.builder()
//                .firstName("Raman")
//                .lastName("Jaat")
//                .emailId("abc@gmail.com")
//                .guardian(guardian)
//                .build();
//
//        studentRepository.save(student);
//    }
//
//    @Test
//    public void printAllStudent(){
//        List <Student> studentList = studentRepository.findAll();
//        System.out.println("StudentList = " + studentList);
//    }
//
//    @Test
//    public void printStudentByFIrstName(){
//        List<Student> studentFirstName =
//                studentRepository.findByfirstName("Vipin");
//        System.out.println("Students is : " + studentFirstName);
//
//    }
//
//    @Test
//    public void printStudentByFirstNameContaining(){
//        List<Student> students =
//                studentRepository.findByFirstNameContaining("ma");
//        System.out.println("Students is : " + students);
//
//    }
//
//    @Test
//    public void printStudentBasedOnGuardianName(){
//        List<Student> students =
//                studentRepository.findByGuardianName("Bharat");
//        System.out.println("Guardian is : " +students );
//    }
//
//    @Test
//    public void printStudentByLastName(){
//        List<Student> students =
//                studentRepository.findByLastNameNotNull();
//        System.out.println("Not null last name is : " + students);
//
//    }
//
//    @Test
//    public void printSGuardianEmailNull(){
//        List<Student> students =
//                studentRepository.findByGuardianEmailNull();
//        System.out.println("NotNull Guardian Email is : " +students );
//    }
//}