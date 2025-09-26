package com.vipinshivhare.jpahibernate.service;

import com.vipinshivhare.jpahibernate.entity.Teacher;
import com.vipinshivhare.jpahibernate.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    public Teacher create(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public List<Teacher> getAll() {
        return teacherRepository.findAll();
    }

    public Optional<Teacher> getById(Long id) {
        return teacherRepository.findById(id);
    }

    public Teacher update(Long id, Teacher teacherDetails) {
        return teacherRepository.findById(id)
                .map(teacher -> {
                    teacher.setFirstName(teacherDetails.getFirstName());
                    teacher.setTeacherId(teacherDetails.getTeacherId());
                    return teacherRepository.save(teacher);
                })
                .orElseThrow(() -> new RuntimeException("Teacher not found with id " + id));
    }

    public String delete(Long id) {
        if (teacherRepository.existsById(id)) {
            teacherRepository.deleteById(id);
            return "Teacher deleted with id " + id;
        }
        return "Teacher not found with id " + id;
    }
}
