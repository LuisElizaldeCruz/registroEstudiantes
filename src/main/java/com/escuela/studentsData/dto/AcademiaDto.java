package com.escuela.studentsData.dto;

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
    private List<ProfesorDto> profesores= new ArrayList<>();

    public AcademiaDto() {
    }

    public AcademiaDto(Long id, String nombre, String telefono, String web, List<ProfesorDto> profesores) {
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

    public List<ProfesorDto> getProfesores() {
        return profesores;
    }

    public void setProfesores(List<ProfesorDto> profesores) {
        this.profesores = profesores;
    }
}
