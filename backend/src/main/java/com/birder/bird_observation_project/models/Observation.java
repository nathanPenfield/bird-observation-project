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
    private int id;

    private int species_id;
    private int count;
    private String location;
    private String date;
   
    // noArgsConstructor
    public Observation(){}

    // allArgsConstructor
    public Observation(int id, int species_id, int count, String location, String date){
        this.id = id;
        this.species_id = species_id;
        this.count =count;
        this.location = location;
        this.date = date;
    }

    // getter methods
    public int getId(){
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

    // setter methods
    public void setId(int id){
        this.id = id;
    }
    public void setSpeciesId(int species_id){
        this.species_id = species_id;
    }
    public void setCount(int count){
        this.count = count;
    }
    public void setLocation(String location){
        this.location = location;
    }
    public void setDate(String date){
        this.date = date;
    }
}
