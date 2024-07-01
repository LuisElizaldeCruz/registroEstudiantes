package com.escuela.studentsData.service;

import com.escuela.studentsData.entities.Profesor;

import java.util.List;
import java.util.Optional;

public interface ProfesorService {
    List<Profesor> findAll();

    Optional findById(Long id);

    Profesor save(Profesor profesor);

    Profesor update(Long id, Profesor estudiante);

    void delete(Long id);
}
