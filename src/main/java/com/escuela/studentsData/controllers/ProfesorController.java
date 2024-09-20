package com.escuela.studentsData.controllers;

import com.escuela.studentsData.entities.Profesor;
import com.escuela.studentsData.service.ProfesorService;
import com.escuela.studentsData.service.impl.ProfesorServiceImpl;
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
    public ResponseEntity <List<Profesor>> listProfesores() {
        List<Profesor> profesores = profesorService.findAll();
      return new ResponseEntity<>(profesores, HttpStatus.OK);
    }

    @GetMapping("/obtener/{id}")
    public ResponseEntity<?> econtrarProfesor(@PathVariable Long id) {
        try {
            Optional<Profesor> profesor = profesorService.findById(id);
            return new ResponseEntity<>(profesor.get(), HttpStatus.OK);
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping("/crear")
    public ResponseEntity<Profesor> crearProfesor(@RequestBody Profesor profesor){
        //return profesorService.save(profesor);
        try {
            Profesor savedProfesor = profesorService.save(profesor);
            return new ResponseEntity<>(savedProfesor, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
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

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarProfesor(@PathVariable Long id){
        Optional<Profesor> profesor = profesorService.findById(id);

        if(!profesor.isPresent()){
            throw new RuntimeException("Profesor no encontrado con id: " + id);
        }
        profesorService.delete(id);

        return ResponseEntity.ok().build();
    }


}
