package com.birder.bird_observation_project.controllers;

import org.springframework.web.bind.annotation.RequestBody;

import com.birder.bird_observation_project.dtos.ObservationDto;
import com.birder.bird_observation_project.models.Observation;
import com.birder.bird_observation_project.services.ObservationService;

import java.net.http.HttpResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/observations")
public class ObservationController {
    private ObservationService observationService;
    
    public ObservationController(ObservationService observationService){
        this.observationService=observationService;
    }
    
    // @GetMapping()
    // public <List>Observation getObservations(){
        
    // }

    @PostMapping()
    public ResponseEntity<ObservationDto> createObservation(@RequestBody ObservationDto observationDto){
        ObservationDto saved = observationService.saveObservation(observationDto);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    // @GetMapping("/{id}")
    // public Observation getObservation(){
        
    // }

    // @PutMapping("/{id}")
    // public Observation updateObservation(){

    // }

    // @DeleteMapping("/{id}")
    // public void deleteObservation(){
        
    // }

}
