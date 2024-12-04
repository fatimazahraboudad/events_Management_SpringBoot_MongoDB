package com.example.evenementCrud.controllers;

import com.example.evenementCrud.dtos.InvitedDto;
import com.example.evenementCrud.services.InvitedService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invited")
@RequiredArgsConstructor
public class InvitedController {

    private final InvitedService invitedService;

    @PostMapping("/add")
    public ResponseEntity<InvitedDto> add(@RequestBody InvitedDto invitedDto){
        return new ResponseEntity<>(invitedService.add(invitedDto), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<InvitedDto>> all(){
        return new ResponseEntity<>(invitedService.getAll(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InvitedDto> invitedById(@PathVariable String id){
        return new ResponseEntity<>(invitedService.getById(id),HttpStatus.OK);
    }

    @PutMapping("/updateInvited/")
    public ResponseEntity<InvitedDto> updateInvited(@RequestBody InvitedDto invitedDto){
        return new ResponseEntity<>(invitedService.update(invitedDto),HttpStatus.OK);
    }

    @DeleteMapping("/deleteInvited/{id}")
    public ResponseEntity<String> deleteInvited(@PathVariable String id){
        return new ResponseEntity<>(invitedService.delete(id),HttpStatus.OK);
    }

    @PutMapping("/{idInvited}/{idEvenement}")
    public ResponseEntity<InvitedDto> addInvitedTOEvenement(@PathVariable String idInvited,@PathVariable String idEvenement){
        return new ResponseEntity<>(invitedService.addInvitedToEnvent(idInvited,idEvenement),HttpStatus.OK);
    }
}
