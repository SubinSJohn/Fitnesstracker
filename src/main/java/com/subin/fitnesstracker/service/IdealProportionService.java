package com.subin.fitnesstracker.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.subin.fitnesstracker.entity.IdealProportion;
import com.subin.fitnesstracker.entity.User;
import com.subin.fitnesstracker.repository.IdealProportionRepository;

@Service
public class IdealProportionService{

    @Autowired
    private IdealProportionRepository idealProportionRepository;
    
    public Optional<IdealProportion> findByGender(User.Gender gender){
        return idealProportionRepository.findByGender(gender);
    }

    public IdealProportion calculateIdealProportion(User user){
        
        IdealProportion reference = findByGender(user.getGender()).orElseThrow();
        
        double ratio = user.getHeightCm()/reference.getReferenceHeightCm();
        
        IdealProportion calculated = new IdealProportion();
        
        calculated.setReferenceWeightKg(reference.getReferenceWeightKg()*ratio);
        calculated.setReferenceChestCm(reference.getReferenceChestCm()*ratio);
        calculated.setReferenceWaistCm(reference.getReferenceWaistCm()*ratio);
        calculated.setReferenceHipsCm(reference.getReferenceHipsCm()*ratio);
        calculated.setReferenceBicepCm(reference.getReferenceBicepCm()*ratio);
        calculated.setReferenceThighsCm(reference.getReferenceThighsCm()*ratio);

        return calculated; 
        

    }

}
