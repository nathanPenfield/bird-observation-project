package com.birder.bird_observation_project.dtos;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class LocationDto {
    private Long id;
    @NotBlank(message = "Location name is required")
    private String name;
    @NotNull(message = "Latitude is required")
    @DecimalMin(value = "-90.0", message = "Latitude must be between -90 and 90")
    @DecimalMax(value = "90.0", message = "Latitude must be between -90 and 90")
    private Double latitude;
    @NotNull(message = "Longitude is required")
    @DecimalMin(value = "-180.0", message = "Longitude must be between -180 and 180")
    @DecimalMax(value = "180.0", message = "Longitude must be between -180 and 180")
    private Double longitude; 

    // noArgsConstructor
    public LocationDto(){}

    // allArgsConstructor
    public LocationDto(Long id, String name, Double latitude, Double longitude){
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
    public Double getLatitude(){
        return this.latitude;
    }
    public Double getLongitude(){
        return this.longitude;
    }

    // setter methods
    public void setId(Long id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setLatitude(Double latitude){
        this.latitude = latitude;
    }
    public void setLongitude(Double longitude){
        this.longitude = longitude;
    }
}
