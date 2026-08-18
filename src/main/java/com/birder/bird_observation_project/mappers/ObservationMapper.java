package com.birder.bird_observation_project.mappers;

import com.birder.bird_observation_project.dtos.ObservationDto;
import com.birder.bird_observation_project.models.Observation;

public class ObservationMapper {
    // Map Observation Entity to Observation DTO
    public static ObservationDto toDto(Observation observation){
        ObservationDto dto = new ObservationDto(observation.get_id(), observation.get_species_id(), observation.get_count(), observation.get_location(), observation.get_date());
        return dto;
    }

    // Map Observation DTO to Observation Entity
    public static Observation toEntity(ObservationDto dto){
        Observation observation = new Observation(dto.get_id(), dto.get_species_id(), dto.get_count(), dto.get_location(), dto.get_date());
        return observation;
    }
}
