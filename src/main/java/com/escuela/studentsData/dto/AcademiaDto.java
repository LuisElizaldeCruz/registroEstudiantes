package com.escuela.studentsData.dto;

import com.escuela.studentsData.entities.Profesor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
public class AcademiaDto {
    private Long id;
    private String nombre;
    private String telefono;
    private String web;
    private List<Profesor> profesores;

    public AcademiaDto() {
    }

    public AcademiaDto(Long id, String nombre, String telefono, String web, List<Profesor> profesores) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.web = web;
        this.profesores = profesores;
    }

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

    public List<Profesor> getProfesores() {
        return profesores;
    }

    public void setProfesores(List<Profesor> profesores) {
        this.profesores = profesores;
    }
}
