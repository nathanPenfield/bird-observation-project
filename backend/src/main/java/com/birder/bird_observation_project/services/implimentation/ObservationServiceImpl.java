package com.birder.bird_observation_project.services.implimentation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.birder.bird_observation_project.dtos.ObservationCreationDto;
import com.birder.bird_observation_project.dtos.ObservationDto;
import com.birder.bird_observation_project.exceptions.ObservationNotFoundException;
import com.birder.bird_observation_project.mappers.ObservationMapper;
import com.birder.bird_observation_project.models.Observation;
import com.birder.bird_observation_project.repositories.ObservationRepository;
import com.birder.bird_observation_project.repositories.SpeciesRepository;
import com.birder.bird_observation_project.services.ObservationService;

@Service
public class ObservationServiceImpl implements ObservationService{
    private ObservationRepository observationRepository;
    private ObservationMapper observationMapper;

    public ObservationServiceImpl(ObservationRepository observationRepository, SpeciesRepository speciesRepository){
        this.observationRepository = observationRepository;  
        this.observationMapper = new ObservationMapper(speciesRepository);
    }

    @Override
    public void saveObservation(ObservationCreationDto observationCreationDto){
        Observation observation = observationMapper.toEntity(observationCreationDto);
        observation = observationRepository.save(observation);
    }

    @Override
    public List<ObservationDto> getObservations(){
        List<Observation> observations = observationRepository.findAll();
        List<ObservationDto> observationDtos = observationMapper.listToDto(observations);
        return observationDtos;

    }

    @Override
    public ObservationDto getObservationById(Integer id){
        Observation observation = observationRepository.findById(id).orElseThrow(() -> new ObservationNotFoundException(id));
        return observationMapper.toDto(observation);
    }

    @Override
    public void deleteObservation(Integer id){
        Observation observation = observationRepository.findById(id).orElseThrow(() -> new ObservationNotFoundException(id));
        observationRepository.delete(observation);
    }
}
