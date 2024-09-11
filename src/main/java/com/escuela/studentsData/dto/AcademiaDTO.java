package com.escuela.studentsData.dto;

import com.escuela.studentsData.entities.Profesor;

import java.util.ArrayList;
import java.util.List;

public class AcademiaDTO {
    private Long id;
    private String nombre;
    private String telefono;
    private String web;
    private List<ProfesorDTO> profesores= new ArrayList<ProfesorDTO>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public List<ProfesorDTO> getProfesores() {
        return profesores;
    }

    public void setProfesores(List<ProfesorDTO> profesores) {
        this.profesores = profesores;
    }
}
