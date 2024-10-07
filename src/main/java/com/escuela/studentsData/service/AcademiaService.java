package com.escuela.studentsData.service;

import com.escuela.studentsData.dto.AcademiaDto;
import com.escuela.studentsData.entities.Academia;

import java.util.List;
import java.util.Optional;

public interface AcademiaService {
    List<AcademiaDto> findAll();

    Optional findById(Long id);

    Academia save(Academia academia);

    Optional<Academia> update(Long id, Academia academia);

    void deleteById(Long id);

}
