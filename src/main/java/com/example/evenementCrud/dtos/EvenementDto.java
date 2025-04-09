package com.example.evenementCrud.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class EvenementDto {

    private String idEvenement;
    private String name;
    private String city;
    private Long nbr_person;
    private LocalDateTime date;
}
