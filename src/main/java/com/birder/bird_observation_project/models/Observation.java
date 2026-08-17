package com.birder.bird_observation_project.models;

public class Observation {
    
    private long id;
    private int species_id;
    private String location;
    private int count;
    private String date;
   
    public Observation(long id, int species_id, int count, String location, String date){
        this.id = id;
        this.species_id = species_id;
        this.count =count;
        this.location = location;
        this.date = date;
    }
}
