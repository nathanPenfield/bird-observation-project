package com.birder.bird_observation_project.services.implimentation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.birder.bird_observation_project.dtos.LocationDto;
import com.birder.bird_observation_project.mappers.LocationMapper;
import com.birder.bird_observation_project.models.Location;
import com.birder.bird_observation_project.models.UserPrincipal;
import com.birder.bird_observation_project.repositories.LocationRepository;
import com.birder.bird_observation_project.repositories.UserRepository;
import com.birder.bird_observation_project.services.LocationService;

@Service
public class LocationServiceImpl implements LocationService{
    private LocationRepository locationRepository;
    private LocationMapper locationMapper;

    public LocationServiceImpl(LocationRepository locationRepository, UserRepository userRepository){
        this.locationRepository = locationRepository;
        this.locationMapper = new LocationMapper(userRepository);
    }
    
    @Override
    public List<LocationDto> getLocations(){
        List<Location> locations = locationRepository.findAll();
        List<LocationDto> locationDtos = LocationMapper.listToDto(locations);
        return locationDtos;
    }

    @Override
    public LocationDto createLocation(LocationDto locationDto, UserPrincipal user){
        Location location = locationMapper.toEntity(locationDto, user.getId());
        location = locationRepository.save(location);
        return LocationMapper.toDto(location);
    }
}
