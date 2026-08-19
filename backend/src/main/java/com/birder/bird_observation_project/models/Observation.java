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
    private Long id;

    private int species_id;
    private int count;
    private String location;
    private String date;
   
    public Observation(Long id, int species_id, int count, String location, String date){
        this.id = id;
        this.species_id = species_id;
        this.count =count;
        this.location = location;
        this.date = date;
    }

    public Long getId(){
        return this.id;
    }
    public int getSpeciesId(){
        return this.species_id;
    }
    public int getCount(){
        return this.count;
    }
    public String getLocation(){
        return this.location;
    }
    public String getDate(){
        return this.date;
    }
}
