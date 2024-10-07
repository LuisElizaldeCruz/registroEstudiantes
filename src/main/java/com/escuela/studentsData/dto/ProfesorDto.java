package com.escuela.studentsData.dto;

import java.io.Serializable;


public class ProfesorDto implements Serializable {
    private final String nombre;
    private final String apellidos;
    private final String email;
    private final String telefono;
    private final AcademiaDto academia;


    public ProfesorDto(String nombre, String apellidos, String email, String telefono, AcademiaDto academia) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.telefono = telefono;
        this.academia = academia;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

    public AcademiaDto getAcademia() {
        return academia;
    }
}
