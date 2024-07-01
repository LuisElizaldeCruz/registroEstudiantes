package com.escuela.studentsData.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Academia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String telefono;
    private String web;

    @OneToMany(mappedBy = "academia")
    private List<Profesor> profesor;

    @OneToMany(mappedBy = "academia")
    private List<Alumno> listaAlumnos;

    public Academia() {
    }

    public Academia(Long id, String nombre, String telefono, String web) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.web = web;
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

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Profesor> getProfesor() {
        return profesor;
    }

    public void setProfesor(List<Profesor> profesor) {
        this.profesor = profesor;
    }

    public List<Alumno> getAlumno() {
        return listaAlumnos;
    }

    public void setAlumnos(List<Alumno> ListaAlumnos) {
        this.listaAlumnos = ListaAlumnos;
    }

    @Override
    public String toString() {
        return "Academias{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                ", web='" + web + '\'' +
                '}';
    }
}
