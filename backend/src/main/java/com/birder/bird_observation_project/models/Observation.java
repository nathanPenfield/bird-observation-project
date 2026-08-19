package com.birder.bird_observation_project.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="observations")
public class Observation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int species_id;
    private int count;
    private String location;
    private String date;
   
    public Observation(long id, int species_id, int count, String location, String date){
        this.id = id;
        this.species_id = species_id;
        this.count =count;
        this.location = location;
        this.date = date;
    }

    public long get_id(){
        return this.id;
    }
    public int get_species_id(){
        return this.species_id;
    }
    public int get_count(){
        return this.count;
    }
    public String get_location(){
        return this.location;
    }
    public String get_date(){
        return this.date;
    }
}
