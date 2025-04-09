package com.example.evenementCrud.repositories;

import com.example.evenementCrud.entities.DelayedNotification;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DelayedNotificationRepository extends MongoRepository<DelayedNotification,String> {

    List<DelayedNotification> findBySentFalse();
    List<DelayedNotification> findBySentTrue();
}