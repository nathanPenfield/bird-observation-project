package com.birder.bird_observation_project.dtos;

public class ObservationDto {
    private Long id;
    private int species_id;
    private String location;
    private int count;
    private String date;
   
    // noArgsConstructor
    public ObservationDto(){}
    
    // allArgsConstructor
    public ObservationDto(Long id, int species_id, int count, String location, String date){
        this.id = id;
        this.species_id = species_id;
        this.count =count;
        this.location = location;
        this.date = date;
    }

    // getter methods
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

    // setter methods
    public void setId(Long id){
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
