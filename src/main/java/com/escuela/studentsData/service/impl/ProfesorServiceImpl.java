package com.escuela.studentsData.service.impl;

import com.escuela.studentsData.Repository.ProfesorRepository;
import com.escuela.studentsData.dto.ProfesorDto;
import com.escuela.studentsData.dto.mapper.AcademiaMapper;
import com.escuela.studentsData.dto.mapper.ProfesorMapper;
import com.escuela.studentsData.entities.Profesor;
import com.escuela.studentsData.service.ProfesorService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProfesorServiceImpl implements ProfesorService {

    @Autowired
    private ProfesorRepository profesorRepository;

    @Override
    public List<ProfesorDto> findAll() {
        List<Profesor> profesores = (List<Profesor>) profesorRepository.findAll();
        return profesores.stream().map(ProfesorMapper.mapperP::profesorToProfesorDto).collect(Collectors.toList());
    }

    @Override
    public Optional<ProfesorDto> findById(Long id) {
       Optional<Profesor> profesorBD = profesorRepository.findById(id);

       return profesorBD.map(profAux -> ProfesorMapper.mapperP.profesorToProfesorDto(profAux));
    }

    @Override
    @Transactional
    public ProfesorDto save(ProfesorDto profesorDto) {
        Profesor profesor = ProfesorMapper.mapperP.profesorDtoToProfesor(profesorDto);
        Profesor profesorSaved = profesorRepository.save(profesor);
        return ProfesorMapper.mapperP.profesorToProfesorDto(profesorSaved);
    }

    @Override
    public Optional<ProfesorDto> update(Long id, ProfesorDto profesorDto) {
        Optional<Profesor> profesorBd = profesorRepository.findById(id);

        if (profesorBd.isPresent()) {
            Profesor profesorToUpdate = profesorBd.get();
            Profesor profesorSave = ProfesorMapper.mapperP.profesorDtoToProfesor(profesorDto);

            //obtiene los datos del objeto actualizado
            profesorToUpdate.setNombre(profesorSave.getNombre());
            profesorToUpdate.setApellidos(profesorSave.getApellidos());
            profesorToUpdate.setEmail(profesorSave.getEmail());
            profesorToUpdate.setTelefono(profesorSave.getTelefono());

            return Optional .of(ProfesorMapper.mapperP.profesorToProfesorDto(profesorRepository.save(profesorToUpdate)));
        }else{
            throw new RuntimeException("Profesor no encontrado con id: " + id);
        }

    }

    @Override
    public void delete(Long id) {
        profesorRepository.deleteById(id);
    }
}
