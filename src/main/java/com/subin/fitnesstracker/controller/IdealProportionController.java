package com.subin.fitnesstracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.subin.fitnesstracker.entity.IdealProportion;
import com.subin.fitnesstracker.entity.User;
import com.subin.fitnesstracker.service.IdealProportionService;
import com.subin.fitnesstracker.service.UserService;

import ch.qos.logback.core.model.conditional.ElseModel;

@RestController
@RequestMapping("/api/ideal-proportions")
public class IdealProportionController{
    
    @Autowired
    UserService userService;

    @Autowired
    IdealProportionService idealProportionService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> idealProportion (@PathVariable Long userId) {
        String loggedInUser = SecurityContextHolder.getContext().getAuthentication().getName(); 
        User user = userService.findById(userId).orElseThrow();

        if(!loggedInUser.equals(user.getUsername()))
                return ResponseEntity.status(403).body("Access Denied");
        else 
                return ResponseEntity.ok(idealProportionService.calculateIdealProportion(user));
    }
}
