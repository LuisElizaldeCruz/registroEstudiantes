package com.escuela.studentsData.service.impl;

import com.escuela.studentsData.Repository.ProfesorRepository;
import com.escuela.studentsData.entities.Profesor;
import com.escuela.studentsData.service.ProfesorService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfesorServiceImpl implements ProfesorService {

    @Autowired
    private ProfesorRepository profesorRepository;

    @Override
    public List<Profesor> findAll() {
        return (List<Profesor>) profesorRepository.findAll();
    }

    @Override
    public Optional<Profesor> findById(Long id) {
       Optional<Profesor> profesorBD = profesorRepository.findById(id);
       if(profesorBD.isPresent()) {
           return profesorRepository.findById(id);
       }else{
           throw new RuntimeException("Profesor no encontrado con id: " + id);
       }
    }

    @Override
    @Transactional
    public Profesor save(Profesor profesor) {
        return profesorRepository.save(profesor);
    }

    @Override
    public Optional<Profesor> update(Long id, Profesor profesor) {
        Optional<Profesor> profesorOptional = profesorRepository.findById(id);

        if (profesorOptional.isPresent()) {
            Profesor profesorBd = profesorOptional.orElseThrow();
            //obtiene los datos del objeto actualizado
            profesorBd.setNombre(profesor.getNombre());
            profesorBd.setApellidos(profesor.getApellidos());
            profesorBd.setEmail(profesor.getEmail());
            profesorBd.setTelefono(profesor.getTelefono());
            return Optional.of(profesorRepository.save(profesorBd));
        }else{
            throw new RuntimeException("Profesor no encontrado con id: " + id);
        }
        //guardado del objeto actualizado a la base de datos
        //return profesorOptional;
    }

    @Override
    public void delete(Long id) {
        profesorRepository.deleteById(id);
    }
}
