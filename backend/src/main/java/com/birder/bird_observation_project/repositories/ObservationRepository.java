package com.birder.bird_observation_project.repositories;

import com.birder.bird_observation_project.models.Observation;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ObservationRepository extends JpaRepository<Observation,Long>{
    
}
