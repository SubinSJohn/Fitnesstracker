package com.subin.fitnesstracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.subin.fitnesstracker.entity.IdealProportion;
import com.subin.fitnesstracker.entity.User;
import com.subin.fitnesstracker.service.IdealProportionService;
import com.subin.fitnesstracker.service.UserService;

@RestController
@RequestMapping("/api/ideal-proportions")
public class IdealProportionController{
    
    @Autowired
    UserService userService;

    @Autowired
    IdealProportionService idealProportionService;

    @GetMapping("/user/{userId}")
    public IdealProportion idealProportion (@PathVariable Long userId) {
        User user = userService.findById(userId).orElseThrow();
        return idealProportionService.calculateIdealProportion(user);
    }
}
