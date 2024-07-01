package com.escuela.studentsData.service;

import com.escuela.studentsData.entities.Alumno;

import java.util.List;
import java.util.Optional;

public interface AlumnoService {

    List<Alumno> findAll();

    Optional findById(Long id);


    Alumno save(Alumno alumno);

    Alumno update(Long id, Alumno alumno);

    void delete(Long id);

}
