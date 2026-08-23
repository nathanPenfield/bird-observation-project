package com.birder.bird_observation_project.services;

import java.util.List;

import com.birder.bird_observation_project.dtos.ObservationCreationDto;
import com.birder.bird_observation_project.dtos.ObservationDto;

public interface ObservationService {
    ObservationDto saveObservation(ObservationCreationDto observationCreationDto);
    List<ObservationDto> getObservations();
    ObservationDto getObservationById(Integer id);
    void deleteObservation(Integer id);
}
