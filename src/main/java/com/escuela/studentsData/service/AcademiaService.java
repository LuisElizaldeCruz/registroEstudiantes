package com.escuela.studentsData.service;

import com.escuela.studentsData.entities.Academia;

import java.util.List;
import java.util.Optional;

public interface AcademiaService {
    List<Academia> findAll();

    Optional findById(Long id);

    Academia save(Academia academia);

    Academia update(Long id, Academia academia);

    void delete(Long id);

}
