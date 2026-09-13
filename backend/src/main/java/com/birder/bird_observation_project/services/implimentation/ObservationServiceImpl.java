package com.birder.bird_observation_project.services.implimentation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.birder.bird_observation_project.dtos.ObservationCreationDto;
import com.birder.bird_observation_project.dtos.ObservationDto;
import com.birder.bird_observation_project.exceptions.ObservationNotFoundException;
import com.birder.bird_observation_project.mappers.ObservationMapper;
import com.birder.bird_observation_project.models.Observation;
import com.birder.bird_observation_project.models.UserPrincipal;
import com.birder.bird_observation_project.repositories.LocationRepository;
import com.birder.bird_observation_project.repositories.ObservationRepository;
import com.birder.bird_observation_project.repositories.SpeciesRepository;
import com.birder.bird_observation_project.repositories.UserRepository;
import com.birder.bird_observation_project.services.ObservationService;

@Service
public class ObservationServiceImpl implements ObservationService{
    private ObservationRepository observationRepository;
    private ObservationMapper observationMapper;

    public ObservationServiceImpl(ObservationRepository observationRepository, SpeciesRepository speciesRepository,LocationRepository locationRepository,UserRepository userRepository){
        this.observationRepository = observationRepository;  
        this.observationMapper = new ObservationMapper(speciesRepository,locationRepository,userRepository);
    }

    @Override
    public void saveObservation(ObservationCreationDto observationCreationDto, UserPrincipal user){
        Observation observation = observationMapper.toEntity(observationCreationDto, user.getId());
        observation = observationRepository.save(observation);
    }

    @Override
    public List<ObservationDto> getObservations(UserPrincipal user){
        List<Observation> observations = observationRepository.findByUserId(user.getId());
        List<ObservationDto> observationDtos = observationMapper.listToDto(observations);
        return observationDtos;

    }

    @Override
    public ObservationDto getObservationById(Integer id, UserPrincipal user){
        Observation observation = observationRepository.findById(id).orElseThrow(() -> new ObservationNotFoundException(id));
        if (observation.getUser().getId() == user.getId()){
            return observationMapper.toDto(observation);
        }else{
            throw new ObservationNotFoundException(id);
        }
    }

    @Override
    public void deleteObservation(Integer id, UserPrincipal user){
        Observation observation = observationRepository.findById(id).orElseThrow(() -> new ObservationNotFoundException(id));
        if (observation.getUser().getId() == user.getId()){
            observationRepository.delete(observation);
        }else{
            throw new ObservationNotFoundException(id);
        } 
    }
    @Override 
    public void updateObservation(Integer id, ObservationCreationDto observationCreationDto, UserPrincipal user){
        Observation observation = observationMapper.toEntity(observationCreationDto, user.getId());
        if (observationRepository.existsById(id) && observation.getUser().getId() == user.getId()){
            observation.setId(id);
            observation = observationRepository.save(observation);
        }else{
            throw new ObservationNotFoundException(id);
        }
    }
}
