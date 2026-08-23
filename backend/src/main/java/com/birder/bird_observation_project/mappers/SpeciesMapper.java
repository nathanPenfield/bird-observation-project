package com.birder.bird_observation_project.mappers;

import com.birder.bird_observation_project.dtos.SpeciesDto;
import com.birder.bird_observation_project.models.Species;

public class SpeciesMapper {
    public static SpeciesDto toDto(Species species){
        return new SpeciesDto(species.getId(), species.getName());
    }
}
