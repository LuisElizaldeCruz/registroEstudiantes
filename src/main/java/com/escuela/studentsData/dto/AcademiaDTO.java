package com.escuela.studentsData.dto;

import com.escuela.studentsData.entities.Profesor;

import java.util.ArrayList;
import java.util.List;

public class AcademiaDTO {
    private final String nombre;
    private final String telefono;
    private final String web;
    private List<ProfesorDTO> profesores= new ArrayList<>();

    public AcademiaDTO(String nombre, String telefono, String web) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.web = web;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getWeb() {
        return web;
    }

    public List<ProfesorDTO> getProfesores() {
        return profesores;
    }
}
