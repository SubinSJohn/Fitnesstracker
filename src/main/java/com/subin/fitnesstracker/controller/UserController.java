package com.subin.fitnesstracker.controller;

import com.subin.fitnesstracker.service.UserService;
import com.subin.fitnesstracker.entity.User;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController{
    

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public User register(@RequestBody User user){
        return userService.registerUser(user);
    }

    @GetMapping("/login/{username}")
    public ResponseEntity<?> login(@PathVariable String username) {
        String loggedInUser = SecurityContextHolder.getContext().getAuthentication().getName();
        if(!loggedInUser.equals(username))
            return ResponseEntity.status(403).body("Access denied");
        else 
            return ResponseEntity.ok(userService.findByUsername(username));
    }  
}
