package com.birder.bird_observation_project.mappers;

import java.util.ArrayList;
import java.util.List;

import com.birder.bird_observation_project.dtos.LocationDto;
import com.birder.bird_observation_project.models.Location;


public class LocationMapper {
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
