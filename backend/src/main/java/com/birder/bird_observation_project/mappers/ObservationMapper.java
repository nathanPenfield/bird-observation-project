package com.birder.bird_observation_project.mappers;

import java.util.ArrayList;
import java.util.List;

import com.birder.bird_observation_project.dtos.ObservationCreationDto;
import com.birder.bird_observation_project.dtos.ObservationDto;
import com.birder.bird_observation_project.exceptions.SpeciesNotFoundException;
import com.birder.bird_observation_project.models.Observation;
import com.birder.bird_observation_project.models.Species;
import com.birder.bird_observation_project.repositories.SpeciesRepository;

public class ObservationMapper {

    private SpeciesRepository speciesRepository;

    public ObservationMapper(SpeciesRepository speciesRepository){
        this.speciesRepository = speciesRepository;
    }


    // Map Observation Entity to Observation DTO
    public ObservationDto toDto(Observation observation){
        ObservationDto dto = new ObservationDto(observation.getId(), SpeciesMapper.toDto(observation.getSpecies()), observation.getCount(), observation.getLocation(), observation.getDate(),observation.getTime(),observation.getNotes());
        return dto;
    }

    // Map Observation Creation DTO to Observation Entity
    public Observation toEntity(ObservationCreationDto dto){
        Species species = speciesRepository.findById(dto.getSpeciesId()).orElseThrow(() -> new SpeciesNotFoundException(dto.getSpeciesId()));
        Observation observation = new Observation(dto.getId(), species, dto.getCount(), dto.getLocation(), dto.getDate(),dto.getTime(),dto.getNotes());
        return observation;
    }

    // Map List of Observation Entities to List of Observation DTOs
    public List<ObservationDto> listToDto(List<Observation> observations){
        List<ObservationDto> dtoList = new ArrayList<>();
    
        for(int i = 0 ; i < observations.size() ; i++){
            Observation observation = observations.get(i);
            dtoList.add(new ObservationDto(observation.getId(), SpeciesMapper.toDto(observation.getSpecies()), observation.getCount(), observation.getLocation(), observation.getDate(),observation.getTime(),observation.getNotes()));
        }

        return dtoList;
    }
}
