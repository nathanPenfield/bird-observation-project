package com.birder.bird_observation_project.controllers;

import org.springframework.web.bind.annotation.RequestBody;

import com.birder.bird_observation_project.dtos.ObservationCreationDto;
import com.birder.bird_observation_project.dtos.ObservationDto;
import com.birder.bird_observation_project.services.ObservationService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/observations")
@CrossOrigin(origins="http://localhost:5173")
public class ObservationController {
    private ObservationService observationService;
    
    public ObservationController(ObservationService observationService){
        this.observationService=observationService;
    }
    
    @GetMapping()
    public ResponseEntity<List<ObservationDto>> getObservations(){
        List<ObservationDto> observations = observationService.getObservations();
        return new ResponseEntity<>(observations, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<ObservationDto> createObservation(@RequestBody ObservationCreationDto observationCreationDto){
        observationService.saveObservation(observationCreationDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ObservationDto> getObservation(@PathVariable Integer id){
        ObservationDto observation = observationService.getObservationById(id);
        return new ResponseEntity<>(observation, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ObservationDto> updateObservation(@RequestBody ObservationCreationDto observationUpdateDto){
        observationService.saveObservation(observationUpdateDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteObservation(@PathVariable Integer id){
        observationService.deleteObservation(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
