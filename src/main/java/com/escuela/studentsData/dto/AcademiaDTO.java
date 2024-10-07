package com.escuela.studentsData.dto;

import com.escuela.studentsData.entities.Profesor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class AcademiaDTO {
    private final Long id;
    private final String nombre;
    private final String telefono;
    private final String web;
    private List<ProfesorDTO> profesores= new ArrayList<>();

}
