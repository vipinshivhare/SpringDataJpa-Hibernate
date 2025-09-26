package com.vipinshivhare.jpahibernate.service;


import com.vipinshivhare.jpahibernate.entity.Student;
import com.vipinshivhare.jpahibernate.repository.StudentRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    // Create
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    // Read All
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Read By Id
    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    // Update
    public Student updateStudent(Long id, Student studentDetails) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            Student existingStudent = optionalStudent.get();
            existingStudent.setFirstName(studentDetails.getFirstName());
            existingStudent.setLastName(studentDetails.getLastName());
            existingStudent.setEmailId(studentDetails.getEmailId());
            return studentRepository.save(existingStudent);
        } else {
            throw new RuntimeException("Student not found with id " + id);
        }
    }

    // Delete
    public String deleteStudent(Long id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return "Student deleted with id " + id;
        } else {
            return "Student not found with id " + id;
        }
    }
}
