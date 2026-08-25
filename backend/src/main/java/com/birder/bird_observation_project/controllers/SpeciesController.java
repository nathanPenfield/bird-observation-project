package com.birder.bird_observation_project.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.birder.bird_observation_project.dtos.SpeciesDto;
import com.birder.bird_observation_project.services.SpeciesService;

@RestController
@RequestMapping("/api/species")
@CrossOrigin(origins="http://localhost:5173")
public class SpeciesController {
    private SpeciesService speciesService;
    
    public SpeciesController(SpeciesService speciesService){
        this.speciesService=speciesService;
    }

    @GetMapping
    public ResponseEntity<List<SpeciesDto>> getSpecies(){
        List<SpeciesDto> species = speciesService.getSpecies();
        return new ResponseEntity<>(species,HttpStatus.OK);
    }
}
