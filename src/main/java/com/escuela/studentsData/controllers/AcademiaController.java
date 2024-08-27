package com.escuela.studentsData.controllers;

import com.escuela.studentsData.entities.Academia;
import com.escuela.studentsData.service.AcademiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/academia")
public class AcademiaController {

    @Autowired
    private AcademiaService academiaService;

    @GetMapping
    public ResponseEntity<List<Academia>> getAll() {
        List<Academia> academias = academiaService.findAll();
        return ResponseEntity.ok(academias);
    }


    @GetMapping("/obtener/{id}")
    public ResponseEntity<?> econtrarAcademia(@PathVariable Long id) {

       try {
           Optional<Academia> academia = academiaService.findById(id);
           return ResponseEntity.ok(academia);
       }catch (RuntimeException e) {
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
       }

    }

    @PostMapping("/crear")
    public Academia crearAcademia(@RequestBody Academia academia) {
        return academiaService.save(academia);
    }


    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> updateAcademy(@PathVariable Long id, @RequestBody Academia academia) {

        try {
            Optional<Academia> academy = academiaService.update(id, academia);
            return ResponseEntity.ok(academy);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarAcademia(@PathVariable Long id) {
        Optional<Academia> academia = academiaService.findById(id);

        if (!academia.isPresent()) {
            throw new RuntimeException("Academia no encontrada con id: " + id);
        }
        academiaService.deleteById(id);

        return ResponseEntity.ok().build();
    }

}
