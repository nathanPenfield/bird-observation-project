package com.birder.bird_observation_project.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UserAuthDto {
    @NotBlank(message = "Email is required")
    @Email(message = "Email must be valid")
    private String email;
    @NotBlank(message = "Password is required")
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
