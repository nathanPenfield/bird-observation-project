package com.birder.bird_observation_project.exceptions;

public class ObservationNotFoundException extends RuntimeException{
    public ObservationNotFoundException(Long id){
        super("No observation found with id: "+id+".");
    }
}
