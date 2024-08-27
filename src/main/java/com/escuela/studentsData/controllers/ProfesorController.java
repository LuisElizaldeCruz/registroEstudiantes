package com.escuela.studentsData.controllers;

import com.escuela.studentsData.entities.Profesor;
import com.escuela.studentsData.service.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/profesor")
public class ProfesorController {

    @Autowired
    private ProfesorService profesorService;

    @GetMapping
    public ResponseEntity<List<Profesor>> listProfesores() {
        List<Profesor> profesores = profesorService.findAll();
        return ResponseEntity.ok(profesores);
    }

    @GetMapping("/obtener/{id}")
    public Profesor econtrarProfesor(@PathVariable Long id) {
        Optional<Profesor> profesor = profesorService.findById(id);

        if (!profesor.isPresent()) {
            throw new RuntimeException("Profesor no encontrado con id: " + id);
        }
        return profesor.get();

    }

    @PostMapping("/crear")
    public Profesor crearProfesor(@RequestBody Profesor profesor){
        return profesorService.save(profesor);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> actualizarProfesor(@PathVariable Long id, @RequestBody Profesor profesor) {
        try {
            Optional<Profesor> profesorBd = profesorService.update(id, profesor);
            return ResponseEntity.ok(profesorBd);
        }catch(RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


}
