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
public class DelayedNotification {

        @Id
        private String id;
        private Invited invited;
        private String eventName;
        private LocalDateTime sentAt;
        private boolean sent;


}
