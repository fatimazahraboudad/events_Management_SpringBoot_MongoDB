package com.example.evenementCrud.exceptions;

public class EvenementNotFound extends RuntimeException{
    public EvenementNotFound(String id) {
        super(ExceptionMessages.EVENEMENT_NOT_FOUND.getMessage(id));
    }
}
