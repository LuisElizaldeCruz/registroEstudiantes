package com.escuela.studentsData.service.impl;

import com.escuela.studentsData.Repository.ProfesorRepository;
import com.escuela.studentsData.entities.Profesor;
import com.escuela.studentsData.service.ProfesorService;
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
        return profesorRepository.findAll();
    }

    @Override
    public Optional findById(Long id) {
        return profesorRepository.findById(id);
    }

    @Override
    public Profesor save(Profesor profesor) {
        return profesorRepository.save(profesor);
    }

    @Override
    public Profesor update(Long id, Profesor profesor) {
       Profesor profesorBd = profesorRepository.findById(id).orElseThrow(() -> new RuntimeException("Profesr no encontrado con id: " + id));

       //obtiene los datos del objeto actualizado
        profesorBd.setNombre(profesor.getNombre());
        profesorBd.setApellidos(profesor.getApellidos());
        profesorBd.setEmail(profesor.getEmail());
        profesorBd.setTelefono(profesor.getTelefono());

        //guardado del objeto actualizado a la base de datos
        return profesorRepository.save(profesorBd);
    }

    @Override
    public void delete(Long id) {
        profesorRepository.deleteById(id);
    }
}
