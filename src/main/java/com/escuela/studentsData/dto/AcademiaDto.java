package com.escuela.studentsData.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AcademiaDto {
    private Long id;
    private String nombre;
    private String telefono;
    private String web;
    private List<ProfesorDto> profesores= new ArrayList<>();

}
