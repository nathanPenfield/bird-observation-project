package com.birder.bird_observation_project.services;

import com.birder.bird_observation_project.dtos.UserAuthDto;
import com.birder.bird_observation_project.dtos.UserCreationDto;
import com.birder.bird_observation_project.dtos.AuthResponseDto;

public interface UserService {
    public void createUser(UserCreationDto userCreationDto);
    public AuthResponseDto authenticateUser(UserAuthDto userAuthDto);
}
