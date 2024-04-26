package com.monster.baster.club.spingbootbackendsideforemployeewebsite.exceptions;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(String message) {
        super(message);
    }
}
