package com.birder.bird_observation_project.services.implimentation;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.birder.bird_observation_project.dtos.UserAuthDto;
import com.birder.bird_observation_project.dtos.UserCreationDto;
import com.birder.bird_observation_project.dtos.AuthResponseDto;
import com.birder.bird_observation_project.exceptions.DuplicateUserException;
import com.birder.bird_observation_project.config.JwtService;
import com.birder.bird_observation_project.mappers.UserMapper;
import com.birder.bird_observation_project.models.User;
import com.birder.bird_observation_project.models.UserPrincipal;
import com.birder.bird_observation_project.repositories.UserRepository;
import com.birder.bird_observation_project.services.UserService;

@Service
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private JwtService jwtService;
    private AuthenticationManager authenticationManager;

    private UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager =  authenticationManager;
    }
   
    @Override
    public void createUser(UserCreationDto userCreationDto){
        if (userRepository.existsByEmail(userCreationDto.getEmail())) {
            throw new DuplicateUserException(userCreationDto.getEmail());
        }
        User user = UserMapper.toEntity(userCreationDto);
        user.setPasswordHash(passwordEncoder.encode(userCreationDto.getPassword()));
        user = userRepository.save(user);
        return;
    }

    @Override
    public AuthResponseDto authenticateUser(UserAuthDto userAuthDto){ 
        Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userAuthDto.getEmail(), userAuthDto.getPassword()));
        UserPrincipal user = (UserPrincipal) auth.getPrincipal();
        User userEntity = userRepository.findByEmail(user.getUsername()).orElseThrow();
        return new AuthResponseDto(jwtService.generateToken(user), userEntity.getName());
    }
}
