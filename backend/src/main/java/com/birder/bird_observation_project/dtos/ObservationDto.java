package com.birder.bird_observation_project.dtos;

public class ObservationDto {
    private Long id;
    private int species_id;
    private String location;
    private int count;
    private String date;
   
    public ObservationDto(Long id, int species_id, int count, String location, String date){
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
