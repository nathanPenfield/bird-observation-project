package com.birder.bird_observation_project.exceptions;

public class SpeciesNotFoundException extends RuntimeException{
    public SpeciesNotFoundException(Integer id){
        super("No species found with id: "+id+".");
    }
}