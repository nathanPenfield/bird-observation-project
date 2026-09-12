package com.birder.bird_observation_project.dtos;

public class UserAuthDto {
    private String email;
    private String password; 

    // noArgsConstructor
    public UserAuthDto(){}

    // allArgsConstructor
    public UserAuthDto(String email, String password){
        this.email = email;
        this.password = password;
    }

    // getter methods
    public String getEmail(){
        return this.email;
    }
    public String getPassword(){
        return this.password;
    }

    // setter methods
    public void setEmail(String email){
        this.email = email;
    }
    public void setPassword(String password){
        this.password = password;
    }
}
