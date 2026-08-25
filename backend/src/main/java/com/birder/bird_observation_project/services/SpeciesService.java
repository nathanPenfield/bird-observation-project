package com.birder.bird_observation_project.services;

import java.util.List;

import com.birder.bird_observation_project.dtos.SpeciesDto;

public interface SpeciesService {
    List<SpeciesDto> getSpecies();
}
