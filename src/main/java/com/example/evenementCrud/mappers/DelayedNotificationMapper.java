package com.example.evenementCrud.mappers;

import com.example.evenementCrud.dtos.DelayedNotificationDto;
import com.example.evenementCrud.entities.DelayedNotification;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DelayedNotificationMapper {
    DelayedNotificationMapper mapper = Mappers.getMapper(DelayedNotificationMapper.class);

    DelayedNotification toEntity(DelayedNotificationDto delayedNotificationDto);

    DelayedNotificationDto toDto(DelayedNotification delayedNotification);

    List<DelayedNotificationDto> toDtos(List<DelayedNotification> delayedNotificationList);
}
