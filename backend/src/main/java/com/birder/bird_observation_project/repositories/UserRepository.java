package com.birder.bird_observation_project.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.birder.bird_observation_project.models.User;

public interface UserRepository extends JpaRepository<User,Long>{
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
}
