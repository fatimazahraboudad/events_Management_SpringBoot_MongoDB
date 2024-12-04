package com.example.evenementCrud.services;

import com.example.evenementCrud.dtos.InvitedDto;
import com.example.evenementCrud.entities.Invited;
import com.example.evenementCrud.exceptions.InvitedNotFound;
import com.example.evenementCrud.mappers.EvenementMapper;
import com.example.evenementCrud.mappers.InvitedMapper;
import com.example.evenementCrud.repositories.InvitedRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class InvitedServiceImpl implements InvitedService{

    private final InvitedRepository invitedRepository;
    private final EvenementService evenementService;

    @Override
    public InvitedDto add(InvitedDto invitedDto) {
        Invited invited = InvitedMapper.mapper.toEntity(invitedDto);
        invited.setIdIvited(UUID.randomUUID().toString());
        return InvitedMapper.mapper.toDto(invitedRepository.save(invited));
    }

    @Override
    public InvitedDto getById(String id) {
        return InvitedMapper.mapper.toDto(getInvitedById(id));
    }

    @Override
    public List<InvitedDto> getAll() {
        return InvitedMapper.mapper.toDtos(invitedRepository.findAll());
    }

    @Override
    public InvitedDto update(InvitedDto invitedDto) {
        Invited invited = getInvitedById(invitedDto.getIdIvited());
        invited.setName(invitedDto.getName());
        invited.setEmail(invitedDto.getEmail());
        invited.setPhone(invitedDto.getPhone());
        return InvitedMapper.mapper.toDto(invitedRepository.save(invited));
    }

    @Override
    public String delete(String id) {
        invitedRepository.deleteById(id);
        return "invited delete with success";
    }

    @Override
    public InvitedDto addInvitedToEnvent(String idInvited, String idEvenement) {
        Invited invited = getInvitedById(idInvited);
        invited.getEvents().add(EvenementMapper.mapper.toEntity(evenementService.getById(idEvenement)));

        return InvitedMapper.mapper.toDto(invitedRepository.save(invited));
    }



    public Invited getInvitedById(String id) {
        return invitedRepository.findById(id).orElseThrow(()-> new InvitedNotFound(id));
    }


}
