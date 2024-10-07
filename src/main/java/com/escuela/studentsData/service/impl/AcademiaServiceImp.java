package com.escuela.studentsData.service.impl;

import com.escuela.studentsData.Repository.AcademiaRepository;
import com.escuela.studentsData.dto.AcademiaDto;
import com.escuela.studentsData.dto.mapper.AcademiaMapper;
import com.escuela.studentsData.entities.Academia;
import com.escuela.studentsData.service.AcademiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AcademiaServiceImp implements AcademiaService {

    @Autowired
    private AcademiaRepository academiaRepository;

    @Transactional(readOnly = true)
    @Override
    public List<AcademiaDto> findAll() {
       // return (List<Academia>) academiaRepository.findAll();
        List<Academia> academias = (List<Academia>) academiaRepository.findAll();
        List<AcademiaDto> academiaDtos = academias.stream().map(academia -> AcademiaMapper.mapper.academiaToAcademiaDto(academia)).collect(Collectors.toList());
        return academiaDtos;
    }

    @Override
    public Optional findById(Long id) {
        Optional<Academia> academiaBd = academiaRepository.findById(id);
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

    @Override
    public void deleteById(Long id) {
        academiaRepository.deleteById(id);
    }
}


