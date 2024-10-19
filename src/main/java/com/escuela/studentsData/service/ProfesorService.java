package com.escuela.studentsData.service;

import com.escuela.studentsData.dto.ProfesorDto;
import com.escuela.studentsData.entities.Profesor;

import java.util.List;
import java.util.Optional;

public interface ProfesorService {
    List<ProfesorDto> findAll();

    Optional findById(Long id);

    ProfesorDto save(ProfesorDto profesorDto);

    Optional<ProfesorDto> update(Long id, ProfesorDto profesorDto);

    void delete(Long id);
}
