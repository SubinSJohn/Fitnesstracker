package com.subin.fitnesstracker.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class BodyMeasurementDto{
    
    private Long id;
    private LocalDateTime recordedAt;
    private Double weightKg;
    private Double chestCm;
    private Double waistCm;
    private Double hipsCm;
    private Double bicepCm;
    private Double thighsCm;
    private Double bodyFatPct;
}
