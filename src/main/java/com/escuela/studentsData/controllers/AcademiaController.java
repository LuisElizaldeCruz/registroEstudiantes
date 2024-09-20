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

    @PostMapping("/crear")
    public ResponseEntity<Academia> crearAcademia(@RequestBody Academia academia) {
        try {
            Academia savedAcademia = academiaService.save(academia);
            return new ResponseEntity<>(savedAcademia,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/todo")
    public List<Academia> getAll() {
         List<Academia> academias = academiaService.findAll();
        return ResponseEntity.ok(academias).getBody();
    }

    @GetMapping("/obtener/{id}")
    public ResponseEntity<?> econtrarAcademia(@PathVariable Long id) {
        Optional<Academia> academia = academiaService.findById(id);
       if (academia.isPresent())
           return ResponseEntity.ok(academia);
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("academia no encontrada con id: "+id);
        }
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

        if (academia.isPresent()) {
            academiaService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("academia no encontrada con id: "+id);
        }
    }

}
