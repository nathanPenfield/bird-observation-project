package com.birder.bird_observation_project.dtos;

public class AuthResponseDto {
    private String token;
    private String name;

    public AuthResponseDto() {
    }

    public AuthResponseDto(String token, String name) {
        this.token = token;
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}