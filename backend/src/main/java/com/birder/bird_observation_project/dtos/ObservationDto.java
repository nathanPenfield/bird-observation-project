package com.birder.bird_observation_project.dtos;

public class ObservationDto {
    private Integer id;
    private int species_id;
    private String location;
    private int count;
    private String date;
    private String time;
    private String notes;
   
    // noArgsConstructor
    public ObservationDto(){}
    
    // allArgsConstructor
    public ObservationDto(Integer id, int species_id, int count, String location, String date, String time, String notes){
        this.id = id;
        this.species_id = species_id;
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
    public void setLocation(String location){
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
