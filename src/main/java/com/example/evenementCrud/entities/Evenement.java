package com.example.evenementCrud.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Document
public class Evenement {

    @Id
    private String idEvenement;
    private String name;
    private String city;
    private Long nbr_person;
    private LocalDateTime date;

}
