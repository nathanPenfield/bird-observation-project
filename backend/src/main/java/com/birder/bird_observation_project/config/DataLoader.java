package com.birder.bird_observation_project.config;

import java.io.InputStream;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.birder.bird_observation_project.models.Location;
import com.birder.bird_observation_project.models.Species;
import com.birder.bird_observation_project.repositories.LocationRepository;
import com.birder.bird_observation_project.repositories.SpeciesRepository;

import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

@Configuration
public class DataLoader {
    @Bean
    CommandLineRunner loadSpecies(SpeciesRepository repository, ObjectMapper objectMapper){
        return args -> {
            // if db has bird data, skip 
            if(repository.count() > 0){
                return;
            }
            
            // load seed bird data into db
            try (InputStream input = new ClassPathResource("michigan-birds.json").getInputStream()){
                List<Species> species = objectMapper.readValue(input, new TypeReference<List<Species>>() {});
                repository.saveAll(species);
            }
        };
    }

    @Bean
    CommandLineRunner loadLocations(LocationRepository repository, ObjectMapper objectMapper){
        return args -> {
            // if db has location data, skip 
            if(repository.count() > 0){
                return;
            }
            
            // load seed location data into db
            try (InputStream input = new ClassPathResource("test-locations.json").getInputStream()){
                List<Location> locations = objectMapper.readValue(input, new TypeReference<List<Location>>() {});
                repository.saveAll(locations);
            }
        };
    }
}
