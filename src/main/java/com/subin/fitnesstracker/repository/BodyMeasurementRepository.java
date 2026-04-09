package com.subin.fitnesstracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.subin.fitnesstracker.entity.BodyMeasurement;
import com.subin.fitnesstracker.entity.User;

import java.util.List;

@Repository
public interface BodyMeasurementRepository extends JpaRepository<BodyMeasurement, Long> {
    
    List<BodyMeasurement> findByUser(User user);

}
