package com.birder.bird_observation_project.exceptions;

public class LocationNotFoundException extends RuntimeException{
    public LocationNotFoundException(Long id){
        super("No species found with id: "+id+".");
    }
}
