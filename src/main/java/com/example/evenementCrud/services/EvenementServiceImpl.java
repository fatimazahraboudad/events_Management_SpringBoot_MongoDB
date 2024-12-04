package com.example.evenementCrud.services;

import com.example.evenementCrud.dtos.EvenementDto;
import com.example.evenementCrud.entities.Evenement;
import com.example.evenementCrud.exceptions.EvenementNotFound;
import com.example.evenementCrud.mappers.EvenementMapper;
import com.example.evenementCrud.repositories.EvenementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EvenementServiceImpl implements EvenementService{

    private final EvenementRepository evenementRepository;

    @Override
    public EvenementDto add(EvenementDto evenementDto) {
        Evenement evenement = EvenementMapper.mapper.toEntity(evenementDto);
        evenement.setIdEvenement(UUID.randomUUID().toString());
        return EvenementMapper.mapper.toDto(evenementRepository.save(evenement));
    }

    @Override
    public EvenementDto getById(String id) {
        return EvenementMapper.mapper.toDto(getEvenementById(id));
    }

    @Override
    public List<EvenementDto> getAll() {
        return EvenementMapper.mapper.toDtos(evenementRepository.findAll());
    }

    @Override
    public EvenementDto update(EvenementDto evenementDto) {
        Evenement evenement = getEvenementById(evenementDto.getIdEvenement());
        evenement.setName(evenementDto.getName());
        evenement.setDate(evenementDto.getDate());
        evenement.setCity(evenementDto.getCity());
        evenement.setNbr_person(evenementDto.getNbr_person());

        return EvenementMapper.mapper.toDto(evenementRepository.save(evenement));
    }

    @Override
    public String delete(String id) {
        evenementRepository.deleteById(id);
        return "evenement deleted successfully";
    }

    public Evenement getEvenementById(String id) {
        return evenementRepository.findById(id).orElseThrow(()-> new EvenementNotFound(id));
    }
}
