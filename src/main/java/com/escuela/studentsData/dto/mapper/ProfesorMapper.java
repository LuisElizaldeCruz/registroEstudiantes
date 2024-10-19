package com.escuela.studentsData.dto.mapper;

import com.escuela.studentsData.dto.ProfesorDto;
import com.escuela.studentsData.entities.Profesor;
import org.mapstruct.factory.Mappers;

public interface ProfesorMapper {
    ProfesorMapper mapperP = Mappers.getMapper(ProfesorMapper.class);

    ProfesorDto profesorToProfesorDto(Profesor profesor);

    Profesor profesorDtoToProfesor(ProfesorDto profesorDto);
}
