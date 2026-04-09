package com.subin.fitnesstracker.controller;

import java.util.Optional;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import com.subin.fitnesstracker.entity.BodyMeasurement;
import com.subin.fitnesstracker.service.BodyMeasurementService;
import com.subin.fitnesstracker.service.UserService;
import com.subin.fitnesstracker.entity.User;

@RestController
@RequestMapping("/api/measurement")
public class BodyMeasurementController{
    
    @Autowired
    BodyMeasurementService bodyMeasurementService;

    @Autowired
    UserService userService;


    @PostMapping("/save")
    public BodyMeasurement save(@RequestBody BodyMeasurement bodyMeasurement){
        return bodyMeasurementService.saveMeasurement(bodyMeasurement);
    }


    @GetMapping("/user/{userId}")
    public List<BodyMeasurement> getBodyMeasurement(@PathVariable Long userId){
       User user  = userService.findById(userId).orElseThrow();
       return bodyMeasurementService.getMeasurementByUser(user);

    }
}
