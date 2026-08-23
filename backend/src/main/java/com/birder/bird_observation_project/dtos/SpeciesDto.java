package com.birder.bird_observation_project.dtos;

public class SpeciesDto {
    private int id;
    private String name;
    
    public SpeciesDto(){}
    
    public SpeciesDto(int id, String name){
        this.id = id;
        this.name = name;
    }

    public int getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }

    public void setId(int id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
}
