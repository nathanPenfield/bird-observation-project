package com.birder.bird_observation_project.services.implimentation;

import org.springframework.stereotype.Service;

import com.birder.bird_observation_project.dtos.UserCreationDto;
import com.birder.bird_observation_project.mappers.UserMapper;
import com.birder.bird_observation_project.models.User;
import com.birder.bird_observation_project.repositories.UserRepository;
import com.birder.bird_observation_project.services.UserService;

@Service
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;

    private UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }
   
    @Override
    public void createUser(UserCreationDto userCreationDto){
        User user = UserMapper.toEntity(userCreationDto);
        user = userRepository.save(user);
        return;
    }
}
