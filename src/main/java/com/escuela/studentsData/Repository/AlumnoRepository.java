package com.escuela.studentsData.Repository;

import com.escuela.studentsData.entities.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlumnoRepository extends JpaRepository <Alumno, Long> {
}
