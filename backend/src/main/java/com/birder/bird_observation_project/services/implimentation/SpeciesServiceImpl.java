package com.birder.bird_observation_project.services.implimentation;
import java.util.List;

import org.springframework.stereotype.Service;

import com.birder.bird_observation_project.dtos.SpeciesDto;
import com.birder.bird_observation_project.models.Species;
import com.birder.bird_observation_project.repositories.SpeciesRepository;
import com.birder.bird_observation_project.services.SpeciesService;
import com.birder.bird_observation_project.mappers.SpeciesMapper;

@Service
public class SpeciesServiceImpl implements SpeciesService {
    private SpeciesRepository speciesRepository;

    public SpeciesServiceImpl(SpeciesRepository speciesRepository){
        this.speciesRepository = speciesRepository;
    }
    
    @Override
    public List<SpeciesDto> getSpecies(){
        List<Species> species = speciesRepository.findAll();
        List<SpeciesDto> dtos = SpeciesMapper.listToDto(species);
        return dtos;
    }
}
