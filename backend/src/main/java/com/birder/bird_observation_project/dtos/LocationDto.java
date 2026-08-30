package com.birder.bird_observation_project.dtos;

public class LocationDto {
    private Long id;
    private String name;
    private double latitude;
    private double longitude; 

    // noArgsConstructor
    public LocationDto(){}

    // allArgsConstructor
    public LocationDto(Long id, String name, double latitude, double longitude){
        this.id = id;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    // getter methods
    public Long getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public double getLatitude(){
        return this.latitude;
    }
    public double getLongitude(){
        return this.longitude;
    }

    // setter methods
    public void setId(Long id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setLatitude(double latitude){
        this.latitude = latitude;
    }
    public void setLongitude(double longitude){
        this.longitude = longitude;
    }
}
