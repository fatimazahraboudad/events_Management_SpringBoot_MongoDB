package com.example.evenementCrud.exceptions;

public class InvitedNotFound extends RuntimeException{

    public InvitedNotFound(String id) {
        super(ExceptionMessages.Invited_NOT_FOUND.getMessage(id));
    }
}
