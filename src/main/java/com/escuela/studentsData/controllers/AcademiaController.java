package com.escuela.studentsData.controllers;

import com.escuela.studentsData.dto.AcademiaDto;
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

    @GetMapping("/todo")
    public ResponseEntity getAll() {
        List<AcademiaDto> academiaDto = academiaService.findAll();
        return new ResponseEntity(academiaDto, HttpStatus.OK);
    }

    @GetMapping("/obtener/{id}")
    public ResponseEntity<?> econtrarAcademia(@PathVariable Long id) {
        Optional<AcademiaDto> academiaDto = academiaService.findById(id);
        if (academiaDto.isPresent())
            return ResponseEntity.ok(academiaDto);
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("academia no encontrada con id: "+id);
        }
    }


    @PostMapping("/crear")
    public ResponseEntity<AcademiaDto> crearAcademia(@RequestBody AcademiaDto academiaDto) {

        try {
            AcademiaDto savedAcademiaDto = academiaService.save(academiaDto);
            return new ResponseEntity<>(savedAcademiaDto,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> updateAcademy(@PathVariable Long id, @RequestBody AcademiaDto academiaDto) {

        try {
            Optional<AcademiaDto> academyDto = academiaService.update(id, academiaDto);
            return ResponseEntity.ok(academyDto);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarAcademia(@PathVariable Long id) {
        Optional academia = academiaService.findById(id);

        if (academia.isPresent()) {
            academiaService.deleteById(id);
            return new ResponseEntity<>(academia,HttpStatus.OK);
        }else{
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("academia no encontrada con id: "+id);
        }
    }

}
