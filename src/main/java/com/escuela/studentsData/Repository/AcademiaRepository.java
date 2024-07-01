package com.escuela.studentsData.Repository;

import com.escuela.studentsData.entities.Academia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcademiaRepository extends JpaRepository <Academia,Long>{
}
