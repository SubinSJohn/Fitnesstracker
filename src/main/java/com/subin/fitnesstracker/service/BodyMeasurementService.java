package com.subin.fitnesstracker.service;

import org.springframework.stereotype.Service;
import com.subin.fitnesstracker.repository.BodyMeasurementRepository;
import com.subin.fitnesstracker.dto.BodyMeasurementDto;
import com.subin.fitnesstracker.entity.BodyMeasurement;
import java.util.List;
import java.util.stream.Collectors;

import com.subin.fitnesstracker.entity.User;

import org.springframework.beans.factory.annotation.Autowired;


@Service
public class BodyMeasurementService{

    @Autowired
    private BodyMeasurementRepository bodyMeasurementRepository;

    public BodyMeasurement saveMeasurement(BodyMeasurement bodyMeasurement){
        return bodyMeasurementRepository.save(bodyMeasurement);
    }

    public List<BodyMeasurementDto> getMeasurementByUser(User user){
        List<BodyMeasurement> bodyMeasurements = bodyMeasurementRepository.findByUser(user); 
        
        return bodyMeasurements.stream()
            .map(bodyMeasurement -> {
                BodyMeasurementDto bodyMeasurementDto = new BodyMeasurementDto();
                bodyMeasurementDto.setId(bodyMeasurement.getId());
                bodyMeasurementDto.setRecordedAt(bodyMeasurement.getRecordedAt());
                bodyMeasurementDto.setWeightKg(bodyMeasurement.getWeightKg());
                bodyMeasurementDto.setChestCm(bodyMeasurement.getChestCm());
                bodyMeasurementDto.setWaistCm(bodyMeasurement.getWaistCm());
                bodyMeasurementDto.setHipsCm(bodyMeasurement.getHipsCm());
                bodyMeasurementDto.setBicepCm(bodyMeasurement.getBicepCm());
                bodyMeasurementDto.setThighsCm(bodyMeasurement.getThighsCm());
                bodyMeasurementDto.setBodyFatPct(bodyMeasurement.getBodyFatPct());
                return bodyMeasurementDto;
            })
        .collect(Collectors.toList());

    }
    
}
