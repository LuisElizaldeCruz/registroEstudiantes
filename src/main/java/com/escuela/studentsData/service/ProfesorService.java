package com.escuela.studentsData.service;

import com.escuela.studentsData.entities.Profesor;

import java.util.List;
import java.util.Optional;

public interface ProfesorService {
    List<Profesor> findAll();

    Optional findById(Long id);

    Profesor save(Profesor profesor);

    Optional<Profesor> update(Long id, Profesor profesor);

    void delete(Long id);
}
