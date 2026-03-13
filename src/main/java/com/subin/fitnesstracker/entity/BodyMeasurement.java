package com.subin.fitnesstracker.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.GeneratedValue;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "body_measurements")
public class BodyMeasurement{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false)
    private User user;

    @Column(updatable = false)
    private LocalDateTime recordedAt;

    @Column
    private Double weightKg;

    @Column
    private Double chestCm;

    @Column
    private Double waistCm;

    @Column
    private Double hipsCm;

    @Column
    private Double bicepCm;

    @Column
    private Double thighsCm;

    @Column
    private Double bodyFatPct;


    @PrePersist
    protected void recordTime(){
        recordedAt = LocalDateTime.now();
    }

}
