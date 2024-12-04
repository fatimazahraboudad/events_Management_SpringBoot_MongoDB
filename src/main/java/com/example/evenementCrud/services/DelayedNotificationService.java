package com.example.evenementCrud.services;

import com.example.evenementCrud.dtos.DelayedNotificationDto;
import com.example.evenementCrud.entities.DelayedNotification;

import java.util.List;

public interface DelayedNotificationService {

    DelayedNotificationDto saveDelayedNotification(DelayedNotification delayedNotification);

    void sendNotification();

    List<DelayedNotificationDto> getSentNotif();
    List<DelayedNotificationDto> getNotSentNotif();

}
