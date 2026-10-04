package com.birder.bird_observation_project.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Email;

public class UserCreationDto {
    @NotBlank(message = "Name is required")
    @Pattern(regexp = "^[\\p{L}\\p{M}][\\p{L}\\p{M} .'-]*$", message = "Name may contain letters, spaces, periods, apostrophes, and hyphens")
    private String name;
    @NotBlank(message = "Email is required")
    @Email(message = "Email must be valid")
    private String email;
    @NotBlank(message = "Password is required")
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
