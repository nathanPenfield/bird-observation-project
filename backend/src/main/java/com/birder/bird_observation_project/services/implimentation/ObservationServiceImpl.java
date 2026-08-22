package com.birder.bird_observation_project.services.implimentation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.birder.bird_observation_project.dtos.ObservationDto;
import com.birder.bird_observation_project.exceptions.ObservationNotFoundException;
import com.birder.bird_observation_project.mappers.ObservationMapper;
import com.birder.bird_observation_project.models.Observation;
import com.birder.bird_observation_project.repositories.ObservationRepository;
import com.birder.bird_observation_project.services.ObservationService;

@Service
public class ObservationServiceImpl implements ObservationService{
    private ObservationRepository observationRepository;

    public ObservationServiceImpl(ObservationRepository observationRepository){
        this.observationRepository = observationRepository;
    }

    @Override
    public ObservationDto saveObservation(ObservationDto observationDto){
        Observation observation = ObservationMapper.toEntity(observationDto);
        observation = observationRepository.save(observation);
        return ObservationMapper.toDto(observation);
    }

    @Override
    public List<ObservationDto> getObservations(){
        List<Observation> observations = observationRepository.findAll();
        List<ObservationDto> observationDtos = ObservationMapper.listToDto(observations);
        return observationDtos;

    }

    @Override
    public ObservationDto getObservationById(int id){
        Observation observation = observationRepository.findById(id).orElseThrow(() -> new ObservationNotFoundException(id));
        return ObservationMapper.toDto(observation);
    }

    @Override
    public void deleteObservation(int id){
        Observation observation = observationRepository.findById(id).orElseThrow(() -> new ObservationNotFoundException(id));
        observationRepository.delete(observation);
    }
}
