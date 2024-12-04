package com.example.evenementCrud.services;

import com.example.evenementCrud.dtos.DelayedNotificationDto;
import com.example.evenementCrud.entities.DelayedNotification;
import com.example.evenementCrud.mappers.DelayedNotificationMapper;
import com.example.evenementCrud.repositories.DelayedNotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Formatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DelayedNotificationServiceImpl implements DelayedNotificationService{

    private final DelayedNotificationRepository delayedNotificationRepository;
    private final EmailSenderService emailSenderService;
    private final TemplateEngine templateEngine;
    Context context = new Context();


    @Override
    public DelayedNotificationDto saveDelayedNotification(DelayedNotification delayedNotification) {
        return DelayedNotificationMapper.mapper.toDto(delayedNotificationRepository.save(delayedNotification));
    }

    @Override
    @Scheduled(fixedRate = 60000)
    public void sendNotification() {
        List<DelayedNotification> notifications = delayedNotificationRepository.findBySentFalse();

        notifications.forEach(
                delayedNotification -> {

                    if(delayedNotification.getSentAt().truncatedTo(ChronoUnit.MINUTES).isEqual(LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES))){


                        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

                        String emailContent = buildEmail(delayedNotification.getInvited().getName(),delayedNotification.getSentAt().toLocalDate().toString(),delayedNotification.getSentAt().plusMinutes(5).format(timeFormatter), delayedNotification.getEventName());
                        emailSenderService.sendEmail(delayedNotification.getInvited().getEmail(),
                                "Reminder for " +delayedNotification.getEventName()+" event",
                                emailContent);
                        delayedNotification.setSent(true);
                        delayedNotificationRepository.save(delayedNotification);

                }
                }
        );

    }

    @Override
    public List<DelayedNotificationDto> getSentNotif() {
        return DelayedNotificationMapper.mapper.toDtos(delayedNotificationRepository.findBySentTrue());
    }

    @Override
    public List<DelayedNotificationDto> getNotSentNotif() {
        return DelayedNotificationMapper.mapper.toDtos(delayedNotificationRepository.findBySentFalse());
    }


    public String buildEmail(String name,String date,String time,String eventName) {
        context.setVariable("name", name);
        context.setVariable("date", date);
        context.setVariable("time", time);
        context.setVariable("eventName", eventName);
        return templateEngine.process("EmailNotification", context);
    }
}
