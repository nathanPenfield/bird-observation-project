package com.birder.bird_observation_project.mappers;

import java.util.ArrayList;
import java.util.List;

import com.birder.bird_observation_project.dtos.LocationDto;
import com.birder.bird_observation_project.exceptions.UserNotFoundException;
import com.birder.bird_observation_project.models.Location;
import com.birder.bird_observation_project.models.User;
import com.birder.bird_observation_project.models.Visibility;
import com.birder.bird_observation_project.repositories.UserRepository;


public class LocationMapper {
    private UserRepository userRepository;

    public LocationMapper(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public Location toEntity(LocationDto dto, long user_id){
        User user = userRepository.findById(user_id).orElseThrow(() -> new UserNotFoundException("Error creating location: User not found"));
        Location location = new Location(dto.getId(), dto.getName(), dto.getLatitude(), dto.getLongitude());
        location.setVisibility(Visibility.PRIVATE);
        location.setUser(user);
        return location;
    }
    public static LocationDto toDto(Location location){
        return new LocationDto(location.getId(), location.getName(), location.getLatitude(), location.getLongitude());
    }
    public static List<LocationDto> listToDto(List<Location> locations){
        List<LocationDto> dtoList = new ArrayList<>();
    
        for(int i = 0 ; i < locations.size() ; i++){
            Location location = locations.get(i);
            dtoList.add(new LocationDto(location.getId(), location.getName(), location.getLatitude(), location.getLongitude()));
        }

        return dtoList;
    }
}
