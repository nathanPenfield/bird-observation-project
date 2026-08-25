package com.birder.bird_observation_project.mappers;

import java.util.ArrayList;
import java.util.List;

import com.birder.bird_observation_project.dtos.SpeciesDto;
import com.birder.bird_observation_project.models.Species;

public class SpeciesMapper {
    public static SpeciesDto toDto(Species species){
        return new SpeciesDto(species.getId(), species.getName());
    }
    public static List<SpeciesDto> listToDto(List<Species> species){
        List<SpeciesDto> dtoList = new ArrayList<>();
    
        for(int i = 0 ; i < species.size() ; i++){
            Species individual = species.get(i);
            dtoList.add(new SpeciesDto(individual.getId(), individual.getName()));
        }

        return dtoList;
    }
}
