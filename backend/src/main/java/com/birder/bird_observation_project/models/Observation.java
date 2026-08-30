package com.birder.bird_observation_project.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="observations")
public class Observation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "species_id")
    private Species species;
    private int count;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id")
    private Location location;
    private String date;
    private String time;
    private String notes;
   
    // noArgsConstructor
    public Observation(){}

    // allArgsConstructor
    public Observation(Integer id, Species species, int count, Location location, String date, String time, String notes){
        this.id = id;
        this.species = species;
        this.count =count;
        this.location = location;
        this.date = date;
        this.time = time;
        this.notes = notes;
    }

    // getter methods
    public Integer getId(){
        return this.id;
    }
    public Species getSpecies(){
        return this.species;
    }
    public int getCount(){
        return this.count;
    }
    public Location getLocation(){
        return this.location;
    }
    public String getDate(){
        return this.date;
    }
    public String getTime(){
        return this.time;
    }
    public String getNotes(){
        return this.notes;
    }

    // setter methods
    public void setId(Integer id){
        this.id = id;
    }
    public void setSpecies(Species species){
        this.species = species;
    }
    public void setCount(int count){
        this.count = count;
    }
    public void setLocation(Location location){
        this.location = location;
    }
    public void setDate(String date){
        this.date = date;
    }
    public void setTime(String time){
        this.time = time;
    }
    public void setNotes(String notes){
        this.notes = notes;
    }
}
