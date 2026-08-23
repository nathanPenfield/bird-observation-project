package com.birder.bird_observation_project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.birder.bird_observation_project.models.Species;


public interface SpeciesRepository extends JpaRepository<Species,Integer>{
    
}
