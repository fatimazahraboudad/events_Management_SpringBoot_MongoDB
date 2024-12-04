package com.example.evenementCrud.exceptions;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ExceptionMessages {

    EVENEMENT_NOT_FOUND("evenement not found with id %s ."),
    Invited_NOT_FOUND("invited not found with id %s .")
    ;




    private final String message;



    public String getMessage() {
        return message;
    }

    public String getMessage(String... args) {
        return String.format(message, (Object[]) args);
    }
}
