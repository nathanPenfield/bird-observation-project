package com.birder.bird_observation_project.services;

import com.birder.bird_observation_project.dtos.UserAuthDto;
import com.birder.bird_observation_project.dtos.UserCreationDto;

public interface UserService {
    public void createUser(UserCreationDto userCreationDto);
    public String authenticateUser(UserAuthDto userAuthDto);
}
