package com.birder.bird_observation_project.exceptions;

public class UserNotFoundException extends RuntimeException{ 
    public UserNotFoundException(String msg){
        super(msg);
    }
}
