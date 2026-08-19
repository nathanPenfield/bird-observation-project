package com.birder.bird_observation_project.mappers;

import java.util.ArrayList;
import java.util.List;

import com.birder.bird_observation_project.dtos.ObservationDto;
import com.birder.bird_observation_project.models.Observation;

public class ObservationMapper {
    // Map Observation Entity to Observation DTO
    public static ObservationDto toDto(Observation observation){
        ObservationDto dto = new ObservationDto(observation.getId(), observation.getSpeciesId(), observation.getCount(), observation.getLocation(), observation.getDate());
        return dto;
    }

    // Map Observation DTO to Observation Entity
    public static Observation toEntity(ObservationDto dto){
        Observation observation = new Observation(dto.getId(), dto.getSpeciesId(), dto.getCount(), dto.getLocation(), dto.getDate());
        return observation;
    }

    // Map List of Observation Entities to List of Observation DTOs
    public static List<ObservationDto> listToDto(List<Observation> observations){
        List<ObservationDto> dtoList = new ArrayList<>();
    
        for(int i = 0 ; i < observations.size() ; i++){
            Observation observation = observations.get(i);
            dtoList.add(new ObservationDto(observation.getId(), observation.getSpeciesId(), observation.getCount(), observation.getLocation(), observation.getDate()));
        }

        return dtoList;
    }
}
