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
    public Academia update(Long id, Academia academia) {
        Academia academiaBd = academiaRepository.findById(id).orElse(null);
        if(academiaBd != null){
            academiaBd.setNombre(academiaBd.getNombre());
        }
        return null;
    }

    @Override
    public void deleteById(Long id) {
        academiaRepository.deleteById(id);
    }
}


