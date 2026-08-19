package com.birder.bird_observation_project.models;

public class Species {
    private int id;
    private String name;
    
    public Species(int id, String name){
        this.id = id;
        this.name = name;
    }

    public int get_id(){
        return this.id;
    }
    public String get_name(){
        return this.name;
    }
}
