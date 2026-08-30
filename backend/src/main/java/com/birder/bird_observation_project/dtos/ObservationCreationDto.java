package com.birder.bird_observation_project.dtos;

public class ObservationCreationDto {
    private Integer id;
    private int species_id;
    private long location_id;
    private int count;
    private String date;
    private String time;
    private String notes;
   
    // noArgsConstructor
    public ObservationCreationDto(){}
    
    // allArgsConstructor
    public ObservationCreationDto(Integer id, int species_id, int count, long location_id, String date, String time, String notes){
        this.id = id;
        this.species_id = species_id;
        this.count =count;
        this.location_id = location_id;
        this.date = date;
        this.time = time;
        this.notes = notes;
    }

    // getter methods
    public Integer getId(){
        return this.id;
    }
    public int getSpeciesId(){
        return this.species_id;
    }
    public int getCount(){
        return this.count;
    }
    public long getLocationId(){
        return this.location_id;
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
    public void setSpeciesId(int species_id){
        this.species_id = species_id;
    }
    public void setCount(int count){
        this.count = count;
    }
    public void setLocationId(long location_id){
        this.location_id = location_id;
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
