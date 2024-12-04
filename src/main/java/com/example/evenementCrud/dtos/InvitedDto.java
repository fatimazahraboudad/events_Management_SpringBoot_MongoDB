package com.example.evenementCrud.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class InvitedDto {
    private String idIvited;
    private String name;
    private String email;
    private String phone;
    private List<EvenementDto> events;
}
