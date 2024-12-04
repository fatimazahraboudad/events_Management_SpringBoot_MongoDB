package com.example.evenementCrud.mappers;

import com.example.evenementCrud.dtos.DelayedNotificationDto;
import com.example.evenementCrud.dtos.EvenementDto;
import com.example.evenementCrud.entities.DelayedNotification;
import com.example.evenementCrud.entities.Evenement;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DelayedNotificationMapper {
    DelayedNotificationMapper mapper = Mappers.getMapper(DelayedNotificationMapper.class);

    DelayedNotification toEntity(DelayedNotificationDto delayedNotificationDto);

    DelayedNotificationDto toDto(DelayedNotification delayedNotification);

    List<DelayedNotification> toEntities(List<DelayedNotificationDto> delayedNotificationDtoList);
    List<DelayedNotificationDto> toDtos(List<DelayedNotification> delayedNotificationList);
}
