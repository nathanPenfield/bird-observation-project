package com.birder.bird_observation_project.dtos;

public class UserCreationDto {
    private String name;
    private String email;
    private String password; 

    // noArgsConstructor
    public UserCreationDto(){}

    // allArgsConstructor
    public UserCreationDto(String name, String email, String password){
        this.name = name;
        this.email = email;
        this.password = password;
    }

    // getter methods
    public String getName(){
        return this.name;
    }
    public String getEmail(){
        return this.email;
    }
    public String getPassword(){
        return this.password;
    }

    // setter methods
    public void setName(String name){
        this.name = name;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setPassword(String password){
        this.password = password;
    }
}
