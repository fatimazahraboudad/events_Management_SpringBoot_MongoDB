package com.example.evenementCrud.controllers;

import com.example.evenementCrud.dtos.EvenementDto;
import com.example.evenementCrud.services.EvenementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/evenement")
@RequiredArgsConstructor
public class EvenementController {

    private final EvenementService evenementService;

    @PostMapping("/add")
    public ResponseEntity<EvenementDto> add(@RequestBody EvenementDto evenementDto){
        return new ResponseEntity<>(evenementService.add(evenementDto), HttpStatus.CREATED);
    }

    @GetMapping("/events")
    public ResponseEntity<List<EvenementDto>> events(){
        return new ResponseEntity<>(evenementService.getAll(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EvenementDto> EventById(@PathVariable String id){
        return new ResponseEntity<>(evenementService.getById(id),HttpStatus.OK);
    }

    @PutMapping("/updateEvent/")
    public ResponseEntity<EvenementDto> updateEvent(@RequestBody EvenementDto eventDto){
        return new ResponseEntity<>(evenementService.update(eventDto),HttpStatus.OK);
    }

    @DeleteMapping("/deleteEvent/{id}")
    public ResponseEntity<String> deleteEvent(@PathVariable String id){
        return new ResponseEntity<>(evenementService.delete(id),HttpStatus.OK);
    }
}
