package com.subin.fitnesstracker.service;

import org.springframework.stereotype.Service;
import com.subin.fitnesstracker.repository.BodyMeasurementRepository;
import com.subin.fitnesstracker.entity.BodyMeasurement;
import java.util.List;
import com.subin.fitnesstracker.entity.User;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class BodyMeasurementService{

    @Autowired
    private BodyMeasurementRepository bodyMeasurementRepository;

    public BodyMeasurement saveMeasurement(BodyMeasurement bodyMeasurement){
        return bodyMeasurementRepository.save(bodyMeasurement);
    }

    public List<BodyMeasurement> getMeasurementByUser(User user){
        return bodyMeasurementRepository.findByUser(user); 
    }
    
}
