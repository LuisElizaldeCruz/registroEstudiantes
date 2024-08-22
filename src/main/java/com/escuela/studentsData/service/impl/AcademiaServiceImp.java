package com.escuela.studentsData.service.impl;

import com.escuela.studentsData.Repository.AcademiaRepository;
import com.escuela.studentsData.entities.Academia;
import com.escuela.studentsData.service.AcademiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AcademiaServiceImp implements AcademiaService {

    @Autowired
    private AcademiaRepository academiaRepository;


    @Override
    public List<Academia> findAll() {
        return academiaRepository.findAll();
    }

    @Override
    public Optional findById(Long id) {
        return academiaRepository.findById(id);
    }

    @Override
    public Academia save(Academia academia) {
        return academiaRepository.save(academia);
    }


    @Override
    public Optional<Academia> update(Long id, Academia academia) {
       // Academia academiaBd = academiaRepository.findById(id).orElse(null);
        Optional<Academia> academiaBd = academiaRepository.findById(id);
        if(academiaBd.isPresent()){
          Academia academiaToUpdate = academiaBd.get();

          //actualizacion de campos con nuevos datos de la entidad
            academiaToUpdate.setNombre(academia.getNombre());
            academiaToUpdate.setTelefono(academia.getTelefono());
            academiaToUpdate.setWeb(academia.getWeb());
             return Optional.of(academiaRepository.save(academiaToUpdate));
            //return academiaBd;
        }
        else{
            throw new RuntimeException("Academia no encontrada con id: " + id);
        }
    }


    /*
    @Override
    public Academia update(Long id, Academia academia) {
        Academia academiaBd = academiaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Academia no encontrada con id: " + id));

        // Actualización de campos con nuevos datos de la entidad
        academiaBd.setNombre(academia.getNombre());
        academiaBd.setTelefono(academia.getTelefono());
        academiaBd.setWeb(academia.getWeb());

        // Guardado de la entidad actualizada
        return academiaRepository.save(academiaBd);
    }*/


    @Override
    public void deleteById(Long id) {
        academiaRepository.deleteById(id);
    }
}


