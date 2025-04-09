package com.example.evenementCrud.controllers;

import com.example.evenementCrud.dtos.DelayedNotificationDto;
import com.example.evenementCrud.services.DelayedNotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/notif")
@RequiredArgsConstructor
public class DelayedNotificationController {

    private final DelayedNotificationService delayedNotificationService;

    @GetMapping("/sent")
    public ResponseEntity<List<DelayedNotificationDto>> sentNotif(){
        return new ResponseEntity<>(delayedNotificationService.getSentNotif(), HttpStatus.OK);
    }

    @GetMapping("/nosent")
    public ResponseEntity<List<DelayedNotificationDto>> noSentNotif(){
        return new ResponseEntity<>(delayedNotificationService.getNotSentNotif(), HttpStatus.OK);
    }

}
