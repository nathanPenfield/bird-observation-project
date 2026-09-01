package com.birder.bird_observation_project.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.birder.bird_observation_project.dtos.UserCreationDto;
import com.birder.bird_observation_project.services.UserService;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins="http://localhost:5173")
public class UserController {
    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody UserCreationDto userCreationDto){
        userService.createUser(userCreationDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
