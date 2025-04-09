package com.example.evenementCrud.mappers;

import com.example.evenementCrud.dtos.InvitedDto;
import com.example.evenementCrud.entities.Invited;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface InvitedMapper {
    InvitedMapper mapper = Mappers.getMapper(InvitedMapper.class);

    Invited toEntity(InvitedDto invitedDto);

    InvitedDto toDto(Invited invited);
    List<InvitedDto> toDtos(List<Invited> inviteds);
}
