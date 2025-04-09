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
public class DelayedNotificationDto {

    private String id;
    private InvitedDto invited;
    private String eventName;
    private LocalDateTime sentAt;
    private boolean sent;
}
