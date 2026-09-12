package com.birder.bird_observation_project.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.birder.bird_observation_project.models.User;
import com.birder.bird_observation_project.repositories.UserRepository;

@Service 
public class MyUserDetailsService implements UserDetailsService{
    @Autowired 
    private UserRepository userRepository;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        User user = userRepository.findByEmail(username).orElseThrow(()-> new UsernameNotFoundException("user not found with email: "+username));
        return new UserPrincipal(user.getId(), user.getEmail(), user.getPasswordHash(), List.of(() -> "ROLE_USER"));
    }
}
