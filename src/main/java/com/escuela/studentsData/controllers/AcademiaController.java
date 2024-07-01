package com.escuela.studentsData.controllers;

import com.escuela.studentsData.entities.Academia;
import com.escuela.studentsData.service.AcademiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/academia")
public class AcademiaController {

    @Autowired
    private AcademiaService academiaService;

    @PostMapping("/crear")
    public Academia crear(@RequestBody Academia academia) {
        return academiaService.save(academia);
    }

    @GetMapping("/obtener/{id}")
    public Academia getAcademia(@PathVariable Long id) {
        return (Academia) academiaService.findById(id).orElse(null);
    }
}
