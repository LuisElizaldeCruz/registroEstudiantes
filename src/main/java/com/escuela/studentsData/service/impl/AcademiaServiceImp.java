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
        List<Academia> academias = (List<Academia>) academiaRepository.findAll();
        return academias.stream().map(academia -> AcademiaMapper.mapper.academiaToAcademiaDto(academia)).collect(Collectors.toList());
    }

    @Override
    public Optional<AcademiaDto> findById(Long id) {
        Optional<Academia> academia = academiaRepository.findById(id);
        // return academiaRepository.findById(id);
        return academia.map(acadAux -> AcademiaMapper.mapper.academiaToAcademiaDto(acadAux));
    }

    @Override
    public AcademiaDto save(AcademiaDto academiaDto) {
        Academia academia = AcademiaMapper.mapper.academiaDtoToAcademia(academiaDto);
        Academia academiaSaved = academiaRepository.save(academia);//se almacena la entidad guardada para devolverla como respuesta
        return AcademiaMapper.mapper.academiaToAcademiaDto(academiaSaved);
    }


    @Override
    public Optional<AcademiaDto> update(Long id, AcademiaDto academia) {
       // Academia academiaBd = academiaRepository.findById(id).orElse(null);
        Optional<Academia> academiaBd = academiaRepository.findById(id);
        if(academiaBd.isPresent()){
            Academia academiaToUpdate = academiaBd.get();
            Academia academiSave = AcademiaMapper.mapper.academiaDtoToAcademia(academia);
           // Academia academiaToSave = academiaRepository.save(academiaToUpdate);

          //actualizacion de campos con nuevos datos de la entidad
            academiaToUpdate.setNombre(academiSave.getNombre());
            academiaToUpdate.setTelefono(academiSave.getTelefono());
            academiaToUpdate.setWeb(academiSave.getWeb());

            return Optional.of(AcademiaMapper.mapper.academiaToAcademiaDto(academiaRepository.save(academiaToUpdate)));
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


