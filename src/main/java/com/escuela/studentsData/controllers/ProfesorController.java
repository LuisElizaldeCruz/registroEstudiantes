package com.escuela.studentsData.controllers;

import com.escuela.studentsData.dto.ProfesorDto;
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
    public ResponseEntity<List<ProfesorDto>> listProfesores() {
        List<ProfesorDto> profesoresDto = profesorService.findAll();
        return new ResponseEntity<>(profesoresDto, HttpStatus.OK);
    }

    @GetMapping("/obtener/{id}")
    public ResponseEntity<?> econtrarProfesor(@PathVariable Long id) {
            Optional<ProfesorDto> profesorDto = profesorService.findById(id);

            if(profesorDto.isPresent()) {
                return ResponseEntity.ok(profesorDto);
            }
            else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("profesor no encontrada con id: "+id);
            }
    }

    @PostMapping("/crear")
    public ResponseEntity<ProfesorDto> crearProfesor(@RequestBody ProfesorDto profesorDto) {
        //return profesorService.save(profesor);
        try {
            ProfesorDto savedProfesor = profesorService.save(profesorDto);
            return new ResponseEntity<>(savedProfesor, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> actualizarProfesor(@PathVariable Long id, @RequestBody ProfesorDto profesorDto) {
        try {
            Optional<ProfesorDto> profesorBd = profesorService.update(id, profesorDto);
            return ResponseEntity.ok(profesorBd);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarProfesor(@PathVariable Long id) {
        Optional<ProfesorDto> profesor = profesorService.findById(id);

        if (profesor.isPresent()) {
            profesorService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("profesor no encontrada con id: " + id);
        }
    }


}
