package com.vipinshivhare.jpahibernate.controller;



import com.vipinshivhare.jpahibernate.entity.CourseMaterial;
import com.vipinshivhare.jpahibernate.service.CourseMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/course-materials")
public class CourseMaterialController {

    @Autowired
    private CourseMaterialService courseMaterialService;

    @PostMapping
    public CourseMaterial create(@RequestBody CourseMaterial courseMaterial) {
        return courseMaterialService.create(courseMaterial);
    }

    @GetMapping
    public List<CourseMaterial> getAll() {
        return courseMaterialService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<CourseMaterial> getById(@PathVariable Long id) {
        return courseMaterialService.getById(id);
    }

    @PutMapping("/{id}")
    public CourseMaterial update(@PathVariable Long id, @RequestBody CourseMaterial courseMaterial) {
        return courseMaterialService.update(id, courseMaterial);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        return courseMaterialService.delete(id);
    }
}
