package com.birder.bird_observation_project.exceptions;

public class DuplicateUserException extends RuntimeException {
    public DuplicateUserException(String email){
        super("A user already exists with email: " + email);
    }
}