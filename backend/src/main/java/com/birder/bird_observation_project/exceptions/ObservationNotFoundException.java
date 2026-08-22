package com.birder.bird_observation_project.exceptions;

public class ObservationNotFoundException extends RuntimeException{
    public ObservationNotFoundException(Integer id){
        super("No observation found with id: "+id+".");
    }
}
