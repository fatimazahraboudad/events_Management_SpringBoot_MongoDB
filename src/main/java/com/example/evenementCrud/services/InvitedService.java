package com.example.evenementCrud.services;

import com.example.evenementCrud.dtos.InvitedDto;

import java.util.List;

public interface InvitedService {
    InvitedDto add(InvitedDto invitedDto);

    InvitedDto getById(String id);

    List<InvitedDto> getAll();

    InvitedDto update(InvitedDto invitedDto);

    String delete(String id);
    InvitedDto addInvitedToEnvent(String idInvited, String idEvenement);

}
