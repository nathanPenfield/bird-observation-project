package com.birder.bird_observation_project.services;

import com.birder.bird_observation_project.dtos.ObservationDto;

public interface ObservationService {
    ObservationDto saveObservation(ObservationDto observationDto);
}
