package com.vipinshivhare.jpahibernate.service;

import com.vipinshivhare.jpahibernate.entity.CourseMaterial;
import com.vipinshivhare.jpahibernate.repository.CourseMaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseMaterialService {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    public CourseMaterial create(CourseMaterial courseMaterial) {
        return courseMaterialRepository.save(courseMaterial);
    }

    public List<CourseMaterial> getAll() {
        return courseMaterialRepository.findAll();
    }

    public Optional<CourseMaterial> getById(Long id) {
        return courseMaterialRepository.findById(id);
    }

    public CourseMaterial update(Long id, CourseMaterial courseMaterialDetails) {
        return courseMaterialRepository.findById(id)
                .map(courseMaterial -> {
                    courseMaterial.setUrl(courseMaterialDetails.getUrl());
                    return courseMaterialRepository.save(courseMaterial);
                })
                .orElseThrow(() -> new RuntimeException("CourseMaterial not found with id " + id));
    }

    public String delete(Long id) {
        if (courseMaterialRepository.existsById(id)) {
            courseMaterialRepository.deleteById(id);
            return "CourseMaterial deleted with id " + id;
        }
        return "CourseMaterial not found with id " + id;
    }
}
