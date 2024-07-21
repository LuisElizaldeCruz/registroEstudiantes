package com.escuela.studentsData.controllers;

import com.escuela.studentsData.entities.Academia;
import com.escuela.studentsData.service.AcademiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/academia")
public class AcademiaController {

    @Autowired
    private AcademiaService academiaService;

    /*
    @GetMapping("/obtener/{id}")
    public Academia getAcademia(@PathVariable Long id) {
        return (Academia) academiaService.findById(id).orElse(null);
    }
    */
    /*
    @GetMapping
    public List<Academia> listarAcademias() {
        return academiaService.findAll();
    }
    */

    @GetMapping
    public ResponseEntity<List<Academia>> getAll() {

        List<Academia> academias = academiaService.findAll();
        return ResponseEntity.ok(academias);
    }


    @GetMapping("/obtener/{id}")
    public Academia econtrarAcademia(@PathVariable Long id) {
       Optional <Academia> academia = academiaService.findById(id);

       if(!academia.isPresent()) {
           throw new RuntimeException("Academia no encontrada con id: " + id);
       }
       //retorna el usuario con el id pasado en la url
        return academia.get();
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> updateAcademy(@PathVariable Long id, @RequestBody Academia academia){
        Optional <Academia> academy = academiaService.update(id, academia);

        if(academy.isPresent()) {
            return ResponseEntity.ok(academy);
        }
        else{
            throw new RuntimeException("Academia no encontrada con id: " + id);
        }

    }

    @PostMapping("/crear")
    public Academia crearAcademia(@RequestBody Academia academia) {
        return academiaService.save(academia);
    }


    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarAcademia(@PathVariable Long id){
        Optional <Academia> academia = academiaService.findById(id);

        if(!academia.isPresent()) {
            throw new RuntimeException("Academia no encontrada con id: " + id);
        }
        academiaService.deleteById(id);

        return ResponseEntity.ok().build();
    }

}
