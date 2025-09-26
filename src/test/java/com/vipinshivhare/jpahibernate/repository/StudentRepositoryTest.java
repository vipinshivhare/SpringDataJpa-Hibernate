package com.vipinshivhare.jpahibernate.repository;

import com.vipinshivhare.jpahibernate.entity.Guardian;
import com.vipinshivhare.jpahibernate.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .emailId("vipinshivhare@gmail.com")
                .firstName("Vipin")
                .lastName("Shivhare")
               // .guardianName("Bharat")
               // .guardianEmail("shivharevipin@gmail.com")
               // .guardianMobile("6261932157")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian(){
        Guardian guardian = Guardian.builder()
                .name("ramanFather")
                .email("ramanfather@gmail.com")
                .mobile("123456789")
                .build();

        Student student = Student.builder()
                .firstName("Raman")
                .lastName("Jaat")
                .emailId("abc@gmail.com")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudent(){
        List <Student> studentList = studentRepository.findAll();
        System.out.println("StudentList = " + studentList);
    }

    @Test
    public void printStudentByFIrstName(){
        List<Student> studentFirstName =
                studentRepository.findByfirstName("Vipin");
        System.out.println("Students is : " + studentFirstName);

    }

    @Test
    public void printStudentByFirstNameContaining(){
        List<Student> students =
                studentRepository.findByFirstNameContaining("ma");
        System.out.println("Students is : " + students);

    }

    @Test
    public void printStudentBasedOnGuardianName(){
        List<Student> students =
                studentRepository.findByGuardianName("Bharat");
        System.out.println("Guardian is : " +students );
    }

    @Test
    public void printStudentByLastName(){
        List<Student> students =
                studentRepository.findByLastNameNotNull();
        System.out.println("Not null last name is : " + students);

    }

    @Test
    public void printSGuardianEmailNull(){
        List<Student> students =
                studentRepository.findByGuardianEmailNull();
        System.out.println("NotNull Guardian Email is : " +students );
    }


    @Test
    public void printgetStudentByEmailAddress(){
        Student student =
                studentRepository.getStudentByEmailAddress(
                        "vipinshivhare804@gmail.com"
                );
        System.out.println(student);
    }


    @Test
    public void printgetStudentByFirstName(){
        String student =
                studentRepository.getStudentByFirstName(
                        "ramanjaat@gmail.com"
                );
        System.out.println("Name is : " + student);
    }

    @Test
    public void printgetStudentByEmailAddressNative(){
        Student student =
                studentRepository.getStudentByEmailAddressNative(
                        "ramanjaat@gmail.com"
                );
        System.out.println("Name is : " + student);
    }

    @Test
    public void getStudentByEmailAddressNativeNamedParam(){
        Student student =
                studentRepository.getStudentByEmailAddressNativeNamedParam(
                        "ramanjaat@gmail.com"
                );
        System.out.println("STudent = " + student);
    }



    @Test
    public void updateStudentNameByEmailIdTest(){
        studentRepository.updateStudentNameByEmailId(
                "Tipin",
                "vipinshivhare804@gmail.com"
        );
    }

















}