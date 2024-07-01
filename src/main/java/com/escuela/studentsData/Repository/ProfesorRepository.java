package com.escuela.studentsData.Repository;

import com.escuela.studentsData.entities.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesorRepository extends JpaRepository <Profesor,Long> {
}
