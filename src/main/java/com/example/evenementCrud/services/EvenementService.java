package com.example.evenementCrud.services;

import com.example.evenementCrud.dtos.EvenementDto;

import java.util.List;

public interface EvenementService {

    EvenementDto add(EvenementDto evenementDto);

    EvenementDto getById(String id);

    List<EvenementDto> getAll();

    EvenementDto update(EvenementDto evenementDto);

    String delete(String id);
}
