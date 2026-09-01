package com.birder.bird_observation_project.mappers;

import com.birder.bird_observation_project.dtos.UserCreationDto;
import com.birder.bird_observation_project.models.User;

public class UserMapper {
    public static User toEntity(UserCreationDto userCreationDto){
        return new User(null,userCreationDto.getName(), userCreationDto.getEmail(), userCreationDto.getPassword());   
    }
}
