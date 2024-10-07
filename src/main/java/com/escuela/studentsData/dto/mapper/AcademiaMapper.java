package com.escuela.studentsData.dto.mapper;


import com.escuela.studentsData.dto.AcademiaDto;
import com.escuela.studentsData.entities.Academia;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AcademiaMapper {
    AcademiaMapper mapper = Mappers.getMapper(AcademiaMapper.class);// se crea una instancia de mapper

    AcademiaDto academiaToAcademiaDto(Academia academia);

    Academia academiaDtoToAcademia(AcademiaDto academiaDto);
}
