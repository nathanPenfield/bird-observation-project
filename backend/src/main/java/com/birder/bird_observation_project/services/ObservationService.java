package com.birder.bird_observation_project.services;

import java.util.List;

import com.birder.bird_observation_project.dtos.ObservationCreationDto;
import com.birder.bird_observation_project.dtos.ObservationDto;
import com.birder.bird_observation_project.models.UserPrincipal;

public interface ObservationService {
    void saveObservation(ObservationCreationDto observationCreationDto, UserPrincipal user);
    List<ObservationDto> getObservations(UserPrincipal user);
    ObservationDto getObservationById(Integer id, UserPrincipal user);
    void deleteObservation(Integer id, UserPrincipal user);
    void updateObservation(Integer id, ObservationCreationDto observationUpdateDto, UserPrincipal user);
}
