package com.birder.bird_observation_project.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;

public class ObservationCreationDto {
    private Integer id;
    @NotNull(message = "Species is required")
    @Min(value = 1, message = "Species is required")
    private Integer species_id;
    @NotNull(message = "Location is required")
    @Min(value = 1, message = "Location is required")
    private Long location_id;
    @NotNull(message = "Count is required")
    @Min(value = 1, message = "Count must be at least 1")
    private Integer count;
    @NotBlank(message = "Date is required")
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "Date must use yyyy-MM-dd format")
    private String date;
    @NotBlank(message = "Time is required")
    @Pattern(regexp = "\\d{2}:\\d{2}", message = "Time must use HH:mm format")
    private String time;
    private String notes;
   
    // noArgsConstructor
    public ObservationCreationDto(){}
    
    // allArgsConstructor
    public ObservationCreationDto(Integer id, Integer species_id, Integer count, Long location_id, String date, String time, String notes){
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
    public Integer getSpeciesId(){
        return this.species_id;
    }
    public Integer getCount(){
        return this.count;
    }
    public Long getLocationId(){
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
    public void setSpeciesId(Integer species_id){
        this.species_id = species_id;
    }
    public void setCount(Integer count){
        this.count = count;
    }
    public void setLocationId(Long location_id){
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
