package com.birder.bird_observation_project.dtos;

public class ObservationDto {
    private long id;
    private int species_id;
    private String location;
    private int count;
    private String date;
   
    public ObservationDto(long id, int species_id, int count, String location, String date){
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
