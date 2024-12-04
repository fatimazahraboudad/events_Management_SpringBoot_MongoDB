package com.example.evenementCrud.mappers;

import com.example.evenementCrud.dtos.EvenementDto;
import com.example.evenementCrud.entities.Evenement;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EvenementMapper {


    EvenementMapper mapper = Mappers.getMapper(EvenementMapper.class);
    Evenement toEntity(EvenementDto evenementDto);

    EvenementDto toDto(Evenement evenement);

    List<Evenement> toEntities(List<EvenementDto> evenementDtos);
    List<EvenementDto> toDtos(List<Evenement> evenemens);
}
