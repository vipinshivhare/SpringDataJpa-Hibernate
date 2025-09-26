package com.vipinshivhare.jpahibernate.controller;


import com.vipinshivhare.jpahibernate.entity.Teacher;
import com.vipinshivhare.jpahibernate.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @PostMapping
    public Teacher create(@RequestBody Teacher teacher) {
        return teacherService.create(teacher);
    }

    @GetMapping
    public List<Teacher> getAll() {
        return teacherService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Teacher> getById(@PathVariable Long id) {
        return teacherService.getById(id);
    }

    @PutMapping("/{id}")
    public Teacher update(@PathVariable Long id, @RequestBody Teacher teacher) {
        return teacherService.update(id, teacher);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        return teacherService.delete(id);
    }
}

