package com.subin.fitnesstracker.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "ideal_proportions")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IdealProportion{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private User.Gender gender;

    @Column(nullable = false)
    private Double referenceHeightCm;

    @Column(nullable = false)
    private Double referenceWeightKg;

    @Column(nullable = false)
    private Double referenceChestCm;

    @Column(nullable = false)
    private Double referenceWaistCm;

    @Column(nullable = false)
    private Double referenceHipsCm;

    @Column(nullable = false)
    private Double referenceBicepCm;

    @Column(nullable = false)
    private Double referenceThighsCm;


}

