package com.birder.bird_observation_project.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.birder.bird_observation_project.dtos.LocationDto;
import com.birder.bird_observation_project.services.LocationService;

@RestController
@RequestMapping("/api/locations")
@CrossOrigin(origins="http://localhost:5173")
public class LocationController {
    private LocationService locationService;

    public LocationController(LocationService locationService){
        this.locationService = locationService;
    }

    @GetMapping()
    public ResponseEntity<List<LocationDto>> getLocations(){
        List<LocationDto> locations = locationService.getLocations();
        return new ResponseEntity<>(locations, HttpStatus.OK);
    }
}
