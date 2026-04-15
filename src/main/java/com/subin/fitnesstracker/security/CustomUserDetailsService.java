package com.subin.fitnesstracker.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.subin.fitnesstracker.entity.User;
import com.subin.fitnesstracker.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{
    

    
    @Autowired
    UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username){

        User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return org.springframework.security.core.userdetails.User
            .withUsername(user.getUsername())
            .password(user.getPassword())
            .build();
    }
}
