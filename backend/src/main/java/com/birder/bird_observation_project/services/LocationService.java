package com.birder.bird_observation_project.services;

import java.util.List;

import com.birder.bird_observation_project.dtos.LocationDto;
import com.birder.bird_observation_project.models.UserPrincipal;

public interface LocationService {
    List<LocationDto> getLocations();
    LocationDto createLocation(LocationDto locationDto, UserPrincipal user);
} 
