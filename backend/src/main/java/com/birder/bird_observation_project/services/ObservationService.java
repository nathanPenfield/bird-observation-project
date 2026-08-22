package com.birder.bird_observation_project.services;

import java.util.List;

import com.birder.bird_observation_project.dtos.ObservationDto;

public interface ObservationService {
    ObservationDto saveObservation(ObservationDto observationDto);
    List<ObservationDto> getObservations();
    ObservationDto getObservationById(int id);
    void deleteObservation(int id);
}
