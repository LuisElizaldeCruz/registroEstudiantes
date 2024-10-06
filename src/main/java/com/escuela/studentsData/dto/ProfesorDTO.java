package com.escuela.studentsData.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


public class ProfesorDTO implements Serializable {
    private final String nombre;
    private final String apellidos;
    private final String email;
    private final String telefono;
    private final  AcademiaDTO academia;


    public ProfesorDTO(String nombre, String apellidos, String email, String telefono, AcademiaDTO academia) {
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

    public AcademiaDTO getAcademia() {
        return academia;
    }
}
