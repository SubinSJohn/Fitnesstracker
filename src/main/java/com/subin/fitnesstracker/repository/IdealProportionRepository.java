package com.subin.fitnesstracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import com.subin.fitnesstracker.entity.IdealProportion;
import com.subin.fitnesstracker.entity.User;

@Repository
public interface IdealProportionRepository extends JpaRepository<IdealProportion, Long> {

    Optional<IdealProportion> findByGender(User.Gender gender);
}
